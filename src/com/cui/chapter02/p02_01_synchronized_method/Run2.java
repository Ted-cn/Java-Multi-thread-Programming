package com.cui.chapter02.p02_01_synchronized_method;

class HasSelfPrivateNum2 {
    private int num;

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

class ThreadA2 extends Thread {
    private HasSelfPrivateNum2 numRef;

    public ThreadA2(HasSelfPrivateNum2 numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}

class ThreadB2 extends Thread {
    private HasSelfPrivateNum2 numRef;

    public ThreadB2(HasSelfPrivateNum2 numRef) {
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
 * 2.1.2 实例变量非线程安全
 */
public class Run2 {
    public static void main(String[] args) {
        HasSelfPrivateNum2 numRef = new HasSelfPrivateNum2();
        ThreadA2 threadA = new ThreadA2(numRef);
        ThreadB2 threadB = new ThreadB2(numRef);
        threadA.start();
        threadB.start();
    }
}
