/**
    15-2: 从一个表复制到另一个表
        要将一个表的内容复制到一个全新的表(运行中创建的表)，可以使用create select语句(或者在SQL Server里也可用SELECT INTO语句)

 */

create table custcopy as select * from customers;