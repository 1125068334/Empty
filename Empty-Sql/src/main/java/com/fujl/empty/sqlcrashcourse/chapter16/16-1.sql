/**
    16-1: 更新/修改表中的数据，可以使用UPDATE语句。有两种使用UPDATE的方式
        1. 更新表中的特定行
        2. 更新表中的所有行
        基本的UPDATE语句由三部分组成:
            1. 要更新的表
            2. 列名和它们的新值
            3. 确定要更新哪些行的过滤条件

        warn: 不要省略where子句
 */
-- update single row
update customers
set cust_email = 'kim@thetoystore.com'
where cust_id = 1000000005;

-- update several rows
update customers
set cust_contact = 'Sam Roberts',
    cust_email   = 'sam@toyland.com'
where cust_id = 1000000005;


