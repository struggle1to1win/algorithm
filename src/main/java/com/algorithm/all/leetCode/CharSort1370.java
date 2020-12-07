package com.algorithm.all.leetCode;

/**
 * @ClassNameCharSort1370
 * @Description
 * @Author Yao Xin
 * @Date2020/11/25 9:20
 **/
public class CharSort1370 {

    public static String sortString(String s) {
        int[] nums = new int[26];
        for(int i=0;i<s.length();i++){
            nums[s.charAt(i)-97]++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean up = true;
        int index=0;
        for(int i=0;i<s.length();i++){
            if(up){
                while (nums[index]==0&&index<=s.length()){
                    index++;
                }
                if(index != s.length()+1){
                    stringBuilder.append((char)(index+97));
                    nums[index++]--;
                }else {
                    up = !up;
                }
            }else {
                while (nums [index]==0&&index>=-1){
                    index--;
                }
                if(index != -1){
                    stringBuilder.append((char)(index+97));
                    nums[index--]--;
                }else {
                    up = !up;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        System.out.println(sortString(s));
    }
}
