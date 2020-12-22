package com.algorithm.all.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNameFindDiffs389
 * @Description
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 * @Author Yao Xin
 * @Date2020/12/18 9:15
 **/
public class FindDiffs389 {

    //位运算
    public char findTheDifference1(String s, String t) {
        int length = s.length();
        int res = t.charAt(length);
        for(int i = 0; i< length; i++){
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return (char) res;
    }

    //拉跨算法
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            Integer integer = map.get(c);
            if(integer==null){
                map.put(c,1);
            }else {
                map.put(c,integer+1);
            }
        }

        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            Integer integer = map.get(c);
            if (integer==null||integer==0){
                return c;
            }else {
                map.put(c,integer-1);
            }
        }
        return ' ';
    }



    public static void main(String[] args) {
        FindDiffs389 findDiffs389 = new FindDiffs389();
        System.out.println(findDiffs389.findTheDifference1("yxasx","asxyxy"));
    }
}
