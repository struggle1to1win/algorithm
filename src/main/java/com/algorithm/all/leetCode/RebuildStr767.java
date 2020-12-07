package com.algorithm.all.leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassNameRebuildStr767
 * @Description
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 输入: S = "aaab"
 * 输出: ""
 *
 * @Author Yao Xin
 * @Date2020/11/30 9:20
 **/
public class RebuildStr767 {
    public static String reorganizeString(String S) {
        int[] counts = new int[26];
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2-'a']-counts[o1-'a'];
            }
        });
        for(int i=0;i<S.length();i++){
            counts[S.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(counts[i]!=0){
                char temp = (char)('a'+i);
                priorityQueue.add(temp);
            }
        }
        if(counts[priorityQueue.peek()-'a']>((S.length()+1)>>1)){
           return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<S.length();i++){
            Character first = priorityQueue.poll();
            Character second = priorityQueue.poll();
            if(first!=null&&--counts[first - 'a']>=0){
                stringBuilder.append(first);
                priorityQueue.add(first);
            }
            if(second!=null&& --counts[second - 'a']>=0){
                stringBuilder.append(second);
                priorityQueue.add(second);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aaab"));
    }
}
