/**
    summary: 介绍什么是联结，为什么使用联结，如何编写联结的SELECT语句

    12-1: 联结
        SQL最强大的功能之一就是能在数据查询的执行中联结(join)表。联结是利用SQL的SELECT能执行的最重要的操作。

     12-1-1: 关系表
        关系表的设计就是要把信息分解成多个表，一类数据一个表。各表通过某些共同的值互相关联(所以才叫关系数据库)
        关系数据可以有效地存储，方便地处理。因此关系数据库的可伸缩性远比非关系数据库要好。
     12-1-2 为什么使用联结
        将数据分解为多个表能有效地存储，更方便地处理，并且可伸缩性更好。但是这些好处是有代价的。
        联结是一种机制，用来在一条select语句中关联表，因此称为联结。使用特殊的语法，可以联结多个表返回一组输出，联结在运行时关联表中正确的行。

    12-2: 创建联结
        创建联结非常简单，指定要联结的所有表以及关联它们的方式即可。
     12-2-1 WHERE子句的重要性
        在联结两个表时，实际要做的是将第一个表中的每一行与第二个表中的每一行配对。WHERE子句作为过滤条件，只包含那些匹配给定条件(这里是联结条件)的行。
        没有WHERE子句，第一个表中的每一行将与第二个表中的每一行配对，而不管它们逻辑上是否能配在一起。
     12-2-2 内联结
        等值联结(equijoin)，基于两个表之间的相等测试，也称为内联结(inner join)
    12-2-3 联结多个表
        SQL不限制一条select语句中可以联结的表的数目。
        创建联结的基本规则也相同。首先列出所有的表，然后定义表之间的关系。

    tip:
        可伸缩(scale): 能够适应不断增加的工作量而不失败。设计良好的数据库或应用程序称为可伸缩性好(scale well);
        笛卡儿积(cartesian product): 由没有联结条件的表关系返回的结果称为笛卡儿积。检索出的行的数目将是第一个表中的行数乘以第二个表中的行数;
        返回笛卡尔积的联结，也称叉联结;
        多做实验：执行任一给定的SQL操作一般不止一种方法。很少有绝对正确或绝对错误的方法。性能可能会受操作类型、所使用的DBMS、表中数据量、是否存在索引或键等条件的影响。
                因此，有必要试验不同的选择机制，找出最适合具体情况的方法。


    warn:
        完全限定列名: 在引用的列可能出现歧义时，必须使用完全限定列名(用一个句点分割表名和列名)。
        要保证所有联结都有where子句，否则dbms将返回比想要的数据多得多的数据。同理，要保证where子句的正确性。
        性能考虑：不要联结不必要的表，联结的表越多，性能下降越厉害。
        联结中表的最大数目： 虽然SQL本身不限制每个联结约束中表的数目，但实际上许多dbms都有限制。




 */
-- 简单等值联结
select vend_name, prod_name, prod_price from vendors, products where vendors.vend_id = products.vend_id;
-- 内联结
select vend_name, prod_name, prod_price from vendors inner join products p on vendors.vend_id = p.vend_id;

select prod_name, vend_name, prod_price, quantity
from orderitems,
     products,
     vendors
where products.vend_id = vendors.vend_id
  and orderitems.prod_id = products.prod_id
  and order_num = '20007';

-- 子查询
select cust_name, cust_contact from customers where cust_id in (
    select cust_id from orders where order_num in (
        select order_num from orderitems where prod_id = 'RGAN01'
        )
    );

-- 联结查询
select cust_name, cust_contact
from customers,
     orders,
     orderitems
where customers.cust_id = orders.cust_id
  and orders.order_num = orderitems.order_num
  and prod_id = 'RGAN01'