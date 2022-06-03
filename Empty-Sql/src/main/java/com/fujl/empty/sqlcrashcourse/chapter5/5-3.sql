/*
    5.3 NOT操作符
    tip:
       where子句中的NOT操作符有且只有一个功能，那就是否定其后所跟的任何条件。因为NOT从不单独使用(它总是与其他操作符一起使用)，
    所以它的语法与其他操作符有所不同。NOT关键字可以用在要过滤的列前，而不仅是在其后.
    analyze:
        为什么使用not？
            在复杂的子句中，not是非常有用的。eg. 在与IN操作符联用时，not可以非常简单地找出与条件列表不匹配的行。
*/

select prod_name
from products
where not vend_id = 'DLL01';


select prod_name
from products
where vend_id <> 'DLL01';
