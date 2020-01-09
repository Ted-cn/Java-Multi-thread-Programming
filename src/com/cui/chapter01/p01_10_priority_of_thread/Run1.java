package com.cui.chapter01.p01_10_priority_of_thread;


/**
 * 在操作系统中，线程可以划分优先级，优先级黑市的线程得到的CPU资源较多，
 * 也就是CPU优先执行优先级较高的线程对象中的任务。
 *
 * 设置线程优先级有助于“线程规划器”确定在下一次选择哪一个线程来优先执行。
 *
 * 使用setPriority()方法来设定优先级
 *
 * public final void setPriority(int newPriority) {
 *    ThreadGroup g;
 *    checkAccess();
 *    if (newPriority > MAX_PRIORITY || newPriority < MIN_PRIORITY) {
 *        throw new IllegalArgumentException();
 *    }
 *    if((g = getThreadGroup()) != null) {
 *        if (newPriority > g.getMaxPriority()) {
 *            newPriority = g.getMaxPriority();
 *        }
 *        setPriority0(priority = newPriority);
 *     }
 * }
 *
 * 在Java中，线程的优先级分为1~10这10个等级，如果小于1或大于10，则JDK抛出java.lang.IllegalArgumentException异常。
 * 3个常量
 * public final static int MIN_PRIORITY = 1;
 * public final static int NORM_PRIORITY = 5;
 * public final static int MAX_PRIORITY = 10;
 */
