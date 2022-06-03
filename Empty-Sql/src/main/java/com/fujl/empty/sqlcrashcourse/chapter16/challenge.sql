-- 1.
select vend_state, cust_state from vendors,customers;
update vendors a,customers b
set a.vend_state = upper(a.vend_state),
    b.cust_state= upper(b.cust_state)
where a.vend_country = b.cust_country
  and a.vend_country = 'USA';

select upper('aaa');

-- 2.
delete from customers where cust_id = '123456';

select * from customers where cust_id = '123456';
