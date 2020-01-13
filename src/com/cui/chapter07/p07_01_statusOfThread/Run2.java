package com.cui.chapter07.p07_01_statusOfThread;

class MyThread2 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("begin sleep");
            System.out.println(this.getThread("main").getState());
            System.out.println("end sleep");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Thread getThread(String threadName) {
        Thread returnValue = null;
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(threadName)) {
                returnValue = thread;
            }
        }
        return returnValue;
    }
}

/**
 * 7.1.2 验证TIMED_WAITING
 *
 * 线程状态TIMED_WAITING代表线程执行了Thread.sleep(long time)、wait(long time)、join(long time)等方法，
 * 呈等待状态，等待时间到达，继续向下运行
 *
 * 值得注意的是，验证join()方法时，需要在子线程中使用父线程，使用getThread()实现
 */
public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 t = new MyThread2();
        t.start();
        t.join(1000);
    }
}
