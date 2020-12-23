package com.algorithm.all.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassNameQ387_FirstUniqChar
 * @Description
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * @Author Yao Xin
 * @Date2020/12/23 8:55
 **/
public class Q387_FirstUniqChar {

    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q387_FirstUniqChar firstUniqChar = new Q387_FirstUniqChar();
        int loveleetcode = firstUniqChar.firstUniqChar("loveleetcode");
        System.out.println(loveleetcode);
    }
}
