/**
    8-1: 使用函数
        函数一般是在数据上执行的，为数据的转换和处理提供方便
        tip:
            1. 用于处理文本字符串的文本函数
            2. 用于在数值数据上进行算术操作的数值函数
            3. 用于处理日期和时间值并从这些值中提取特定成分的日期和时间函数
            4. 用于生成美观好懂的输出内容的格式化函数
            5. 返回DBMS正使用的特殊信息的系统函数
        ** SQL函数不区分大小写 **

 */


-- 8.2.1 文本处理函数
    /**
      LEFT()                           返回字符串左边的字符
      LENGTH()/DATALENGTH()/LEN()      返回字符串的长度
      LOWER()                          将字符串转换为小写
      LTRIM()                          去掉字符串左边的空格
      RIGHT()                          返回字符串右边的字符
      RTRIM()                          去掉字符串右边的空格
      SUBSTR()/SUBSTRING()             提取字符串的组成部分
      SOUNDEX()                        返回字符串的SOUNDEX值
      UPPER()                          将字符串转换为大写
     */
-- upper() 将文本转换为大写
select vend_name, upper(vend_name) as vend_name_upcase from vendors order by vend_name;

select left('lr',1) from dual;
SELECT substr('lr',0);

select cust_name, cust_contact from customers where cust_contact = 'Michael Green';

-- soundex是一个将任何文本串转换为描述其语音表示的字母数字模式的算法。(发音比较)
select cust_name, cust_contact from customers where soundex(cust_contact) = soundex('Michael Green');

-- 8.2.2 日期和时间处理函数
    /**
        日期和时间采用相应的数据类型存储在表中，每种DBMS都有自己的特殊形式。日期和时间值以特殊的格式存储，以便能快速和有效地排序或过滤，并且节省物理存储时间。
        应用程序一般不适用日期和时间地存储格式，因此日期和时间函数在SQL中具有重要地作用。遗憾的是，它们很不一致，可移植性最差***
     */
-- extract
select order_num from orders where extract(year from order_date) = 2020;

-- oracle to_date('2020-01-01','yyyy-mm-dd')
-- mysql str_to_date('2020-12-31','%Y-%m-%d')
select order_num from orders where order_date between str_to_date('2020-01-01','%Y-%m-%d')
and str_to_date('2020-12-31','%Y-%m-%d');

select * from orders;
select order_num from orders where year(order_date) = 2020;
select order_num from orders where month(order_date) = 5;

-- 8.2.3 数值处理函数
    /**
      数值处理函数仅处理数值数据。 这些函数一般主要用于代数，三角或几何运算
      在主要DBMS的函数中，数值函数是最一致、最统一的函数
      ABS()                     返回一个数的绝对值
      COS()                     返回一个角度的余弦
      EXP()                     返回一个数的指数值
      PI()                      返回圆周率Π的值
      SIN()                     返回一个角度的正弦
      SQRT()                    返回一个数的平方根
      TAN()                     返回一个角度的正切
     */

select PI();
select ABS(-100);
select cos(pi());
select SQRT(4);