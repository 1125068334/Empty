/**
    19-4: 创建存储过程
        这个存储过程有一个名为ListCount的参数。此参数从存储过程返回一个值而不是传递一个值给存储过程。
        关键字OUT用来指示这种行为。
        Oracle支持IN(传递值给存储过程)、out(从存储过程返回值)、INOUT(既传递值给存储过程也从存储过程传回值)类型的参数。
        存储过程的代码在BEGIN和END语句中，这里执行一条简单的SELECT语句，它检索具有邮件地址的顾客。
        然后用检索出的行数设置ListCount(要传递的输出参数)


 */

-- create execution
create procedure mailinglistcount(
    ListCount out integer
)
    is
    v_rows integer;
begin
    select count(*)
    into v_rows
    from customers
    where not cust_email is null;
    ListCount := v_rows;
end;

var ReturnValue NUMBER
EXEC mailinglistcount(:ReturnValue);
select ReturnValue;