==================
题目:
==================
给定一只股票每天价格的序列prices，设计一个算法获得最大利润所有操作序列transactions。
规则如下：
1、  每天最多买卖一次
2、  每次买卖1股，最大持仓1股
3、  有仓位才能卖出
4、  卖出后，必须cooldown一天才能继续操作
举例
prices = [1, 2, 3, 1, 3]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
如果某天不操作，为pass。

==================
My design and assumptions:
==================
给定价格序列,首先判断价格走势
不同的走势,有不同的交易策略(买卖点的决策)

1 先枚举出简单序列的几种基本走势情况
2 再对基本走势情况进行组合得到复杂走势图,分段求最优解
3 最后考虑cooldown的问题
4 算出最大收益并展示


==================
How to run this application:
==================
you can try:
mvn clean test -Dtest=ApplicationTest
