package com.cui.chapter04.p04_01_ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyService3 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void await() {
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 4.1.3 使用Condition实现等待/通知：错误用法与解决
 *
 * ReentrantLock类借助Condition类实现等待/通知模式。
 *
 * Condition类是JDK5中出现的技术，使用它有更好的灵活性，比如可以实现多路通知功能，
 * 也就是在一个Lock对象里面创建多个Condition（即对象监视器）实现，线程对象可以注
 * 册在指定的Condition中，从而可以有选择地进行线程通知，在高度上更加灵活。
 *
 */
public class Run3 {
    public static void main(String[] args) {
        MyService3 service = new MyService3();
        new Thread(() -> {
            service.await();
        }).start();
    }
    /**
     * 运行后抛出异常
     * Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
     *
     * 解决的办法是必须在condition.await()方法前调用lock.lock()代码获得同步监视器。
     */
}
