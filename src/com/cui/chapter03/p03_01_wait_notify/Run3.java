package com.cui.chapter03.p03_01_wait_notify;

/**
 * 3.1.3 等待/通告机制的实现
 *
 * wait()方法的作用是使用当前执行线程进行等待，wait()方法是Object类的方法，该方法用来将当前线程置入“预执行队列”中，
 * 并且在wait()所在的代码行处停止执行，直到接到通知或被中断为止。在调用wait()之前，线程必须获得该对象的对象级别锁，
 * 即只能在同步方法或同步块中调用wait()方法。在执行wait()方法后，当前线程释放锁。在从wait()返回前，线程与其他线程
 * 竞争重新获得锁。如果调用wait()时没有持有适当的锁，则抛出IllegalMonitorStateException。
 *
 * notify()方法也在要同步方法或同步块中调用，即在调用前，也必须获得该对象的对象级别锁。如果调用notify()时没有持有适
 * 当的锁，也会抛出IllegalMonitorStateException。该方法用来通知那些可能等待该对象的对象锁的其他线程，如果有多个线程
 * 等待，则由线程规划器随机挑选出其中一个呈wait状态的线程，对其发出通知notify，并使它等待获取对象的对象锁。需要说明的
 * 是，在执行notify()方法后，当前线程不会马上释放该对象锁，呈wait状态的线程也并不能马上获取该对象锁，要等到notify()方
 * 法所在线程执行完毕，也就是退出synchronized代码块后，当前线程都会释放锁，而呈wait状态所在的线程才可以获取该对象锁。
 * 当一个获取该对象锁的wait线程运行完毕之后，它会释放掉该对象锁，此时如果该对象没有再次使用notify语句，则即便对象已经空
 * 闲，其他wait状态等待的线程由于没有得到该对象的通知，还会继续阻塞在wait状态，直到这个对象发出一个notify或者notifyAll。
 *
 * 一句话总结：wait使线程停止运行，notify使用停止的线程继续运行。
 *
 */
public class Run3 {
    public static void main(String[] args) {
        try {
            String lock =new String();
            System.out.println("syn上面");
            synchronized (lock) {
                System.out.println("syn第一行");
                lock.wait();
                System.out.println("wait下面");
            }
            System.out.println("syn下面");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
