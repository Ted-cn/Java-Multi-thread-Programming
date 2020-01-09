package com.cui.chapter03.p03_01_wait_notify;

import java.util.ArrayList;
import java.util.List;

class MyList {
    private List list = new ArrayList();

    public void add() {
        list.add("高洪岩");
    }
    public int size() {
        return list.size();
    }
}

class ThreadA extends Thread {
    private MyList list;

    public ThreadA(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                list.add();
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {
    private MyList list;

    public ThreadB(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (list.size() == 5) {
                    System.out.println("==5了，线程b要退出了！");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 3.1.1 不使用等待/通知机制实现线程间通信
 *
 * 使用sleep()结合while(true)死循环法来实现多个线程间通信
 *
 */
public class Run1 {
    public static void main(String[] args) {
        MyList list = new MyList();
        ThreadA a = new ThreadA(list);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(list);
        b.setName("B");
        b.start();
    }
}
