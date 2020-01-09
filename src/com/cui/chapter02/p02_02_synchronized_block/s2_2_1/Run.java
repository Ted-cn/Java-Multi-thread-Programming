package com.cui.chapter02.p02_02_synchronized_block.s2_2_1;

/**
 * 2.2.1 synchronized方法的弊端
 *
 * 比如A线程调用同步方法执行一个长时间的任务，那么B线程则必须等待比较长的时间。
 */
public class Run {
    public static void main(String[] args) {
        Task task = new Task();
    }
}
