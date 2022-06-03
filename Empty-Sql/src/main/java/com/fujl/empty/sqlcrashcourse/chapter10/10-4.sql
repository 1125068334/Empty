/**
    10-4: 分组和排序
         --------------------------------------------------------------------------------------
            order by                                        group by
          对产生的输出排序                            对行分组，但输出可能不是分组的顺序
          任意列都可以使用(甚至非选择的列也可以使用)       只可能使用选择列或表达式列，而且必须使用每个选择列表达式
          不一定需要                                 如果与聚集函数一起使用列(或表达式),则必须使用
         --------------------------------------------------------------------------------------
        tip:
            不要忘记order by。 这是保证数据正确排序的唯一方法
 */

 select order_num,count(*) as items from orderitems group by order_num having count(*) >= 3 order by items,order_num;