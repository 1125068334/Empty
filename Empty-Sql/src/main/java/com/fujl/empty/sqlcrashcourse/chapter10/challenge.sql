-- 1.
select order_num, count(*) as order_lines from orderitems group by order_num order by order_lines;

-- 2.
select prod_name as cheapest_item ,min(prod_price) as cheapest_price from products group by prod_name order by cheapest_price;

-- 3.
select order_num,sum(order_num) from orderitems group by order_num having sum(order_num) >= 100;

-- 4.
select order_num, sum(quantity * item_price) as amt
from orderitems
group by order_num
having amt >= 1000
order by order_num;

-- 5.
select order_num, count(*) as items from orderitems group by order_num having count(*) >= 3 order by items,order_num;