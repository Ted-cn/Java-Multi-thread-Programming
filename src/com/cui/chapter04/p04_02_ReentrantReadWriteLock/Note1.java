package com.cui.chapter04.p04_02_ReentrantReadWriteLock;

/**
 * ReentrantLock类具有完全互斥排他的效果，即同一时间只有一个线程在执行ReentrantLock.lock()方法后面的任务。
 * 这样做虽然保证了实例变量的线程安全，但效率却是非常低下的。所以在JDK中还提供了一种读写锁ReentrantReadWriteLock类，
 * 使用它可以加快运行效率，在某些不需要操作实例变量的方法中，完全可以使用读写锁来提供该方法的代码运行速度。
 */
public class Note1 {
}
