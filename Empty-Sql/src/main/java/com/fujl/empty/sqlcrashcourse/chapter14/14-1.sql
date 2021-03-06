/**
    14-1: 组合查询
        多数SQL查询只包含一个或多个表中返回数据的单挑SELECT语句。但是SQL也允许执行多个查询(多个SELECT语句),并将结果
            作为一个查询结果集返回。这些组合查询通常称为并(union)或复合查询(compound query)
        主要有两种情况需要使用组合查询：
            1. 在一个查询中从不同的表返回数据结构
            2. 对一个表执行多个查询，按一个查询返回数据
        tip:
            组合查询和多个where条件
                多数情况下，组合相同表的两个查询所完成的工作与具有多个where子句条件的一个查询所完成的工作相同。换句话说：
                    任何具有多个where子句的select语句都可以作为一个组合查询。
 */