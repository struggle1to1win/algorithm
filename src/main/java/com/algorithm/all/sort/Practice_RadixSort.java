package com.algorithm.all.sort;

/**
 * @ClassNamePractice_RadixSort
 * @Description 基数排序
 * 要求排序的数组是十进制的非负整数
 * 按各个位置进行排序，个、十、百、千、万...
 * 排序需要稳定，个有序之后，十有序，依次进行保证数组有序
 * @Author Yao Xin
 * @Date2020/9/23 10:51
 **/
public class Practice_RadixSort {
    //找到数组最大值
    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            if (arr[i]>max) max = arr[i];
        }
        return max;
    }
    //求数的位数
    public static int findRadix(int[] arr){
        int size = 0;
        int max = findMax(arr);
        while(max!=0){
            max=max/10;
            size++;
        }
        return size;
    }
    public static void radixSort(int[] arr){
        int[] help = new int[arr.length];
        int radix = findRadix(arr);
        //遍历各个位，使其再各个位上有序
        for(int i=0;i<radix;i++){
            //中间数组，用计数排序的思想，使各个位置有序
            int[] count = new int[10];
            for(int j=0;j<arr.length;j++){
                int num = getDigit(arr[j],i);
                count[num]++;
            }
            for(int j=1;j<count.length;j++){
                count[j] = count[j-1]+count[j];
            }
            //要从后向前遍历，才能保证排序的稳定
            for(int j=arr.length-1;j>=0;j--){
                int num = getDigit(arr[j],i);
                help[--count[num]] = arr[j];
            }
            for (int j=0;j<help.length;j++){
                arr[j] = help[j];
            }
        }
    }

    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static int getDigit(int x,int d){
        return (x/(int)Math.pow(10,d))%10;
    }

    public static void main(String[] args) {
        int[] arr= new int[]{1,44,2,33,6,88,109,23,66,23,76};
        radixSort(arr);
        print(arr);
    }
}
