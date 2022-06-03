/**
    21-2: 使用游标
        使用游标及几个明确的步骤：
            1. 在使用游标前，必须声明(定义)它。这个过程实际上没有检索数据，它只是定义要使用的SELECT语句和游标选项
            2. 一旦声明，就必须打开游标以供使用。这个过程用前面定义的SELECT语句把数据实际检索出来
            3. 对于填有数据的游标，根据需要取出(检索)各行
            4. 在结束游标使用时，必须关闭游标，可能的话，释放游标(有赖于具体的DBMS)
        声明游标后，可根据需要频繁地打开和关闭游标。在游标打开时，可根据需要频繁地执行取操作。
        21-2-1： 创建游标
            使用DECLARE语句创建游标，这条语句在不同的DBMS中有所不同。
            DECLARE命名游标，并定义相应的SELECT语句，根据需要带WHERE和其他子句。

 */

delimiter $$;
declare custcursor CURSOR
for
select * from customers
where cust_email is null;
open cursor custcursor;