package com.cui.chapter03.p03_01_wait_notify;

/**
 * 3.1.2 什么是等待/通知机制
 *
 *  两个线程完全是主动式地读取同一个共享变量，在花费读取时间的基础上，
 *  读到的值是不是想要的，并不能完全确定。所以需要等待/通知机制来满足这一需要。
 */
public class Run2 {
    public static void main(String[] args) {
        String newString = new String("");
        try {
            newString.wait();
            // Exception in thread "main" java.lang.IllegalMonitorStateException
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
