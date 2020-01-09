package com.cui.chapter03.p03_01_wait_notify;

import java.util.ArrayList;
import java.util.List;

class Add {
    private String lock;

    public Add(String lock) {
        this.lock = lock;
    }

    public void add(){
        synchronized (lock) {
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}

class Subtract {
    private String lock;

    public Subtract(String lock) {
        this.lock = lock;
    }

    public void subtract() {
        synchronized (lock) {
            if (ValueObject.list.size() == 0) {
                System.out.println("wait begin ThreadName=" + Thread.currentThread().getName());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait end ThreadName=" + Thread.currentThread().getName());
            }
            ValueObject.list.remove(0);
            System.out.println("list size=" + ValueObject.list.size());
        }
    }
}

class ValueObject {
    public static List list = new ArrayList();
}
/**
 * 3.1.10 等待wait的条件发生变化
 *
 */
public class Run10 {
    public static void main(String[] args) {
        String lock = new String("");
        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);

        new Thread(()-> {
            subtract.subtract();
        }, "subtract1Thread").start();

        new Thread(()-> {
            subtract.subtract();
        }, "subtract2Thread").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()-> {
            add.add();
        }, "addThread").start();
    }
}
