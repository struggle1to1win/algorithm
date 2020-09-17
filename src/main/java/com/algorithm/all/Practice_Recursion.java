package com.algorithm.all;

/**
 * @ClassNamePractice_Recursion
 * @Description 递归
 * @Author Yao Xin
 * @Date2020/9/16 17:19
 **/
public class Practice_Recursion {
    //查询数组区间最大值
    public static int findMaxInArea(int[] arr,int left,int right){
        if(left == right){
            return arr[left];
        }
        int middle = left+((right-left)>>1);
        int leftMax = findMaxInArea(arr,left,middle);
        int rightMax = findMaxInArea(arr,middle+1,right);
        return leftMax>rightMax?leftMax:rightMax;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,7,3,2,7,5,43,33,1,6,55};
        System.out.println(findMaxInArea(arr,0,arr.length-1));

        int[] arr1 = new int[10];
        System.out.println(arr1.length);
    }
}
