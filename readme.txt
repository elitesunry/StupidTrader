题目:
ba ba ba....

==================
My design and assumptions:
==================
给定价格序列,首先判断价格走势
不同的走势,有不同的交易策略(买卖点的决策)

1 先枚举出简单序列的集中基本走势情况
2 再对基本走势情况进行组合得到复杂走势图,分段求最优解
3 最后考虑cooldown的问题
4 算出最大收益并展示


==================
How to run this application:
==================
you can try:
mvn clean test -Dtest=ApplicationTest
