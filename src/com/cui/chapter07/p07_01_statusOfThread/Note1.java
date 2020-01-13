package com.cui.chapter07.p07_01_statusOfThread;

import java.util.concurrent.locks.LockSupport;

/**
 * 7.1 线程的状态
 *
 * 线程对象在不同的运行时期有不同的状态，状态信息就存在于State枚举类中
 *     public enum State {
 *         NEW,  // 至今尚未启动的线程处于这种状态
 *         RUNNABLE,  // 正在JVM中 执行的线程处于这种状态
 *         BLOCKED,  // 受阻塞并等待某个监视器锁的线程处于这种状态
 *         WAITING,  // 无限期地等待另一个线程来执行某一特定操作的线程处于这种状态
 *         TIMED_WAITING,  // 等待另一个线程来执行取决于指定等待时间的操作的线程处于这种状态
 *         TERMINATED;  // 已退出的线程处于这种状态
 *     }
 */
public class Note1 {
}
