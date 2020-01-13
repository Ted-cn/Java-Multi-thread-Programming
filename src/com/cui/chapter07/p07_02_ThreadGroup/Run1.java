package com.cui.chapter07.p07_02_ThreadGroup;

/**
 * 7.2.1 线程对象关联线程组：1级关联
 *
 * 所谓1组关联就是父对象中有子对象，但并不创建子孙对象。
 *
 * 比如创建一些线程时，为了有效地对这些线程进行组织管理，通常情况下会创建一个线程组，然后再将部分线程归属到该组中。
 */
public class Run1 {
    public static void main(String[] args) {

        ThreadGroup group = new ThreadGroup("崔之刚的线程组");
        new Thread(group, () -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("ThreadName=" + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(group, () -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("ThreadName=" + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("活动的线程数为：" + group.activeCount());
        System.out.println("线程组的名称为：" + group.getName());
    }
}
