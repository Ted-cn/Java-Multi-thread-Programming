package com.cui.chapter02.p02_01_synchronized_method;

class HasSelfPrivateNum1 {
    public void addI(String username) {
        try {
            int num;
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

class ThreadA extends Thread {
    private HasSelfPrivateNum1 numRef;

    public ThreadA(HasSelfPrivateNum1 numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}

class ThreadB extends Thread {
    private HasSelfPrivateNum1 numRef;

    public ThreadB(HasSelfPrivateNum1 numRef) {
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
 * 2.1.1 方法内的变量线程安全
 *
 * “非线程安全”问题存在于“实例变量”中，如果是方法内部的私有变量，
 * 则不存在“非线程安全”问题，所得结果也就是“线程安全”的了。
 */
public class Run1 {
    public static void main(String[] args) {
        HasSelfPrivateNum1 numRef = new HasSelfPrivateNum1();
        ThreadA threadA = new ThreadA(numRef);
        ThreadB threadB = new ThreadB(numRef);
        threadA.start();
        threadB.start();
    }
}
