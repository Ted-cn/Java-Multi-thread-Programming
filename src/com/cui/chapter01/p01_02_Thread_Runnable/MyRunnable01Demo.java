package com.cui.chapter01.p01_02_Thread_Runnable;

/**
 * 使用继承Thread类的方式来开发多线程应用程序在设计上是有局限性的，
 * 因为Java是单根继承，不支持多继承。使用实现Runnable接口的方式来
 * 实现多线程技术，可以解决这一问题。
 *
 * 由于Thread类也实现了Runnable接口，因此构造函数Thread(Runnable target)
 * 不光可以传入Runnable接口的对象，还可以传入一个Tread类的对象，这要做完全
 * 可以将一个Thread对象中的run()方法将由其他线程进行调用。
 */
class MyRunnable01 implements Runnable {
    @Override
    public void run() {
        System.out.println("运行中！");
    }
}

public class MyRunnable01Demo {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable01();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束！");
    }
}
