package com.cui.chapter03.p03_02_join;

/**
 * 3.2.2 用join()方法
 *
 * join()方法的作用是使所属的线程对象x正常执行run()方法中的任务，而使用当前线程z进行无限期的阻塞，
 * 等待线程x销毁后再继续执行线程z后面的代码。
 *
 * 方法join()具有使线程排除运行的作用，有些类似同步的运行效果。join与synchronized的区别是：
 * join在内部使用wait()方法等待，而synchronized关键字使用的是“对象监视器”原理作为同步。
 */
public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadTest = new Thread(() -> {
            int secondValue = (int) (Math.random() * 10000);
            System.out.println(secondValue);
            try {
                Thread.sleep(secondValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadTest.start();
        threadTest.join();
        System.out.println("我想等threadTest对象执行完毕后我再执行，我做到了");
    }
}
