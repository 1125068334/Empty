-- 1.
select cust_id,
       cust_name                                                          as customer_name,
       upper(concat(substr(cust_contact, 1, 2), substr(cust_city, 1, 3))) as user_login
from customers;


SELECT cust_id,
       cust_name,
       CONCAT(UPPER(LEFT(cust_contact, 2)), UPPER(LEFT(cust_city, 3))) AS user_login
FROM customers;

-- 2.
select order_num, order_date from orders where year(order_date) = 2020 and month(order_date) = 1 order by order_date;

