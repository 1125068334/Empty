-- 1.
-- Equijoin syntax
select cust_name, order_num from customers,orders where orders.cust_id=customers.cust_id order by cust_name,order_num;
-- ANSI INNER JOIN SYNTAX
select cust_name, order_num
from customers
         inner join orders o on customers.cust_id = o.cust_id
order by cust_name, order_num;

-- 2.
-- Solution using subqueries
SELECT cust_name,
       order_num,
       (SELECT Sum(item_price*quantity)
        FROM OrderItems
        WHERE Orders.order_num=OrderItems.order_num) AS OrderTotal
FROM Customers, Orders
WHERE Customers.cust_id = Orders.cust_id
ORDER BY cust_name, order_num;

-- Solution using joins
SELECT cust_name,
       Orders.order_num,
       Sum(item_price*quantity) AS OrderTotal
FROM Customers, Orders, OrderItems
WHERE Customers.cust_id = Orders.cust_id
  AND Orders.order_num = OrderItems.order_num
GROUP BY cust_name, Orders.order_num
ORDER BY cust_name, order_num;

-- 3.
select a.cust_id, order_date
from orders a,
     orderitems b
where a.order_num = b.order_num
  and b.prod_id = 'BR01' order by order_date;


-- 4.
select cust_email from customers;

select order_num from orderitems;

select order_date from orders;

select cust_email
from customers a
         inner join orders o on a.cust_id = o.cust_id
         inner join orderitems o2 on o.order_num = o2.order_num
where o2.prod_id = 'BR01';

-- 5.

-- Equijoin syntax
SELECT cust_name, SUM(item_price*quantity) AS total_price
FROM Customers, Orders, OrderItems
WHERE Customers.cust_id = Orders.cust_id
  AND Orders.order_num = OrderItems.order_num
GROUP BY cust_name HAVING SUM(item_price*quantity) >= 1000
ORDER BY cust_name;

-- ANSI INNER JOIN syntax
SELECT cust_name, SUM(item_price*quantity) AS total_price
FROM Customers
         INNER JOIN Orders ON Customers.cust_id = Orders.cust_id
         INNER JOIN OrderItems ON Orders.order_num = OrderItems.order_num
GROUP BY cust_name
HAVING SUM(item_price*quantity) >= 1000
ORDER BY cust_name;

-- 6.



