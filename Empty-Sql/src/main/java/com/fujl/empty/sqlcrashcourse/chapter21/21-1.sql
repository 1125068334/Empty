/**
    21-1:  游标
        SQL检索操作返回一组称为结果集的行，这组返回的行都是与SQL语句相匹配的行(零行到多行)。
        简单地使用SQL语句，没有办法得到第一行，下一行或前10行。
        需要在检索出来的行中前进或后退一行或多行，这就是游标的用途所在。
        游标(cursor)是一个存储在DBMS服务器上的数据库查询，它不是一条SELECT语句，
        而是被该语句检索出来的结果集。在储存了游标之后，应用程序可以根据需要滚动或浏览其中的数据。

        游标常见的一些选项和特性如下:
            1. 能够标记游标为只读，使数据能读取，但不能更新和删除
            2. 能控制可以执行的定向操作(向前、向后、第一、最后、绝对位置和相对位置等)
            3. 能标记某些列为可编辑的，某些列为不可编辑的
            4. 规定范围，使游标对创建它的特定请求(如存储过程)或对所有请求可访问
            5. 指示DBMS对检索出的数据(而不是指出表中活动数据)进行复制，使数据在游标打开和访问期间不变化

        游标主要用于交互式应用，其中用户需要滚动屏幕上的数据，并对数据进行浏览或做出更改
 */