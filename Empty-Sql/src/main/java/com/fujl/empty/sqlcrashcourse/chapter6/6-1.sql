/*
   6.1 LIKE操作符
       tip:
        1. 通配符(wildcard) 用来匹配值的一部分的特殊字符-- 只能用于文本字段(字符串)
        2. 搜索模式(search pattern) 由字面值、通配符或两者组合构成的搜索条件
*/
-- 6.1.1 百分号(%)通配符
select prod_id, prod_name from products where prod_name like 'fish%';-- 根据DBMS的不同及其配置,搜索可以是区分大小写的

select prod_id, prod_name from products where prod_name like '%bean bag%';

select prod_name from products where prod_name like 'F%y';

    -- a. 有些DBMS用空格来填补字段的内容  b. 通配符% 不能匹配NULL

-- 6.1.2 下划线(_)通配符  : 匹配单个字符,DB2不支持通配符_
select prod_id, prod_name from products where prod_name like '_ inch %';

-- 6.1.3 方括号([])通配符 : 方括号通配符用来指定一个字符集,它必须匹配指定位置(通配符的位置)的一个字符
    -- 需要注意: SQLServer支持，mysql/oracle/db2/SQLite不支持
select cust_contact from customers where cust_contact like '[JM]%' order by cust_contact;





-- 5.1.2 or操作符  用在where子句中的关键字，用来表示检索匹配任一给定条件的行
select prod_id, prod_price, prod_name
from products
where vend_id = 'DLL01'
   or vend_id = 'BRS01';

-- 5.1.3 求值顺序
--  在处理or操作符前，优先处理and操作符，and优先级更高
select prod_name,prod_price,vend_id from products where vend_id='DLL01' or vend_id = 'BRS01' and prod_price >= 10;

select prod_name,prod_price,vend_id from products where (vend_id='DLL01' or vend_id = 'BRS01') and prod_price >= 10;
