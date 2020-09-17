package com.algorithm.all;

/**
 * @ClassNamePractice_MergeSort
 * @Description 归并排序
 * @Author Yao Xin
 * @Date2020/9/17 9:16
 **/
public class Practice_MergeSort {
    public static void recursion(int[] arr,int l,int r){
        if(l==r){
            return;
        }
        int middle = l+((r-l)>>1);
        recursion(arr,l,middle);
        recursion(arr,middle+1,r);
        merge(arr,l,middle,r);
    }

    public static void merge(int[] arr,int l,int middle,int r){
        int[] help = new int[r-l+1];
        int leftIndex = l;
        int rightIndex = middle+1;
        int putIndex = 0;
        while(leftIndex<=middle&&rightIndex<=r){
            if(arr[leftIndex]<=arr[rightIndex]){
                help[putIndex++] = arr[leftIndex++];
            }else {
                help[putIndex++] = arr[rightIndex++];
            }
        }
        while (leftIndex<=middle){
            help[putIndex++] = arr[leftIndex++];
        }
        while (rightIndex<=r){
            help[putIndex++] = arr[rightIndex++];
        }
        for(int i=0;i<help.length;i++){
            arr[l+i] = help[i];
        }
    }

    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,1,6,8,0,3,33,45,13,100};
        recursion(arr,0,arr.length-1);
        print(arr);
    }
}
