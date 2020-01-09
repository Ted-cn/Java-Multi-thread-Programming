package com.cui.chapter01.p01_03_currentThread;

/**
 * currentThread()方法返回代码段正在被哪个线程调用的信息。
 */
public class Run1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }
}
