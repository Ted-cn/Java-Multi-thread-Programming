package com.cui.chapter02.p02_02_synchronized_block.s2_2_1;

public class MyThread1 extends Thread {
    private Task task;

    public MyThread1(Task task) {
        super();
        this.task = task;
    }

}
