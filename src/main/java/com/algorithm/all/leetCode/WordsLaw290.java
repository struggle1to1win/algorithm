package com.algorithm.all.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNameWordsLaw290
 * @Description
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * @Author Yao Xin
 * @Date2020/12/16 9:15
 **/
public class WordsLaw290 {
    public boolean wordPattern(String pattern, String s) {
        String[] s2 = s.split(" ");
        int[] law = new int[pattern.length()];
        if(s2.length!=law.length){
            return false;
        }
        Map<String,Integer> map = new HashMap<>();
        Map<Integer,String> reverseMap = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            String s1 = String.valueOf(pattern.charAt(i));
            if(map.keySet().contains(s1)){
                law[i] = map.get(s1);
            }else {
                law[i] = i;
                map.put(s1,i);
                reverseMap.put(i,s1);
            }
        }
        Map<Integer,String> newWordsMap = new HashMap<>();
        for(int i=0;i<s2.length;i++){
            String curr = s2[i];
            if(law[i]==i){
                if (newWordsMap.values().contains(curr)) return false;
                newWordsMap.put(i,curr);
            }else {
                if(!curr.equals(newWordsMap.get(law[i]))) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordsLaw290 wordsLaw290 = new WordsLaw290();
        System.out.println(wordsLaw290.wordPattern("aaa","dog dog dog dog"));
    }
}
