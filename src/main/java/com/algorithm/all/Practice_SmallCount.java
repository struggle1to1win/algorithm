package com.algorithm.all;

/**
 * @ClassNamePractice_SmallCount
 * @Description 求数组的小和
 * 在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
 * 例子： [1,3,4,2,5]
 * 1左边比1小的数：没有
 * 3左边比3小的数：1
 * 4左边比4小的数：1、3
 * 2左边比2小的数：1
 * 5左边比5小的数：1、3、4、 2
 * 所以数组的小和为1+1+3+1+1+3+4+2=16
 * 等效于一个数里面有多少比右边数小的和
 *
 * @Author Yao Xin
 * @Date2020/9/17 13:46
 **/
public class Practice_SmallCount {

    public static int recursion(int[] arr,int l,int r){
        if(l==r){
            return 0;
        }
        int middle = l+((r-l)>>1);
        int leftNum = recursion(arr,l,middle);
        int rightNum = recursion(arr,middle+1,r);
        return merge(arr,l,middle,r)+leftNum+rightNum;
    }

    public static int merge(int[] arr,int l,int middle,int r){
        int lIndex = l;
        int rIndex = middle+1;
        int[] help = new int[r-l+1];
        int sum=0;
        int helpIndex=0;
        while(lIndex<=middle&&rIndex<=r){
            if(arr[lIndex]<arr[rIndex]){
                sum += arr[lIndex]*(r-rIndex+1);
                help[helpIndex++] = arr[lIndex++];
            }else {
                help[helpIndex++] = arr[rIndex++];
            }
        }
        while(lIndex<=middle){
            help[helpIndex++] = arr[lIndex++];
        }
        while(rIndex<=r){
            help[helpIndex++] = arr[rIndex++];
        }
        for(int i=0;i<help.length;i++){
            arr[l+i] = help[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5};
        System.out.println(recursion(arr,0,arr.length-1));
    }
}
