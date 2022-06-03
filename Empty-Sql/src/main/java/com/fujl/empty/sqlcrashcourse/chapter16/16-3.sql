/**
    16-3: 更新和删除的指导原则
        1. 除非确实打算更新和删除每一行，否则绝对不要使用不带where子句的update或delete语句。
        2. 保证每个表都有主键，尽可能像where子句那样使用它(可以指定各主键、多个值或值的范围)
        3. 在UPDATE或DELETE语句使用where子句前，应该先用select进行测试，保证它过滤的是正确的记录，以防编写的where子句不正确。
        4. 使用强制实施引用完整性的数据库，这样DBMS将不允许删除其数据与其它表相关联的行(外键)
        5. 有的DBMS允许数据库管理员添加约束，防止执行不带where子句的UPDATE或DELETE语句。如果所采用的DBMS支持这个特性，应该使用它
 */