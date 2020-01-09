package com.cui.chapter01.p01_07_stop_thread;

/**
 * 测试当前线程是否已经中断。线程的中断状态由该方法清除。
 * 换句话说，如果连续两次调用该方法，则第二次调用将返回false。
 */
public class Run2 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1？= " + Thread.interrupted());  // true
        System.out.println("是否停止2？= " + Thread.interrupted());  // false
        System.out.println("end!");
    }
}
