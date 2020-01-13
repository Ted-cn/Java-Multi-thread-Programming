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

/**
 * 3.1.1 不使用等待/通知机制实现线程间通信
 *
 * 使用sleep()结合while(true)死循环法来实现多个线程间通信
 *
 /**
 * 3.1.1 不使用等待/通知机制实现线程间通信
 *
 * 使用sleep()结合while(true)死循环法来实现多个线程间通信
 *
 * 重点：
 * JVM有两种运行模式Server与Client。
 * 两种模式的区别在于：
 * 启动速度，Client快，Server慢；
 * 稳定运行速度，Client慢，Server快；
 * 这是因为Server模式启动的JVM采用的是重量级的虚拟机，对程序采用了更多的优化；而Client模式启动的JVM采用的是轻量级的虚拟机。
 * 所以Server启动慢，但稳定后速度比Client远远要快。
 * 当JVM用于启动GUI界面的交互应用时适合于使用client模式，当JVM用于运行服务器后台程序时建议用Server模式。
 *
 * 书上的例子，都是运行在client模式下的，在此模式下线程存取值都是在主内存中进行，隐性地保证了可见性。故而这些例子都是可以正常运行的。
 * 而本机都是的 64bit server模式JVM，此模式下，为了运行效率，线程都在是私有内在中对变量做存取操作，不能保证可见性。所以此处的例子无法正常运行。
 * 解决办法是使用volatile或synchronized关键字来保证可见性。另外，Thread.sleep()方法结束后，线程也会从主内存中重装读取数据，间接地也保证了可见性，
 * 在此处也是可以使用的。
 *
 *
 */
public class Run1 {
    public static void main(String[] args) {
        MyList list = new MyList();
        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    list.add();
                    System.out.println("添加了" + (i + 1) + "个元素");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();



        new Thread(() -> {
            try {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                    Thread.sleep(1000);
                    if (list.size() == 5) {
                        System.out.println("==5了，线程b要退出了！");
                        throw new InterruptedException();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
