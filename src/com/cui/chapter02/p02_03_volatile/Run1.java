package com.cui.chapter02.p02_03_volatile;

class PrintString1 {
    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMethod() {
        try {
            while (isContinuePrint) {
                System.out.println("run printStringMethod threadName=" + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 2.3.1 volatile关键字与死循环
 *
 * 程序开始运行后，根本停不下来，原因是main线程一直在while循环中。
 */
public class Run1 {
    public static void main(String[] args) {
        PrintString1 printString = new PrintString1();
        printString.printStringMethod();
        System.out.println("我要停止它！stopThread=" +Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }
}
