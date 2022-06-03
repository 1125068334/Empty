/*
  topic:指定排序方向
  tip: 默认升序asc:(A->Z),降序desc:(Z->A)
  关键字只应用到直接位于其前面的列名
      desc:descending
      asc:ascending
  warn: 区分大小写和排序顺序,取决于数据库的设置方式，在字典排序(directory)中，A/a视为相同
*/
-- 价格升序
select prod_id,prod_price,prod_name from products order by prod_price;

-- 价格降序
select prod_id,prod_price,prod_name from products order by prod_price desc;

-- 多列排序
select prod_id,prod_price,prod_name from products order by prod_price desc,prod_name desc;