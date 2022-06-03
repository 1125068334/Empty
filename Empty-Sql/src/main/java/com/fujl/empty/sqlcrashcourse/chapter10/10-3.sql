/**
    10-3: 过滤分组
        规定包括哪些分组，排除哪些分组。
        where过滤指定的的是行而不是分组，事实上where没有分组的概念。
        Having子句
            having支持所有where操作符
            having和where的差别：
                    where在数据分组前进行过滤，having在数据分组后进行过滤。
                    where排除的行不包括在分组中。这可能会改变计算值，从而影响having子句中基于这些值过滤掉的分组
            使用having和where
                having和where非常类似，如果不指定group by，则大多数DBMS会同等对待它们。不过，你自己要能区分一点，使用having
                    时该结合group by子句，而where子句用于标准的行级过滤
  */

select cust_id, count(*) as orders
from orders
group by cust_id
having count(*) >= 2;

select vend_id,count(*) as num_prods from products where prod_price >= 4 group by vend_id having count(*) >=2;

select vend_id,count(*) as num_prods from products group by vend_id having count(*) >=2;

