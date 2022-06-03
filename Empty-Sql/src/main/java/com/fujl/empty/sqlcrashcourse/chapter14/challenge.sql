-- 1.
select prod_id, quantity
from orderitems
where quantity = 100
union
select prod_id, quantity
from orderitems
where prod_id like 'BNBG%'
order by prod_id;

-- 2.
select prod_id, quantity
from orderitems
where quantity = 100
  or prod_id like 'BNBG%'
order by prod_id;

-- 3.
select prod_name from products
union
select cust_name from customers
order by prod_name;

