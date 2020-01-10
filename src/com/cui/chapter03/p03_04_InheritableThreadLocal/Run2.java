package com.cui.chapter03.p03_04_InheritableThreadLocal;

/**
 * 3.4.2 值继承再修改
 *
 */
public class Run2 {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在Main线程中取值=" + Tools.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(3000);
            new Thread(() -> {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("在ThreadA线程中取值=" + Tools.t1.get());
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
