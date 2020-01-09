package com.cui.chapter02.p02_01_synchronized_method;

class Service7 {
    synchronized public void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName=" + Thread.currentThread().getName() +
                    " run beginTime=" + System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() +
                            " run exceptionTIme=" + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("Thread B run Time=" + System.currentTimeMillis());
        }
    }
}

class ThreadA7 extends Thread {
    private Service7 service7;

    public ThreadA7(Service7 service7) {
        super();
        this.service7 = service7;
    }

    @Override
    public void run() {
        service7.testMethod();
    }
}

class ThreadB7 extends Thread {
    private Service7 service7;

    public ThreadB7(Service7 service7) {
        super();
        this.service7 = service7;
    }

    @Override
    public void run() {
        service7.testMethod();
    }
}

/**
 * 2.1.7 出现异常，锁自动释放
 *
 * 当一个线程出现异常时，其所持有的锁会自动释放。
 */
public class Run7 {
    public static void main(String[] args) {
        try {
            Service7 service7 = new Service7();
            ThreadA7 a = new ThreadA7(service7);
            a.setName("a");
            a.start();
            Thread.sleep(500);
            ThreadB7 b = new ThreadB7(service7);
            b.setName("b");
            b.start();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}
