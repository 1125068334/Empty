/**
    14-2: 创建组合查询
        可用UNION操作符来组合数条SQL查询。利用UNION,可给出多条SELECT语句，将它们的结果组合成一个结果集。
        14-2-1: 利用UNION
            使用UNION,所要做的只是给出每条SELECT语句，在各条语句之间放上关键字UNION。
            tip:
                union的限制，使用union组合select语句的数目，sql没有标准限制。需要了解dbms文档。
            warn:
                性能问题：多数好的DBMS使用内部查询优化程序，在处理各条select语句前组合它们。
        14-2-2: UNION规则
            1. UNION必须由两条或两条以上的select语句组成，语句之间用关键字union分隔(因此，如果组合四条SELECT语句，将要使用三个UNION关键字)
            2. UNION中的每个查询必须包含相同的列、表达式和聚集函数(不过,各个列不需要以相同的次序列出)
            3. 列数据类型必须兼容:类型 不必完全相同，但必须是DBMS可以隐含转换的类型(例如: 不同的数值类型或不同的日期类型)。
            desc:
                UNION的别名：
                    如果组合UNION使用的SELECT语句遇到不同的列名，那么它会返回第一个名字，那么排序也只能用这个名字。

 */

-- 14-2-1
select cust_name, cust_contact, cust_email
from customers
where cust_state in ('IL', 'IN', 'MI');

select cust_name, cust_contact, cust_email
from customers
where cust_name = 'Fun4All';

-- union
select cust_name, cust_contact, cust_email
from customers
where cust_state in ('IL', 'IN', 'MI')
union
select cust_name, cust_contact, cust_email
from customers
where cust_name = 'Fun4All';