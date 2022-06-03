/*
  topic: 按列位置排序,指定相对位置
  tip:可以混合使用按列和按位置排序
*/
select prod_id,prod_price,prod_name from products order by 2,3;
select prod_id,prod_price,prod_name from products order by prod_price,3;