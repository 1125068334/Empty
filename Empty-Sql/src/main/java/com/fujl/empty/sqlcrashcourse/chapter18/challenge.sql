-- 1.
select customers.* from customers right join orders o on customers.cust_id = o.cust_id;

create view customerswithorders as
select customers.*
from customers
         right join orders o on customers.cust_id = o.cust_id;

select customers.*
from customers
         join orders o on customers.cust_id = o.cust_id;

select * from customerswithorders;


-- 2.
create view orderitemsexpanded as
select order_num, prod_id, quantity,item_price, quantity * item_price as expanded_price
from orderitems
order by order_num;

select * from orderitemsexpanded;

