package com.algorithm.all.leetCode;

/**
 * @ClassNameDiffWays62
 * @Description
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * @Author Yao Xin
 * @Date2020/12/9 9:17
 **/
public class DiffWays62 {
    public static int uniquePaths(int m, int n) {
        int[][] contains = new int[m][n];
        contains[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i-1>=0){
                    contains[i][j] += contains[i-1][j];
                }
                if(j-1>=0){
                    contains[i][j] += contains[i][j-1];
                }
            }
        }
        return contains[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
}
