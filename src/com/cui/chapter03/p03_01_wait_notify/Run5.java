package com.cui.chapter03.p03_01_wait_notify;

import java.util.ArrayList;
import java.util.List;

class MyList5 {
    private List list = new ArrayList();

    public void add() {
        list.add("高洪岩");
    }
    public int size() {
        return list.size();
    }
}

class ThreadA5 extends Thread {
    private MyList5 list;

    public ThreadA5(MyList5 list) {
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

class ThreadB5 extends Thread {
    private MyList5 list;

    public ThreadB5(MyList5 list) {
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
public class Run5 {
}
