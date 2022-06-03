-- 1.

select cust_id from orders where order_num in (
    select order_num from orderitems where item_price >= 10
    );

-- 2.
select cust_id,order_date
from orders
where order_num in (
    select order_num
    from orderitems
    where prod_id = 'BR01'
) order by order_date;

-- 3.
select order_num from orderitems;

select cust_id from customers;

select cust_id
from orders
where order_num in (
    select order_num
    from orderitems
    where prod_id = 'BR01'
);

select cust_email
from customers
where cust_id in (
    select cust_id
    from orders
    where order_num in (
        select order_num
        from orderitems
        where prod_id = 'BR01'
    )
);

-- 4.
select cust_id, (select sum(quantity*item_price) from orderitems where orderitems.order_num = orders.order_num) as total_orderd
from orders
order by total_orderd desc;

-- 5.
select prod_name, (select sum(quantity) from orderitems where orderitems.prod_id = products.prod_id) as quant_sold
from products order by quant_sold;


SELECT prod_name,
       (SELECT Sum(quantity)
        FROM OrderItems
        WHERE Products.prod_id=OrderItems.prod_id) AS quant_sold
FROM Products;