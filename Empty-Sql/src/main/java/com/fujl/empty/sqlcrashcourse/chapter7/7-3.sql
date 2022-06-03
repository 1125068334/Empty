/**
    7-3: 执行算术计算
        计算字段的另一常见用途是对检索出的数据进行算术计算。
        SQL算术操作符： + - * / (加减乘除)
        tip:
            如何测试计算：SELECT语句为测试、检验函数和计算提供了很好的方法。虽然SELECT通常用于从表中检索数据，
            但是省略了FROM子句后就是简单地访问和处理表达式

 */

select prod_id, quantity,item_price from orderitems where order_num = 20008;

select prod_id, quantity,item_price, quantity*item_price as expanded_price from orderitems where order_num = 20008;

select 6*2;
select curdate();
select current_time;
