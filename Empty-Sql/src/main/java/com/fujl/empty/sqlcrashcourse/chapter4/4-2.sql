/*
    4.2 where子句操作符
    topic: where子句操作符
    point:
        -----------------------
        操作符     说明
        -----------------------
        =        等于
        <>       不等于
        !=       不等于
        <        小于
        <=       小于等于
        !<       不小于
        >        大于
        >=       大于等于
        !>       不大于
        BETWEEN  在指定两个值之间
        IS NULL  为NULL值
        -----------------------
    warn:操作符兼容
       1.某些操作符是冗余的
       2.并非所有DBMS都支持这些操作符,需根据特定的DBMS确定支持哪些操作符
       3.!=和 <> 通常可以互换,但是依旧需要根据特定DBMS进行确认
    tips:
        何时使用引号？
            单引号用来限定字符串，
                当值与字符串类型的列比较时，就需要限定引号；
                当值与数值列进行比较的值不用引号
*/

-- 4.2.1 检查某个值
select prod_name,prod_price from products where prod_price < 10;
select prod_name,prod_price from products where prod_price <= 10;

-- 4.2.2 不匹配检查
select vend_id,vend_name from vendors where vend_name != 'DLL01';
select vend_id,vend_name from vendors where vend_name <> 'DLL01';

-- 4.2.3 范围值检查  between匹配范围中的所有值，包括指定的开始值和结束值
select prod_id,prod_name,prod_price from products where prod_price between 5 and 10;

-- 4.2.4 空值检查
/* null 无值(no value)，它与字段包含0、空字符串或仅仅包换空格不同 */
select prod_name from products where prod_price is null;
select cust_name from customers where cust_email is null;


