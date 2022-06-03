/*
    13-2 使用不同类型的联结
        13-2-1 自联结
        tip: 使用自联结而不用子查询。 自联结通常作为外部语句，用来替代从相同表中检索数据的使用子查询语句。虽然最总的结果是相同的，但是
                许多DBMS处理联结远比处理子查询快得多。
        13-2-2 自然联结
             事实上，我们迄今为止简历的每个内联结都是自然联结，很可能永远都不会用到不是自然联结的内联结。
        13-2-3 外联结
             左联结(left outer join)/右联结(right outer join)/全外联结(full outer join)
             外联结包括没有关联的行，在使用outer join语法时，必须使用right或left关键字指定包括其所有行的表
                (right指出的是outer join右边的表，而left指出的是outer join左边的表)
 */

select c1.cust_id, c1.cust_name, c1.cust_contact
from customers c1,
     customers c2
where c1.cust_name = c2.cust_name
  and c2.cust_contact = 'Jim Jones';

-- 13-2-2
select C.*, O.order_num, O.order_date, OI.prod_id, OI.quantity, OI.item_price
from customers C,
     orders O,
     orderitems OI
where C.cust_id = O.cust_id
  and OI.order_num = O.order_num
  and prod_id = 'RGAN01';

-- 13-2-3
select customers.cust_id, o.order_num
from customers
         inner join orders o on customers.cust_id = o.cust_id;

select customers.cust_id, o.order_num
from customers
         left outer join orders o on customers.cust_id = o.cust_id
order by cust_id;