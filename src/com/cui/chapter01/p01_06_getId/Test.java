package com.cui.chapter01.p01_06_getId;

/**
 * getId()方法用于取得线程的唯一标识
 */
public class Test {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t" + thread.getId()); // 1
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());  // 11
        },"A").start();
    }
}
