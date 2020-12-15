package com.algorithm.all;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassNameJUCTest
 * @Description
 * @Author Yao Xin
 * @Date2020/12/14 10:41
 **/
public class JUCTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(10000000);
            }catch (Exception e){}
        }).start();

        new Thread(()->{
            lock.lock();
        }).start();
        System.out.println("xixi");
    }
}
