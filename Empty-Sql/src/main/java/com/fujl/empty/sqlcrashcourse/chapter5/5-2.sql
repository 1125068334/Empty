/*
   5.2 IN操作符

   tip:
    IN操作符用来指定条件范围，范围内的每个条件都可以进行匹配。IN取一组由逗号分隔，括在圆括号内的合法值。
    IN操作符完成了与OR相同的功能
   think:
    为什么要使用IN操作符？其优点如下：
        1. 在有很多合法选项时，IN操作符的语法更清楚，更直观
        2. 在与其他AND和OR操作符组合使用IN时，求值顺序更容易管理
        3. IN操作符一般比一组OR操作符执行得更快
        4. IN的最大优点是可以包含其他select语句，能够更动态地建立where子句。

*/

select prod_name, prod_price
from products
where vend_id in ('DLL01','BRS01')
order by prod_name;

select prod_name, prod_price
from products
where vend_id = 'DLL01' or vend_id = 'BRS01'
order by prod_name;
