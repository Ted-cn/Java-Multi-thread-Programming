package com.cui.chapter02.p02_03_volatile;

import java.util.concurrent.atomic.AtomicLong;

class MyService {
    public static AtomicLong aiRef = new AtomicLong();

    public void addNum() {
        System.out.println(Thread.currentThread().getName() + " 加了100之后的值是：" + aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }
}

class MyThread6 extends Thread {
    private MyService myService;

    public MyThread6(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.addNum();
    }
}

/**
 * 原子类也并不完全安全
 *
 * 原子类在具有有逻辑性的情况下，输出结果也具有随机性
 */
public class Run6 {
    public static void main(String[] args) {
        try {
            MyService myService = new MyService();
            MyThread6[] array = new MyThread6[5];
            for (int i = 0; i < array.length; i++) {
                array[i] = new MyThread6(myService);
            }
            for (int i = 0; i < array.length; i++) {
                array[i].start();
            }
            Thread.sleep(1000);
            System.out.println(myService.aiRef.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * Thread-0 加了100之后的值是：100
     * Thread-1 加了100之后的值是：201
     * Thread-2 加了100之后的值是：302
     * Thread-3 加了100之后的值是：402
     * Thread-4 加了100之后的值是：504
     * 505
     *
     * 程序运行的结果没有问题，但打印的顺序不对。原因是原子类的addAndGet虽然是原子的，
     * 但方法和方法之间的调用却不是原子的。解决这样的问题必须要用同步。
     */
}
