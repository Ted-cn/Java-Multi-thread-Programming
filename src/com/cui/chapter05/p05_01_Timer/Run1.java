package com.cui.chapter05.p05_01_Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 5.1.1 schedule(TimerTask task, Date time)的测试
 *
 * 该方法的作用是在指定的日期执行一次某一任务。
 *
 * 1）执行任务的时间晚于当前时间：在未来执行的效果
 */
public class Run1 {

    private static Timer timer = new Timer();
    public static class MyTask1 extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了！时间为：" + new Date());
        }
    }

    public static void main(String[] args) {
        MyTask1 task = new MyTask1();
        Date dateRef = new Date(System.currentTimeMillis() + 1000);
        System.out.println("字符串时间：" + dateRef.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
        timer.schedule(task, dateRef);
    }
    /**
     *运行结果：
     *     字符串时间：2020-1-11 23:04:09 当前时间：2020-1-11 23:04:08
     *     运行了！时间为：Sat Jan 11 23:04:09 CST 2020
     *
     * 可以清楚地看到，当schedule参数是未来的某个时间点时，task会按照时间来顺序执行。
     * 值得注意的是，此例代码全部执行完毕后，程序并没有停止，而是处在waiting on condition状态，
     * 查看Timer的构造方法
     *     public Timer(String name) {
     *         thread.setName(name);
     *         thread.start();
     *     }
     *     可以看出创建一个Timer就是使用一个新的线程在执行其任务，此线程并没有终止所以程序一直处理waiting状态。
     *
     *     此处引用Java8 Api
     *     当对计时器对象的最后一次活动引用结束并且所有未完成的任务都已执行完毕后，计时器的任务执行线程将优雅地终止(并成为垃圾收集的对象)。
     *     然而，这可能需要任意长的时间才能发生。默认情况下，任务执行线程不作为守护进程线程运行，因此它能够防止应用程序终止。如果调用方希望
     *     快速终止计时器的任务执行线程，则调用方应调用计时器的cancel方法。
     *
     *      还有一种方法是
     *      public Timer(String name, boolean isDaemon) {
     *         thread.setName(name);
     *         thread.setDaemon(isDaemon);
     *         thread.start();
     *     }
     *     以守护线程的形式创建定时器，这样main线程结束以后，定时器线程也随之结束了。
     */
}


















