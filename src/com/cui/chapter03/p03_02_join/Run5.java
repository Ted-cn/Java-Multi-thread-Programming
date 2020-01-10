package com.cui.chapter03.p03_02_join;

/**
 * 3.2.5 join(long)和sleep(long)的区别
 *
 * join方法的内部是使用wait来实现的，所以它具有释放锁的特点
 * 而sleep()方法却不能释放锁
 */
public class Run5 {
}
