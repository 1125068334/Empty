/**
    15-1-1: 插入完整的行
        基本的insert语法，要求指定表名和插入到新行中的值。
        tip: 总是使用给出列的列表。 给出列能使SQL代码继续发挥使用，即使表结构发生了变化。
             小心使用VALUES，VALUES的数目必须正确。
 */

-- 基本insert语法
insert into customers
values (1000000006,
        'Toy Land',
        '123 Any Street',
        'New York',
        'NY',
        '11111',
        'USA',
        null,
        null);

-- safer
insert into customers(cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact,
                      cust_email)
values (1000000006,
        'Toy Land',
        '123 Any Street',
        'New York',
        'NY',
        '11111',
        'USA',
        null,
        null);