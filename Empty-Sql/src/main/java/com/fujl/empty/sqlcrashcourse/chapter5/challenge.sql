-- 1.
select vend_name from vendors where vend_country = 'USA' and vend_state = 'CA';

-- 2.
select order_num,prod_id from orderitems where quantity >= 100 and (prod_id in ('BR01','BR02','BR03'));

-- 3.
select prod_name,prod_price from products where prod_price >= 3 and prod_price <= 6 order by prod_price;

-- 4.
select vend_name
from vendors
where vend_country = 'USA' and vend_state = 'CA'
order by vend_name;