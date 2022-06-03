/**
    17-1: 创建表
        SQL不仅用于表数据操纵，而且还用来执行数据库和表的所有操作，包括表本身的创建和处理。
        一般有两种创建表的方法：
            1. 多数DBMS都具有交互式创建和管理数据库表的工具；
            2. 表也可以直接用SQL语句操纵。
        17-1-1: 表创建基础
            利用CREATE TABLE创建表，必须给出下列信息:
                1. 新表的名字，在关键字CREATE TABLE之后给出
                2. 表列的名字和定义，用逗号分隔
                3. 有的DBMS还要求指定表的位置
            tip:  语句格式化
        17-1-2: 使用NULL值
            NULL值就是没有值或缺值。
            允许NULL值的列也允许在插入时不给出该列的值。
            不允许NULL值的列不接受没有列值的行。
            tip: 主键和NULL值。 只有不允许NULL值的列可作为主键，允许NULL值的列不能作为唯一标识
            warn: 理解NULL值。 NULL值是没有值，不是空字符串。 空字符串是一个有效的值，它不是无值。
        17-1-3: 指定默认值
            SQL允许指定默认值，在插入行时如果不给出值，DBMS将自动采用默认值。默认值在create table语句的列定义中用关键字default指定。


        获得系统日期
        DBMS                        函数/变量
        -------------------------------------
        DB2                         CURRENT_DATE
        MySQL                       CURRENT_DATE()
        Oracle                      SYSDATE
        PostgreSQL                  CURRENT_DATE
        SQL Server                  GETDATE()
        SQLite                      date('now')
 */

 create table products
(
    prod_id char(10) not null,
    vend_id char(10) not null,
    prod_name char(254) not null,
    prod_price decimal(8,2) not null,
    prod_desc varchar(1000) null
 );