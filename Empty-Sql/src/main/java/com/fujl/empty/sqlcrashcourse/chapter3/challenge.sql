# 1.
select cust_name from customers order by cust_name desc;

# 2.
select cust_id,order_num from orders order by cust_id,order_date;

# 3.
select order_num,item_price from orderitems order by order_num desc,item_price desc;

# 4.
select vend_name from vendors order by vend_name desc;