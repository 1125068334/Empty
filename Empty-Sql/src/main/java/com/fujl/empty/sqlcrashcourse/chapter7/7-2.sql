/**
    7-2: 拼接字段
        tip:
            1. 拼接(concatenate) 将值联结到一起构成单值
        trim函数：

 */

select vend_name + '(' + vend_country + ')' from vendors;
select vend_name || '(' || vend_country || ')' from vendors;
select concat(vend_name, '(', vend_country, ')')
from vendors;

select length(' nihao ') from dual;
select length(rtrim(' nihao ')) from dual;-- 去掉字符串右边空格
select length(ltrim(' nihao ')) from dual;-- 去掉字符串左边空格
select length(trim(' nihao ')) from dual;-- 去掉字符串左右两边空格


-- 使用别名 别名(alias)是一个字段或值的替换名，别名用AS关键字赋予
   /**
     别名的其它用途：包括在实际的表列名包含不合法的字符(如空格)时重新命名它，在原来的名字含混或容易误解时扩充它
     别名的名字可以是一个单词，也可以是一个字符串。 如果是后者，字符串应该括在引号中。
     别名也成为导出列
    */

select concat(rtrim(vend_name),'(',rtrim(vend_country),')') as vend_title  from vendors order by vend_name;
