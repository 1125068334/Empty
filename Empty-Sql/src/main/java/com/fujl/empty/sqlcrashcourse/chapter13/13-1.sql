/**
    13-1: 使用表别名
        SQL除了可以对列名合计算字段使用别名，还允许给表明起别名。
            reason: 1. 缩短SQL语句  2. 允许在一条SELECT语句中多次使用相同的表。
        tip:
            1. Oracle没有AS
            2. 表别名只在查询执行中使用，与列别名不一样，表别名不返回到客户端
 */

select trim(vend_name) + '(' + rtrim(vend_country) + ')' as vend_title
from vendors
order by vend_name;


select cust_name, cust_contact
from customers as c,
     orders as o,
     orderitems as oi
where c.cust_id = o.cust_id
  and oi.order_num = o.order_num
  and prod_id = 'RGAN01';


select cust_email
from customers
where cust_contact in (select cust_contact from customers where cust_name = 'Jim Jones');

select cust_id, cust_name, cust_contact
from customers
where cust_name = (select cust_name from customers where cust_contact = 'Jim Jones');

