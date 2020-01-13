package com.cui.chapter07.p07_05_thread_exception;

/**
 * 在Java多线程技术中，可以对多线程中的异常进行捕捉，使用的是UncaughtExceptionHandler类，
 * 从而可以对发生的异常进行有效的处理。
 */
public class Run2 {
    public static void main(String[] args) {
        MyTread t1 = new MyTread();
        MyTread t2 = new MyTread();
        t1.setName("线程t1");
        t2.setName("线程t2");
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("线程" + t.getName() + "出现了异常");
            }
        });
        t1.start();
        t2.start();
    }
}
