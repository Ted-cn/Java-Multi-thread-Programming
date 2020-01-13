package com.cui.chapter05.p05_01_Timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 5.1.1 schedule(TimerTask task, Date time)的测试
 *
 * 该方法的作用是在指定的日期执行一次某一任务。
 *
 * 2）执行任务的时间晚早于当前时间：提前执行的效果
 */
public class Run2 {

    private static Timer timer = new Timer();
    public static class MyTask1 extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了！时间为：" + new Date());
        }
    }

    public static void main(String[] args) {
        MyTask1 task = new MyTask1();
        Date dateRef = new Date(System.currentTimeMillis() - 1000);
        System.out.println("字符串时间：" + dateRef.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
        timer.schedule(task, dateRef);
    }
    /**
     *运行结果：
     *     字符串时间：2020-1-11 23:27:03 当前时间：2020-1-11 23:27:04
     *     运行了！时间为：Sat Jan 11 23:27:04 CST 2020
     *
     * task任务没有延迟，与main线程同时执行了
     *
     */
}


















