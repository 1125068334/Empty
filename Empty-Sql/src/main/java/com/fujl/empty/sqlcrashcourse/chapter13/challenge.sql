-- 1.
select a.cust_name, o.order_num
from customers a
         inner join orders o on a.cust_id = o.cust_id;

-- 2.
select a.cust_name
from customers a
         left join orders o on a.cust_id = o.cust_id;

-- 3.
select products.prod_name, o.order_num
from products
         left outer join orderitems o on products.prod_id = o.prod_id
order by prod_name;

-- 4.
select products.prod_name, count(o.order_num) totalOrderNum
from products
         left outer join orderitems o on products.prod_id = o.prod_id
group by products.prod_name
order by prod_name;

-- 5.
select v.vend_id, count(p.prod_id) prodNum
from vendors v
         left join products p on v.vend_id = p.vend_id
group by v.vend_id order by prodNum;