package com.cui.chapter02.p02_03_volatile;

class RunThread extends Thread {
    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入run()方法了！");
        while (isRunning) {
            // System.out.println("我进循环了");
        }
        System.out.println("线程被停止了！");
    }
}

/**
 * 2.3.3 解决异步死循环
 *
 * 在启动RunTread.java线程时，变量private boolean isRunning = true; 存在于公共堆栈及线程的私有堆栈中。
 * 在JVM为-server模式时，为了线程运行的效率，线程一直在私有堆栈中取得isRunning的值是true。而代码
 * thread.setRunning(false)虽然被执行，更新的却是公共堆栈中的isRunning变量，并没有更新thread线程的私有
 * 堆栈，所以就一直是死循环状态。
 *
 * ps：同样的这里的while()循环体内不能有任务线程有关的代码，否则就不会出现死循环。
 *
 * 使用volatile关键字强制从公共内存中读取变量的值，从而增加了实例变量在多个线程间的可见性。
 *
 * volatile最致使的缺点是不支持原子性。
 *
 * 比较synchronized和volatile
 *
 * 1. volatile是线程同步的轻量级实现，所以volatile性能肯定比synchronized要好。
 * 2. volatile只能修饰变量，而synchronized可以修饰方法，也可以修饰代码块。
 * 2. 多线程访问volatile不会发生阻塞，而synchronized会出现阻塞。
 * 3. volatile能保证数据的可见性，但不能保证原子性；而synchronized可以保证原子性，也可以间接地保证可见性，
 *   因为它会将私有内存和公共内存中的数据做同步。
 * 4. volatile解决的是变量在多个线程之间的可见性；而synchronized解决的是多个线程之间访问资源的同步性。
 *
 * 线程安全包含原子性和可见性两个方面，Java的同步机制都是围绕这两个方面来确保线程安全的
*/
public class Run3 {
    public static void main(String[] args) {
        try {
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("已经赋值为false");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
