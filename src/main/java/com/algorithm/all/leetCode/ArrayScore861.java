package com.algorithm.all.leetCode;

/**
 * @ClassNameArrayScore861
 * @Description
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 * @Author Yao Xin
 * @Date2020/12/7 17:31
 **/
public class ArrayScore861 {
    public int matrixScore(int[][] A) {
        for(int i = 0;i<A.length;i++){
            if(A[i][0]==0){
                reversalRow(A,i);
            }
        }
        int result = A.length*(2^(A[0].length));
        for(int i=1;i<A[0].length;i++){
            int sum = 0;
            for(int j=0;j<A.length;j++){
                sum += A[j][i];
            }
            if(2*sum<A[0].length){
                sum = A[0].length - sum;
            }
            result += sum*2^(A[0].length-1-i);
        }
        return result;
    }

    public void reversalRow(int[][] A,int a){
        for(int i = 0;i<A[0].length;i++){
            A[a][i] = 1 - A[a][i];
        }
    }

    public static void main(String[] args) {
        ArrayScore861 ss= new ArrayScore861();
        int[][] A = new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(ss.matrixScore(A));
    }
}
