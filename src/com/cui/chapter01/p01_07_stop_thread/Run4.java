package com.cui.chapter01.p01_07_stop_thread;

class MyThread4 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.interrupted()) {
                System.out.println(" 已经是停止状态了，我要退出了！");
                break;
            }
            System.out.println(i + 1);
        }
        System.out.println("我被输出，如果此代码是for又继续运行，线程并未停止！");
    }
}

/**
 * 使用for break的方法虽然可以跳出循环，但是线程并没有终止，
 * 后面的“我被输出......”仍然会打印出来。
 */
public class Run4 {
    public static void main(String[] args) {
        MyThread4 thread = new MyThread4();
        thread.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("end!");
    }
}
