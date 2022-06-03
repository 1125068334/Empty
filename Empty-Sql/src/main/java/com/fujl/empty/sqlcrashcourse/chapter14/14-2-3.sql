/**
    14-3: 包含或取消重复的行
        UNION从查询结果集中自动去除了重复的行;换句话说，它的行为与一条SELECT语句中使用多个WHERE子句条件一样。
        使用UNION时，重复的行会被自动取消。这是UNION的默认行为。
        如果想要返回所有的匹配行，可使用UNION ALL。
 */

select cust_name, cust_contact, cust_email
from customers
where cust_state in ('IL', 'IN', 'MI')
union all
select cust_name, cust_contact, cust_email
from customers
where cust_name = 'Fun4All';