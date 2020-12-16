package com.algorithm.all.leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassNameIncreNum738
 * @Description
 * @Author Yao Xin
 * @Date2020/12/15 9:17
 **/
public class IncreNum738 {
    public int monotoneIncreasingDigits(int N) {
        int temp = N;
        List<Integer> position = new LinkedList<>();
        while(temp!=0){
            position.add(temp%10);
            temp = temp/10;
        }
        int size = position.size();
        for(int i = 0; i< size; i++){
            if(i!= size -1 && position.get(i)<position.get(i+1)){
                position.set(i,9);
                position.set(i+1,position.get(i+1)-1);
                int tempIndex = i;
                while(tempIndex!=0&&position.get(tempIndex)>position.get(tempIndex-1)){
                    position.set(--tempIndex,9);
                }
            }
        }
        int result = 0;
        for(int i=0;i<position.size();i++){
            result += position.get(i)*Math.pow(10,i);
        }
        return result;
    }

    public static void main(String[] args) {
        IncreNum738 increNum738 = new IncreNum738();
        System.out.println(increNum738.monotoneIncreasingDigits(3122));
    }
}
