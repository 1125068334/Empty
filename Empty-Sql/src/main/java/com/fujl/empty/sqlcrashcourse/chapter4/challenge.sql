-- 1.
select prod_id,prod_name from products where prod_price = 9.49;

-- 2.
select prod_id,prod_name from products where prod_price >= 9.49;

-- 3.
select distinct order_num from orderitems where quantity >= 100;

-- 4.
select prod_name,prod_price from products where prod_price between 3 and 6 order by prod_price;