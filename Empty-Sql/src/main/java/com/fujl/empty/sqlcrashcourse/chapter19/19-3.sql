/**
    19-3: 执行存储过程
        执行存储过程的SQL语句很简单，即EXECUTE，EXECUTE接受存储过程名和需要传递给它的任何参数。
        存储过程执行的基本形式:
            1. 参数可选，具有不提供参数时的默认值
            2. 不按次序给出参数，以"参数=值" 的方式给出参数值
            3. 输出参数，允许存储过程在正执行的应用程序中更新所用的参数
            4. 用SELECT语句检索数据
            5. 返回代码，允许存储过程返回一个值到正在执行的应用程序
 */

-- execute
execute addnewproduct(
    'JTS01',
    'Stuffed Eiffel Tower',
    6.49,
    'Plush stuffed toy with the text La Tour Eiffel in red white and blud'
);