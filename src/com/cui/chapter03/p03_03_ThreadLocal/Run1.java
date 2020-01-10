package com.cui.chapter03.p03_03_ThreadLocal;

/**
 * 3.3.1 get()方法与null
 *
 * ThreadLocal类解决的是变量在不同线程间的隔离性，也就是不同的线程拥有自己的值，
 * 不同线程中的值是可以放入ThreadLocal类中进行保存的。
 */
public class Run1 {
    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) {
        if (t1.get() == null) {
            System.out.println("从未放过值");
            t1.set("我的值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
