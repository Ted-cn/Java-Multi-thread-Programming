package com.cui.chapter01.p01_07_stop_thread;

/**
 * 在Java中有三种方法可以终止正在运行的线程：
 * 1. 使用退出标志，使用线程正常退出，也就是当run()方法完成后线程终止。
 * 2. 使用stop()方法强行终止线程，但不推荐使用，因为stop()和suspend()及resume()一样，都是作废过期的方法，使用它们将产生不可预料的错误。
 * 3. 使用interrupt()方法中断线程。
 */

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (i % 10 == 0) {
                System.out.print("i=" + (i + 1));
            }
        }
    }
}

/**
 * 本例中使用interrupt()方法来停止线程，但是interrupt()方法的使用效果并不即时，
 * 调用interrupt()方法仅仅是在当前线程中打了一个停止的标记，并不是真的停止线程。
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        myThread.interrupt();
    }
}
