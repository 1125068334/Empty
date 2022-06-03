/**
    10-2: 创建分组
        rule:
            1. group by 子句可以包含任意数目的列，因而可以对分组进行嵌套，更细致地进行数据分组
            2. 如果在 group by 子句中嵌套了分组，数据将在最后指定的分组上进行汇总。换句话说，在建立分组时，指定的所有列都一起计算。
            3. group by 子句中列出的每一列都必须是检索列或有效的表达式(但不能是聚集函数)。如果在SELECT中使用表达式，则必须在group by
                子句中指定相同的表达式。不能使用别名
            4. 大多数SQL实现不允许group by列带有长度可变的数据类型(如文本或备注型字段)
            5. 除聚集计算语句外，select语句中的每一列都必须包含在group by子句中给出。
            6. 如果分组列中包含具有NULL值的行，则NULL将作为一个分组返回。如果列中有多行NULL值，它们将分为一组
            7. group by子句必须出现在where子句之后，order by子句之前。
        tip:
            通过相对位置指定列： group by 2,1 ：可表示按选择的第二个列分组，然后再按第一个列分组。

 */

 select vend_id,count(*) as num_prods from products group by vend_id;
