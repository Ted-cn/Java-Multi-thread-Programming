package com.cui.chapter01.p01_07_stop_thread;

class MyThread10 extends Thread {
    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("停止了");
                return;
            }
        }
    }
}

/**
 * 将interrupt()方法和return结合，也能实现停止线程的效果。
 *
 * 不过还是建议使用“抛异常”的方式来实现线程的停止，
 * 因为在catch块中还可以将异常向上抛，使线程停止的事件得以传播。
 */
public class Run10 {
    public static void main(String[] args) {
        MyThread10 thread = new MyThread10();
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("end!");
    }
}
