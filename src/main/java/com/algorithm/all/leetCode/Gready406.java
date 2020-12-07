package com.algorithm.all.leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassNameGready406
 * @Description
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对 (h, k) 表示，其中 h 是这个人的身高，k 是应该排在这个人前面且身高大于或等于 h 的人数。 例如：[5,2] 表示前面应该有 2 个身高大于等于 5 的人，而 [5,0] 表示前面不应该存在身高大于等于 5 的人。
 *
 * 编写一个算法，根据每个人的身高 h 重建这个队列，使之满足每个整数对 (h, k) 中对人数 k 的要求。
 *
 * 输入：[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出：[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * @Author Yao Xin
 * @Date2020/11/17 9:20
 **/
public class Gready406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[][] result = new int[people.length][];
        for(int i=0;i<people.length;i++){
            int space = people[i][1];
            int location = 0;
            while(space!=0){
                if(result[location]==null||result[location][0]>=people[i][0]){
                    space--;
                }
                location++;
            }
            while(result[location]!=null){
                location++;
            }
            result[location] = people[i];
        }
        return result;
    }

    public void print(int[][] ints){
        for(int i=0;i<ints.length;i++){
            System.out.println(ints[i][0]+":"+ints[i][1]);
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Gready406 gready406 = new Gready406();
        int[][] ints = gready406.reconstructQueue(input);
        for(int i=0;i<ints.length;i++){
            System.out.println(ints[i][0]+":"+ints[i][1]);
        }
    }
}
