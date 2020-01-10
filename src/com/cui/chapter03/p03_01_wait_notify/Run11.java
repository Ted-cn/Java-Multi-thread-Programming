package com.cui.chapter03.p03_01_wait_notify;

class Producer {
    private String lock;

    public Producer(String lock) {
        this.lock = lock;
    }
    public void setValue() {
        try {
          synchronized (lock) {
              if (!ValueObject11.value.equals("")) {
                  lock.wait();
              }
              String value = System.currentTimeMillis() + "_" + System.nanoTime();
              System.out.println("set的值是：" + value);
              ValueObject11.value = value;
              lock.notify();
              Thread.sleep(1000);
          }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer {
    private String lock;
    public Consumer(String lock) {
        this.lock = lock;
    }
    public void getValue() {
        try {
            synchronized (lock) {
                if (ValueObject11.value.equals("")) {
                    lock.wait();
                }
                System.out.println("get的值是：" + ValueObject11.value);
                ValueObject11.value = "";
                lock.notify();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ValueObject11 {
    public static String value = "";
}

/**
 * 生产者/消费者模式实现
 *
 */
public class Run11 {
    public static void main(String[] args) {
        String lock = new String("");
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);
        new Thread(()-> {
            for (int i = 0; i < 3; i++) {
                producer.setValue();

            }
        }, "P").start();

        new Thread(()-> {
            for (int i = 0; i < 3; i++) {
                consumer.getValue();
            }
        }, "C").start();
    }
}
