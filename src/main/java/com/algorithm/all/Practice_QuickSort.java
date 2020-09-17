package com.algorithm.all;

/**
 * @ClassNamePractice_QuickSort
 * @Description 使用荷兰国旗算法实现O(NlogN)的快排
 * @Author Yao Xin
 * @Date2020/9/17 16:04
 **/
public class Practice_QuickSort {
    public static void recursion(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int randomIndex = l+(int)(Math.random()*(r-l));
        int[] area = partition(arr, l, r, arr[randomIndex]);
        recursion(arr,l,area[0]-1);
        recursion(arr,area[1]+1,r);
    }

    public static int[] partition(int[] arr,int l,int r,int p){
        if (l > r) {
            return new int[] { -1, -1 };
        }
        if (l == r) {
            return new int[] { l, r };
        }
        int less = l-1;
        int more = r+1;
        while(l<more){
            if(arr[l]<p){
                swap(arr,++less,l++);
            }else if(arr[l]>p){
                swap(arr,--more,l);
            }else {
                l++;
            }
        }
        return new int[]{less+1,more-1};
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,3,5,32,11,2,45,11,66};
        recursion(arr,0,arr.length-1);

        print(arr);
    }

    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
