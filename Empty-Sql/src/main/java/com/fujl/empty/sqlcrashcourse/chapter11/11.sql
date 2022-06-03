/**
    11-1: 子查询
        查询(query): 任何SQL语句都是查询。但此术语一般指SELECT语句
        SQL还允许创建子查询(subquery),即嵌套在其他查询中的查询

    11-2: 利用子查询进行过滤
        select语句中，子查询总是从内向外处理。

    11-3: 作为计算字段使用子查询
        使用子查询的另一方法是创建计算字段。

    11-4: 小结
        子查询常用于where子句的in操作符中，以及用来填充列。

    tip:
        1. 格式化SQL, 包含子查询的select语句难以阅读和调试，它们在较为复杂时更是如此。
           如上所示，把子查询分解为多行并进行适当的缩进，能极大简化子查询的使用。 这就是颜色编码起作用的地方。
    warn:
        1. 作为子查询的select语句只能查询单个列。企图检索多个列将返回错误。
        2. 子查询和性能。 使用子查询并不总是执行这类数据检索的最有效方法。
 */

select order_num from orderitems where prod_id = 'RGAN01';

select *
from customers
where cust_id in
      (select cust_id from orders where order_num in (select order_num from orderitems where prod_id = 'RGAN01'));


select cust_id from customers;
select cust_id, count(*) as order_num
from orders
where cust_id in (select cust_id from customers)
group by cust_id order by order_num;

select cust_name, cust_state, (select count(*) from orders where orders.cust_id = customers.cust_id)
from customers
order by cust_name;




