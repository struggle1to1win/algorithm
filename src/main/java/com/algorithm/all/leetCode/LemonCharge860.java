package com.algorithm.all.leetCode;

/**
 * @ClassNameLemoCharge860
 * @Description
 * @Author Yao Xin
 * @Date2020/12/10 9:06
 **/
public class LemonCharge860 {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                if(five<=0){
                    return false;
                }
                five--;
                ten++;
            }else if(bills[i]==20){
                if((ten<=0&&five<3)||(ten>0&&five<=0)){
                    return false;
                }
                if(ten>0){
                    five--;
                    ten--;
                }else if(five>=3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonCharge860 lemonCharge860 = new LemonCharge860();
        System.out.println(lemonCharge860.lemonadeChange(new int[]{5,5,10,10,20}));
    }
}
