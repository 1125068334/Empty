/**
    18-2: 创建视图
        视图创建CREATE VIEW语句来创建. CREATE VIEW只能用于创建不存在的视图
        desc: 视图重命名
            删除视图，可以使用drop语句，其语法为drop view viewname; 覆盖(更新)视图，必须先删除它，然后再重新创建。
        18-2-1: 利用视图简化复杂的联结
            视图极大地简化了复杂SQL语句的使用。利用视图，可一次性编写基础的SQL，然后根据需要多次使用。
            tip: 创建可重用的视图
                创建不绑定特定数据的视图是一种好办法。扩展视图的范围不仅使得它能被重用，而且可能更有用。这样做不需要创建和维护多个类似视图。
        18-2-2: 用视图重新格式化检索出的数据
            视图的另一常见用途是重新格式化检索出的数据。
            desc: select约束全部适用
        18-2-3: 用视图过滤不想要的数据
            视图对于应用普通的where子句也很有用
            desc: where子句和where子句，从视图检索数据时如果使用了一条where子句，则两组子句(一组在视图中，一组是传递给视图的)将自动组合
        18-2-4: 使用视图与计算字段
            在简化计算字段的使用上，视图也特别有用。

 */

-- create view
create view ProductCustomers as
    select cust_name, cust_contact, prod_id
    from customers, orders, orderitems
    where customers.cust_id = orders.cust_id
    and orderitems.order_num = orders.order_num;
-- select from view
select * from productcustomers;


-- select from table
select concat(rtrim(vend_name), '(', rtrim(vend_country), ')') as vend_title
from vendors
order by vend_name;

-- create view
create view vendorlocations as
select concat(rtrim(vend_name), '(', rtrim(vend_country), ')') as vend_title
from vendors
order by vend_name;

-- select from view
select * from vendorlocations;

-- create view
create view customerEMailList as
    select cust_id, cust_name, cust_email
    from customers where cust_email is not null;
select * from customerEMailList;

-- select from table
select prod_id, quantity, item_price, quantity * orderitems.item_price as expanded_price
from orderitems
where order_num = 20008;

create view orderitemsexpanded as
select order_num,prod_id, quantity, item_price, quantity * orderitems.item_price as expanded_price
from orderitems;

select * from orderitemsexpanded where order_num = 20008;