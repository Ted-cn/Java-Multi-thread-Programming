package com.cui.chapter02.p02_01_synchronized_method;

class Service {
    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }

    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
    }
}

class MyThread6 extends Thread {
    @Override
    public void run() {
        Service service =new Service();
        service.service1();
    }
}

/**
 * 2.1.6 synchronized 锁重入
 *
 * 关键字synchronized拥有锁重入的功能，也就是在使用synchronized时，当一个线程得到一个对象后，
 * 再次请求此对象锁时是可以再次得到该对象的锁的。也这证明在一个synchronized方法/块的内部调用
 * 本类的其他synchronized方法/块时，是永远可以得到锁的。
 *
 * “可重入锁”的概念是指，自己可以再次获取自己的内部锁。
 * 比如有1条线程获得了某个对象的锁，此时这个对象锁还没有释放，当这个线程想要再次获取这个对象的
 * 锁时，是可以的。如果不可重入的话，就会造成死锁。
 */
public class Run6 {
    public static void main(String[] args) {
        MyThread6 thread = new MyThread6();
        thread.start();
    }
}
