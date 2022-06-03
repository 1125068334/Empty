/**
    14-2-4: 对组合查询结果排序
        在使用UNION组合查询时，只能使用一条ORDER BY 子句，它必须位于最后一条SELECT语句之后。
 */

select cust_name, cust_contact, cust_email
from customers
where cust_state in ('IL', 'IN', 'MI')
union
select cust_name, cust_contact, cust_email
from customers
where cust_name = 'Fun4All'
order by cust_name,cust_contact;