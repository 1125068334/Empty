package com.fujl.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.sql.*;
import java.util.*;

@Slf4j
public class JdbcEmpty {

    private static final String p_driver = "com.aliyun.polardb.Driver";
    private static final String p_url = "jdbc:polardb://59.202.48.28:3306/kjhs_boss_p?searchpath=public&UseServerSidePrepare=1&stringtype=unspecified";
    private static final String p_user = "kjhs_boss_b";
    private static final String p_pass = "kjhs_boss_b";

    private static final String m_driver = "com.mysql.cj.jdbc.Driver";
    private static final String m_url = "jdbc:mysql://127.0.0.1:3306/";
    private static final String m_user = "root";
    private static final String m_pass = "123456";

    private static final String SUBJECT_VALUES = " subcode,subname,parentcode,year,debcre,isleaf,version,insertdate,updatedate,enterguid,amount";


    public static void main(String[] args) throws SQLException {
        List<Map<String,Object>> queryData = queryAcoData();
        if (!CollectionUtils.isEmpty(queryData)) {
            int i = insertAcoData(queryData);
            System.out.println(i);
        }

    }

    private static String buildInsertSql(List<Map<String, Object>> dataList) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into mad_subject (").append(SUBJECT_VALUES).append(") values");
        for (Map<String, Object> data : dataList) {
            sb.append("(")
                    .append(data.get("aco_code")).append(",")
                    .append(data.get("aco_name,")).append(",")
                    .append(data.get("parent_code,")).append(",")
                    .append(data.get("fiscal,")).append(",")
                    .append(data.get("")).append(",")
                    .append(data.get("is_leaf,")).append(",")
                    .append(data.get("")).append(",")
                    .append(data.get("version")).append(",")
                    .append(data.get("create_time")).append(",")
                    .append(data.get("modified_time")).append(",")
                    .append(data.get("bal_amt")).append(")");
            if (dataList.indexOf(data) != dataList.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static ResultSet insertData(){



        return null;
    }

    public static String queryAcoSql(){
        String sql;
        sql = "select fiscal,mof_div_code,agy_code,acb_code,aco_code,aco_name," +
                "(select parent_code from mad_aco aco where aco.mad_code = gal_balance.aco_code and aco.agy_code=gal_balance.agy_code and aco.fiscal=gal_balance.fiscal) as parent_code ," +
//                "(select parent_code from mad_aco aco where mof_div_code = '330782' and aco.mad_code = gal_balance.aco_code and aco.agy_code=gal_balance.agy_code and aco.fiscal=gal_balance.fiscal) as parent_code ," +
                " case when aco_code like '1%' then 'D' else 'C' end as dr_cr, 1 as isleaf, now() as vesion, case when aco_code like '1%' then dr_amt else cr_amt end as bal_amt from gal_balance " +
                "where fiscal = 2021 limit 10,10 ";
//                "where fiscal = 2021 and (aco_code like '1%' or aco_code like '2%') limit 10,0 ";
        return sql;
    }

    public static String insertAcoSql(){
        String sql;
        sql = "insert into one_column(id) values('"+ UUID.randomUUID()+"')";
        return sql;
    }

    public static int insertAcoData(List<Map<String, Object>> dataList) throws SQLException {
        Connection conn = getConnection(m_driver, m_url+"study", m_user, m_pass);
        PreparedStatement ps = conn.prepareStatement(buildInsertSql(dataList));
        int i = ps.executeUpdate();
        return i;
    }

    public static List<Map<String,Object>> queryAcoData(){
//        Connection conn = getConnection(p_driver, p_url, p_user, p_pass);
        Connection conn = getConnection(m_driver, m_url+"pitaya_earth", m_user, m_pass);
        try {
            PreparedStatement ps = conn.prepareStatement(queryAcoSql());
            ResultSet queryData = ps.executeQuery();
            List<Map<String,Object>> dataList = new ArrayList<>();
            ResultSetMetaData metaData = queryData.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (queryData.next()) {
                Map<String, Object> rowData = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(metaData.getColumnName(i),queryData.getObject(i));
                }
                dataList.add(rowData);
            }
            return dataList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn, null, null);
        }
        return null;
    }

    public static Connection getConnection(String driver, String url, String user, String password) {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn, Statement st, ResultSet rs) {
        //关闭资源
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            log.error(" rs close failed", e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
                log.error("st close failed", e);
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (Exception e) {
                    log.error("conn close failed", e);
                }
            }
        }
    }
}
