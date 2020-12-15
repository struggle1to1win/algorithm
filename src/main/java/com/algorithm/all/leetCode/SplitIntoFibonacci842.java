package com.algorithm.all.leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassNameSplitIntoFibonacci842
 * @Description
 * @Author Yao Xin
 * @Date2020/12/14 9:29
 *
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 **/
public class SplitIntoFibonacci842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new LinkedList<>();
        recursion(0,S,result);
        return result;
    }

    public boolean recursion(int index,String s,List<Integer> result){
        int size = result.size();
        if(index>=s.length()){
            return size>2?true:false;
        }
        for(int i=1;i<=s.length()-index;i++){
            String substring = s.substring(index, index + i);
            Integer value;
            try {
                value = Integer.valueOf(substring);
            }catch (Exception e){
                return false;
            }
            if(String.valueOf(value).length()!=i){
                return false;
            }
            if(size<2||value == result.get(size-1)+result.get(size-2)){
                result.add(value);
                if(recursion(index+i,s,result)) return true;
                result.remove(value);
            }else if(value > result.get(size-1)+result.get(size-2)){
                return false;
            }else {
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SplitIntoFibonacci842 splitIntoFibonacci842 = new SplitIntoFibonacci842();
        List<Integer> integers = splitIntoFibonacci842.splitIntoFibonacci("5511816597");
        System.out.println("over");
    }
    /**
     * ----------------------------经典的动态规划模板----------------------------
     * private void backtrack("原始参数") {
     *     //终止条件(递归必须要有终止条件)
     *     if ("终止条件") {
     *         //一些逻辑操作（可有可无，视情况而定）
     *         return;
     *     }
     *
     *     for (int i = "for循环开始的参数"; i < "for循环结束的参数"; i++) {
     *         //一些逻辑操作（可有可无，视情况而定）
     *
     *         //做出选择
     *
     *         //递归
     *         backtrack("新的参数");
     *         //一些逻辑操作（可有可无，视情况而定）
     *
     *         //撤销选择
     *     }
     * }
     *
     */
}
