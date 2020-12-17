package com.algorithm.all.leetCode;

/**
 * @ClassNameStockFee714
 * @Description
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 *
 * @Author Yao Xin
 * @Date2020/12/17 9:09
 **/
public class StockFee714 {
    public int maxProfit(int[] prices, int fee) {
        Integer buyIndex=0,maxEnd=null;
        int total=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[buyIndex]){
                buyIndex = i;
            }else if(prices[i]-prices[buyIndex]>=fee){
                if(i<prices.length-1&&prices[i]-prices[i+1]>=fee){
                    total += prices[i]-prices[buyIndex]-fee;
                    buyIndex=i+1;
                    maxEnd = null;
                }else {
                    maxEnd = maxEnd==null||prices[i]>prices[maxEnd]?i:maxEnd;
                }
            }
        }
        if (maxEnd!=null){
            total += prices[maxEnd]-prices[buyIndex]-fee;
        }
        return total;
    }

    public static void main(String[] args) {
        StockFee714 stockFee714 = new StockFee714();
        int[] array = new int[]{1,5,3,7,5,3,6};
        int i = stockFee714.maxProfit(array,2);
        System.out.println(i);
    }
}
