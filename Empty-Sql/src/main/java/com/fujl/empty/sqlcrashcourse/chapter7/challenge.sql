-- 1.
select vend_id, vend_name as vname, vend_address as vaddress, vend_city as vcity from vendors order by vname;

-- 2.
select prod_id, prod_price, prod_price*0.9 as sale_price from products order by sale_price;
