/**
    16-2: 删除数据
        从一个表中删除/去掉数据，使用DELETE语句。有两种使用DELETE的方式:
            1. 从表中删除特定的行
            2. 从表中删除所有的行

        warn: 不要省略where子句

        tip: 更快的删除
            如果想从表中删除所有行，不要使用delete。可以使用truncate table语句，它完成相同的工作，而速度更快(因为不记录数据的变动)

 */

 delete from customers where cust_id = 1000000006;