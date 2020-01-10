package com.cui.chapter03.p03_02_join;

/**
 * 3.2.1 学习join()方法前的铺垫
 *
 */
public class Run1 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadTest = new Thread(() -> {
            try {
                int secondValue = (int) (Math.random() * 10000);
                System.out.println(secondValue);
                Thread.sleep(secondValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadTest.start();
        Thread.sleep(10000);
        System.out.println("我想当threadTest对象执行完毕后再执行");
        System.out.println("但上面代码中的sleep()中的值应该写多少呢");
        System.out.println("答案是：根据不确定");
    }
}
