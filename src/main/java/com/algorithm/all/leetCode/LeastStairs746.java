package com.algorithm.all.leetCode;

/**
 * @ClassNameLeastStairs746
 * @Description
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * @Author Yao Xin
 * @Date2020/12/21 9:06
 **/
public class LeastStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] minCost = new int[length];
        minCost[0]=0;
        minCost[1]=Math.min(cost[0],cost[1]);
        for(int i = 2; i< length; i++){
            minCost[i] = Math.min(minCost[i-2]+cost[i-1],minCost[i-1]+cost[i]);
        }
        return minCost[length-1];
    }

    public static void main(String[] args) {
        LeastStairs746 leastStairs746 = new LeastStairs746();
        int i = leastStairs746.minCostClimbingStairs(new int[]{1,100,1,100});
        System.out.println(i);
    }
}
