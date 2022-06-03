/*
   6.2 使用通配符的技巧

   tip:
    不要过度使用通配符。
    在确实需要使用通配符时，也尽量不要把它们用在搜索模式的开始处。
    仔细注意通配符的位置。
*/

select prod_name, prod_price
from products
where vend_id in ('DLL01','BRS01')
order by prod_name;

select prod_name, prod_price
from products
where vend_id = 'DLL01' or vend_id = 'BRS01'
order by prod_name;
