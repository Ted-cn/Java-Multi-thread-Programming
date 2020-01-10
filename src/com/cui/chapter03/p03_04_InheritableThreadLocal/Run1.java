package com.cui.chapter03.p03_04_InheritableThreadLocal;

import java.util.Date;

class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + "我在子线程加的~";
    }
}

class Tools {
    public static InheritableThreadLocalExt t1 = new InheritableThreadLocalExt();
}

/**
 * 3.4.1 值继承
 *
 * 使用InheritableThreadLocal可以在子线程中取得父线程继承下来的值
 */
public class Run1 {
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
