package com.cui.chapter02.p02_01_synchronized_method;

class HasSelfPrivateNum3 {
    private int num = 0;
    synchronized public void addI(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA3 extends Thread {
    private HasSelfPrivateNum3 numRef;

    public ThreadA3(HasSelfPrivateNum3 numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}

class ThreadB3 extends Thread {
    private HasSelfPrivateNum3 numRef;

    public ThreadB3(HasSelfPrivateNum3 numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}

/**
 * 2.1.3 多个对象多个锁
 *
 */
public class Run3 {
    public static void main(String[] args) {
        MyObject numRef1 = new MyObject();
        MyObject numRef2 = new MyObject();
        ThreadA4 threadA = new ThreadA4(numRef1);
        ThreadB4 threadB = new ThreadB4(numRef2);
        threadA.start();
        threadB.start();
    }
}
