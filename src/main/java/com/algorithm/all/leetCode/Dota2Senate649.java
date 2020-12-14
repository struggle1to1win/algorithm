package com.algorithm.all.leetCode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassNameDota2Senate649
 * @Description
 * @Author Yao Xin
 * @Date2020/12/11 9:10
 **/
public class Dota2Senate649 {
    public String predictPartyVictory(String senate) {
        int Radiant=0,Dire=0;
        int rRemain=0,dRemain=0;

        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                if(Radiant<0){
                    Radiant++;
                }else {
                    rRemain++;
                    Radiant++;
                    Dire--;
                }
            }else if(senate.charAt(i)=='D'){
                if(Dire<0){
                    Dire++;
                }else {
                    dRemain++;
                    Dire++;
                    Radiant--;
                }
            }
        }

        return Radiant==Dire?senate.charAt(0)=='R'?"Radiant":"Dire":
                Radiant>Dire?"Radiant":"Dire";
    }

    public static void main(String[] args) {
        Dota2Senate649 senate = new Dota2Senate649();
        System.out.println(senate.predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }
}
