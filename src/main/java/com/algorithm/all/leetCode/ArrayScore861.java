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
 * 1、要最大，第一位的值必须是1，这时使用 ··行反转··
 * 2、第二位及以后要取最大，要使同时的情况下1更多，但是这个时候不能··行反转··，只能 ··列反转··。所以只用看当前列有多少个1，超过行数的一半就成，否则取行数减去当前列的1
 *
 * @Author Yao Xin
 * @Date2020/12/7 17:31
 **/
public class ArrayScore861 {
    public int matrixScore(int[][] A) {

        int result = A.length*(1<<(A[0].length-1));

        for(int i=1;i<A[0].length;i++){
            int sum = 0;
            for(int j=0;j<A.length;j++){
                if(A[j][0]==1){
                    sum += A[j][i];
                }else {
                    sum += 1 - A[j][i];
                }
            }
            sum = Math.max(sum,A.length-sum);
            result += sum*(1<<(A[0].length-1-i));
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayScore861 ss= new ArrayScore861();
        int[][] A = new int[][]{{0,1},{0,1},{0,1},{0,0}};
//        int[][] A = new int[][]{{0}};
        System.out.println(ss.matrixScore(A));
    }
}
