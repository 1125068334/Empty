-- 1.
select prod_name,prod_desc from products where prod_desc like '%toy%';

-- 2.
select prod_name, prod_desc from products where prod_desc not like '%toy%' order by prod_name;

-- 3.
select prod_name, prod_desc from products where prod_desc like '%toy%' and prod_desc like '%carrots%';

-- 4.
select prod_name, prod_desc from products where prod_desc like '%toy%carrots%';
