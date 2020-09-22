package com.algorithm.all;

import java.util.PriorityQueue;

/**
 * @ClassNamePractice_LimitSort
 * @Description 一数组有一定顺序，排序之后每个数字移动不超过5
 * @Author Yao Xin
 * @Date2020/9/21 16:49
 **/
public class Practice_LimitSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,4,3,6,5};
        sort(arr,3);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr,int limit){
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index <= Math.min(arr.length, limit); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
