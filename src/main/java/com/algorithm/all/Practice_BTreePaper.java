package com.algorithm.all;

/**
 * @ClassNamePractice_BTreePaper
 * @Description
 * 折纸问题，一张纸一直向内对折，折痕向内的为凸，折痕向外的为凹，打印对折n次后纸上的折痕
 * 在对折第一次之后，每对折一次之后都产生上次对折产生折痕数的一倍，即2的n次方，且每次产生的折痕相对于上次产生的折痕，上面的为凹，下面的为凸
 * @Author Yao Xin
 * @Date2020/9/28 8:55
 **/
public class Practice_BTreePaper {

    public static void main(String[] args) {
        paperPrint(true,3,0);
    }

    public static void paperPrint(boolean flag,int num,int i){
        if(i>=num){
            return;
        }
        i++;
        paperPrint(true,num,i);
        System.out.println(flag?"凹":"凸");
        paperPrint(false,num,i);
    }
}
