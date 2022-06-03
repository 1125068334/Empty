-- 1.
alter table vendors add column vend_web varchar(1000) comment '网站';

-- 2.
update vendors set vend_web = 'www.baidu.com';