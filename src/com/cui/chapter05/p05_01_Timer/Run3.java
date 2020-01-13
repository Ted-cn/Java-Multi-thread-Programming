package com.cui.chapter05.p05_01_Timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 5.1.1 schedule(TimerTask task, Date time)的测试
 *
 * 该方法的作用是在指定的日期执行一次某一任务。
 *
 * 3）多个TimerTask任务及延时的测试
 */
public class Run3 {

    private static Timer timer = new Timer();
    public static class MyTask2 extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了！时间为：" + new Date());
        }
    }

    public static class MyTask3 extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了！时间为：" + new Date());
        }
    }

    public static void main(String[] args) {
        MyTask2 task2 = new MyTask2();
        MyTask3 task3 = new MyTask3();
        Date dateRef2 = new Date(System.currentTimeMillis() + 3000);
        Date dateRef3 = new Date(System.currentTimeMillis() - 3000);
        System.out.println("字符串dateRef2时间：" + dateRef2.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
        System.out.println("字符串dateRef3时间：" + dateRef3.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
        timer.schedule(task2, dateRef2);
        timer.schedule(task3, dateRef3);
    }
    /**
     *运行结果：
     *     字符串dateRef2时间：2020-1-11 23:31:39 当前时间：2020-1-11 23:31:36
     *     字符串dateRef3时间：2020-1-11 23:31:33 当前时间：2020-1-11 23:31:36
     *     运行了！时间为：Sat Jan 11 23:31:36 CST 2020
     *     运行了！时间为：Sat Jan 11 23:31:39 CST 2020
     *
     * TimerTask是以队列的方式一个一个被顺序执行的，所以执行的时间有可能和预期的时间不一致，因为前面的任务有可能消耗的时间较长，则后面的
     * 任务运行的时间也会被延迟。
     *
     */
}


















