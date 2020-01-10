package com.cui.chapter03.p03_03_ThreadLocal;

class Tools {
    public static ThreadLocal t1 = new ThreadLocal();
}

/**
 * 3.3.2 验证线程变量的隔离性
 *
 */
public class Run2 {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Tools.t1.set("ThreadA" + (i + 1));
                    System.out.println("ThreadA get Value=" + Tools.t1.get());
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                for (int i = 0; i < 100; i++) {
                    Tools.t1.set("ThreadB" + (i + 1));
                    System.out.println("ThreadB get Value=" + Tools.t1.get());
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            for (int i = 0; i < 100; i++) {
                Tools.t1.set("Main" + (i + 1));
                System.out.println("Main get Value=" + Tools.t1.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
