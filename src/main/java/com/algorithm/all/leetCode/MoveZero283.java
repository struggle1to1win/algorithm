package com.algorithm.all.leetCode;

/**
 * @ClassNameMoveZero283
 * @Description
 * @Author Yao Xin
 * @Date2020/11/19 17:41
 **/
public class MoveZero283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while(right<n){
            if(nums[right]!=0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}
