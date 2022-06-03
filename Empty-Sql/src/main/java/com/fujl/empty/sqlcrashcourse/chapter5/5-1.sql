/*
   5.1 组合where子句

   tip:
     1. 操作符(operator) 用来联结或改变where子句中的子句的关键字，也称逻辑操作符(logical operator)

*/
-- 5.1.1 and操作符 用在where子句中的关键字，用来指示检索满足所有给定条件的行
select prod_id,prod_price,prod_name from products where vend_id = 'DLL01' and prod_price <= 4;

-- 5.1.2 or操作符  用在where子句中的关键字，用来表示检索匹配任一给定条件的行
select prod_id, prod_price, prod_name
from products
where vend_id = 'DLL01'
   or vend_id = 'BRS01';

-- 5.1.3 求值顺序
--  在处理or操作符前，优先处理and操作符，and优先级更高
select prod_name,prod_price,vend_id from products where vend_id='DLL01' or vend_id = 'BRS01' and prod_price >= 10;

select prod_name,prod_price,vend_id from products where (vend_id='DLL01' or vend_id = 'BRS01') and prod_price >= 10;
