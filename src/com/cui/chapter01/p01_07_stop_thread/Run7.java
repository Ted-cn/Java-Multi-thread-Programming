package com.cui.chapter01.p01_07_stop_thread;

class MyThread7 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 100000; i++) {
                System.out.println(i + 1);
            }
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("先停止，再遇到了sleep，进入catch!" + this.interrupted());
            e.printStackTrace();
        }
    }
}

/**
 * java.lang.InterruptedException: sleep interrupted
 *
 * 先停止，再sleep，也是同样的
 */
public class Run7 {
    public static void main(String[] args) {
        MyThread7 myThread7 = new MyThread7();
        myThread7.start();
        myThread7.interrupt();
        System.out.println("end!");
    }
}
