-- 1.
insert into customers(cust_id, cust_name, cust_address, cust_city)
VALUES (123456,
        'xiaofu',
        'BJ',
        'BJ');

-- 2.
create table orderscopy
as
select *
from orders;

create table orderitemscopy
as
select *
from orderitems;
