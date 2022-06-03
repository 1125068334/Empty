/**
    15-1-3: 插入检索出的数据
        INSERT SELECT，由一条INSERT语句和一条SELECT语句组成的。
        tip:   insert select中的列名
            DBMS不关心SELECT返回的列名，它使用的是列的位置，因此select中的第一列将用来填充表列中指定的第一列，
                第二列将用来填充表列中指定的第二列。。。
 */

 insert into custnew (select * from customers);