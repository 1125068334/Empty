/*
4.1 使用where子句
tip:
    1. 结果可能是 3.49，3.490，3.4900等，往往是因为DBMS指定了所使用的数据类型及其默认行为
    2. sql过滤和应用过滤思考
    3. where子句的位置：在同时使用order by 和 where 子句时,应该让order by位于where后
*/

select prod_name,prod_price from products where prod_price = 3.49;