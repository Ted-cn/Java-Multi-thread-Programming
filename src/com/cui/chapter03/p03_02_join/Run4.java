package com.cui.chapter03.p03_02_join;

/**
 * 3.2.4 方法join(long)的使用
 *
 * join(long)方法中的参数是设定等待的时间
 */
public class Run4 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadTest = new Thread(() -> {
            System.out.println("begin Timer=" + System.currentTimeMillis());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadTest.start();
        threadTest.join(2000); // 只等2秒
        System.out.println("end Timer=" + System.currentTimeMillis());
    }
}
