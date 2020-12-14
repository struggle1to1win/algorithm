package com.algorithm.all.leetCode;

import java.util.*;

/**
 * @ClassNameWordGroup49
 * @Description
 * @Author Yao Xin
 * @Date2020/12/14 9:10
 **/
public class WordGroup49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if(map.containsKey(String.valueOf(chars))){
                map.get(String.valueOf(chars)).add(s);
            }else {
                List<String> curr = new LinkedList<>();
                curr.add(s);
                map.put(String.valueOf(chars),curr);
            }
        }

        for(List<String> curr:map.values()){
            result.add(curr);
        }

        return result;
    }

    public static void main(String[] args) {
        WordGroup49 wordGroup49 = new WordGroup49();
        List<List<String>> lists = wordGroup49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println("over");
    }
}
