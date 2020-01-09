package com.cui.chapter02.p02_01_synchronized_method;

class MyObject2 {
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
            Thread.sleep(4000);
            System.out.println("end endTime=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodB() {
        try {
            System.out.println("begin methodB threadName=" + Thread.currentThread().getName() +
                    " begin time=" + System.currentTimeMillis());
            Thread.sleep(4000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA4_2 extends Thread {
    private MyObject2 numRef;

    public ThreadA4_2(MyObject2 numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.methodA();
    }
}

class ThreadB4_2 extends Thread {
    private MyObject2 numRef;

    public ThreadB4_2(MyObject2 numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.methodB();
    }
}

/**
 * 1）A线程先持有object对象的Lock锁，B线程可以以异步的方式调用object对象中的非synchronized类型的方法
 * 2）A线程先持有object对象的Lock锁，B线程如果在这时调用object对象中的synchronized类型的方法，则需要等待，也就是同步。
 */
public class Run4_2 {
    public static void main(String[] args) {
        MyObject2 object = new MyObject2();
        ThreadA4_2 threadA = new ThreadA4_2(object);
        threadA.setName("A");
        ThreadB4_2 threadB = new ThreadB4_2(object);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}
