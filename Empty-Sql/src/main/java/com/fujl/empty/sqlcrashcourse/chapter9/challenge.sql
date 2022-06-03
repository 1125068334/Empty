-- 1.
select sum(quantity) from orderitems;

-- 2.
select count(prod_id) as prod_item from orderitems where prod_id = 'BR01';

select * from orderitems;

-- 3.
select max(prod_price) as max_price from products where prod_price <= 10;