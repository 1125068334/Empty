/**
    20-2: 控制事务处理
        管理事务的关键在于将SQL与剧组分解为逻辑块，并明确规定数据何时应该回退，何时不应该回退。
        有的DBMS要求明确表示事务处理块的开始和结束。
        20-2-1: 使用ROLLBACK
            SQL的ROLLBACK命令用来回退(撤销)SQL语句
        20-2-2: 使用COMMIT
            一般的SQL语句都似乎针对数据库表直接执行和编写的。 这就是所谓的隐式提交(implicit commit),即提交(写或保存)操作是自动进行的
        20-2-3: 使用保留点
            使用简单的ROLLBACK和COMMIT语句，就可以写入或撤销整个事务。
            复杂的事务可能需要部分提交或回退。
            要支持回退部分事务，必须在事务处理块中的合适位置放置占位符。这样，如果需要回退，可以回退到某个占位符。
            在SQL中，这些占位符称为保留点。在MariaDB、MySQL和Oracle创建占位符，可使用SAVEPOINT语句
 */

-- SQL Server
# BEGIN TRANSACTION
# ...
# COMMIT TRANSACTION

-- MariaDB MySQL
# START TRANSACTION
# ...

-- Oracle
# SET TRANSACTION
# ...

-- PostgreSQL 使用ANSI SQL 语法
# BEGIN
# ...

start transaction;
delete from orders_copy;

commit ;

select * from orders_copy;

create table orders_copy as select * from orders;

insert into orders_copy select * from orders;
commit ;

