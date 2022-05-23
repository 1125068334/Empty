package com.fujl.redis;

import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class RedisLockTest {


    public static final String url = "jdbc:mysql://127.0.0.1:3306/ly?characterEncoding=UTF-8";

    public static final String name = "com.mysql.jdbc.Driver";

    public static final String user = "root";

    public static final String password = "";


    public static void main(String[] args) {

        Integer count = 50;
        while (count > 0) {
            count--;
            new Thread(() -> {
                Jedis jedis = new Jedis("127.0.0.1", 6379);
                jedis.auth("123456");
                String lock = lock(jedis);
                if (lock != null) {
                    Statement statement = null;
                    Connection conn = null;
                    ResultSet resultSet = null;
                    try {
                        Class.forName(name);// 指定连接类型
                        conn = DriverManager.getConnection(url, user, password);// 获取连接
                        statement = (Statement) conn.createStatement();// 准备执行语句
                        String querySql = "SELECT id,name,count FROM production WHERE id=2";
                        resultSet = statement.executeQuery(querySql);
                        int count1 = 0;
                        while (resultSet.next()) {
                            System.out.println(Thread.currentThread().getName() + "抢到了锁 id: " + resultSet.getString("id")
                                    + " name: " + resultSet.getString("name")
                                    + " count: " + resultSet.getString("count"));
                            count1 = Integer.valueOf(resultSet.getString("count"));
                        }
                        String updateSql = "UPDATE production SET count=" + (count1 - 1)
                                + " WHERE id=2";
                        int rows = statement.executeUpdate(updateSql);
                        if (rows > 0) {
                            System.out.println("更新成功" + Thread.currentThread().getName() + "  库存剩余：" + (count1 - 1));
                            System.out.println(Thread.currentThread().getName() + " === > >开始解锁");
                            boolean unlock = unlock(jedis, lock);
                            if (unlock)
                                System.out.println(Thread.currentThread().getName() + " === > >解锁成功");
                        } else {
                            System.out.println("更新失败" + Thread.currentThread().getName());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (conn != null)
                                conn.close();
                            if (statement != null)
                                statement.close();
                            if (resultSet != null)
                                resultSet.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "线程" + count).start();
        }
    }

    public static String lock(Jedis jedis) {
        try {
            while (true) {
                String lockTime = Long.valueOf(jedis.time().get(0)) + 5 + "";
                if (jedis.setnx("lock", lockTime) == 1) {
                    jedis.expire("lock", 5);
                    return lockTime;
                }
                String lock = jedis.get("lock");
                if (!StringUtils.isEmpty(lock) && Long.valueOf(lock) < Long.valueOf(jedis.time().get(0))) {
                    String oldLockTime = jedis.getSet("lock", lockTime);
                    if (!StringUtils.isEmpty(oldLockTime) && oldLockTime.equals(lock)) {
                        return lockTime;
                    }
                }
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean unlock(Jedis jedis, String lockTag) {
        if (lockTag.equals(jedis.get("lock"))) {
            jedis.del("lock");
            return true;
        }
        return false;
    }
}