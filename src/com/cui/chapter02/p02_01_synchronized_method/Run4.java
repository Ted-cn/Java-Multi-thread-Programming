package com.cui.chapter02.p02_01_synchronized_method;

class MyObject {
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA4 extends Thread {
    private MyObject numRef;

    public ThreadA4(MyObject numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.methodA();
    }
}

class ThreadB4 extends Thread {
    private MyObject numRef;

    public ThreadB4(MyObject numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.methodA();
    }
}

/**
 * 2.1.4 synchronized方法与锁对象
 *
 * methodA不加synchronized的情况下，A线程和B线程可以同时进入。
 * 加了synchronized以后线程排队进入。
 */
public class Run4 {
    public static void main(String[] args) {
        MyObject numRef1 = new MyObject();
        ThreadA4 threadA = new ThreadA4(numRef1);
        threadA.setName("A");
        ThreadB4 threadB = new ThreadB4(numRef1);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}
