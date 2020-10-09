package com.algorithm.all.sort;

/**
 * @ClassNamePractice_countSort
 * @Description 对于范围确定的数字才能使用此排序
 * 利用数组位置对数字进行计数，再将此计数结果反写进去
 * @Author Yao Xin
 * @Date2020/9/23 9:03
 **/
public class Practice_CountSort {
    public static void countSort(int[] arr){
        int[] count = new int[100];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int index = 0;
        for(int i=0;i<count.length;i++){
            if (count[i]==0)continue;
            for(int j=0;j<count[i];j++){
                arr[index++] = i;
            }
        }
    }
    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,22,3,5,7,1,2,3,88,33,99,44,77,33,22,1,99,66,55};
        countSort(arr);
        print(arr);
    }
}
