/**
    9-2: 聚集不同的值
        9-1中的5个聚集函数都可以如下使用：
            --对所有执行计算，指定ALL参数或不指定参数(因为ALL是默认行为)
            --只包含不同的值,指定DISTINCT参数
        tip: ALL为默认,ALL参数不需要指定,因为它是默认行为.如果不指定DISTINCT,则假定为ALL

 */

select avg(distinct prod_price) as avg_price
from products
where vend_id = 'DLL01';




