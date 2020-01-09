package com.cui.chapter02.p02_01_synchronized_method;

class Main {
    synchronized public void serviceMethod() {
        try {
            System.out.println("int main 下一步 sleep begin threadName=" + Thread.currentThread().getName() + 
                    " time=" + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("int main 下一步 sleep end threadName=" + Thread.currentThread().getName() +
                    " time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Sub extends Main {
    @Override
    public void serviceMethod() {
        try {
            System.out.println("int sub 下一步 sleep begin threadName=" + Thread.currentThread().getName() +
                    " time=" + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("int sub 下一步 sleep end threadName=" + Thread.currentThread().getName() +
                    " time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA8 extends Thread {
    private Sub sub;

    public ThreadA8(Sub sub) {
        super();
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}

class ThreadB8 extends Thread {
    private Sub sub;

    public ThreadB8(Sub sub) {
        super();
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}

/**
 * 2.1.8 同步不具有继承性
 * 
 * 同步不可以继承
 */
public class Run8 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        ThreadA8 threadA8= new ThreadA8(sub);
        threadA8.setName("A");
        threadA8.start();
        ThreadB8 threadB8= new ThreadB8(sub);
        threadB8.setName("B");
        threadB8.start();
    }
}
