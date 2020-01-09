package com.cui.chapter01.p01_02_Thread_Runnable;

public class Demo01 {

    public static void main(String[] args) {
        /** 打印出当前线程的名称 */
        System.out.println(Thread.currentThread().getName());  // main
        /**
         * 在控制台中输出的main其实就是一个名称为main的线程在执行main()方法。
         * 需要说明的是，这个main线程和main方法没有任何关系，仅仅是同名而已。
         */
    }
}
