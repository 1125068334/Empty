/**
    13-3: 使用带聚集函数的联结

 */

 select * from customers;
select count(order_num) from orders;

select customers.cust_id, count(o.order_num)
from customers
         inner join orders o on customers.cust_id = o.cust_id
group by customers.cust_id;


select customers.cust_id, count(o.order_num)
from customers
         left join orders o on customers.cust_id = o.cust_id
group by customers.cust_id;