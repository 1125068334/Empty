/**
    9-1: 聚集函数
            1.确定表中行数
            2.获得表中某些行的和
            3.找出表列的最大值、最小值、平均值
        SQL聚集函数：
            AVG()           返回某列的平均值
            COUNT()         返回某列的行数
            MAX()           返回某列的最大值
            MIN()           返回某列的最小值
            SUM()           返回某列值之和
        tip:
            1. 可移植(portable) 所编写的代码可以在多个系统上运行
 */

-- 9.1.1 AVG()函数
    -- 只用于单个列
    -- 忽略列值为null的行
select avg(prod_price) as avg_price, sum(prod_price)/count(prod_price) from products;

select avg(prod_price) as avg_price from products where vend_id = 'DLL01';

-- 9.1.2 COUNT()函数
    -- 使用count(*)对表中行的数目进行计数，不管表列中包含的是空值(null)还是非空值
    -- 使用count(column)对特定列中具有值的行进行计数,忽略null值

select * from customers;

select count(*) from customers;

select count(cust_email) from customers;

-- 9.1.3 MAX()函数
    -- max()返回指定列中的最大值,max()要求指定列名
    -- max()一般用来找出最大的数值或日期值，但许多(DBMS)允许将它返回任意列中的最大值，包括返回文本列中的最大值。
    -- 在用于文本数据时,max()返回按列排序后的最后一行
    -- 忽略列值为null的行

select max(prod_price) as max_price from products;

-- 9.1.4 MIN()函数
select min(prod_price) as min_price from products;

-- 9.1.5 SUM()函数
    -- SUM()用来返回指定列值的和(总计)
    -- 忽略列值为null的行
select sum(quantity) as items_ordred from orderitems where order_num = 20005;

select sum(quantity * item_price) as total_amt
from orderitems where order_num = 20005;



