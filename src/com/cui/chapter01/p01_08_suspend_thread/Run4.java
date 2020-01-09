package com.cui.chapter01.p01_08_suspend_thread;

class MyObject {
    private String username = "1";
    private String password = "11";

    public void setValue(String u, String p) {
        this.username = u;
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("停止a线程");
            Thread.currentThread().suspend();
        }
        this.password =p;
    }

    public void printUsernamePassword() {
        System.out.println(username + "\t" + password);
    }
}

/**
 * suspend()与resume()方法的缺点——不同步
 */
public class Run4 {
    public static void main(String[] args) {
        final MyObject myObject = new MyObject();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                myObject.setValue("a", "aa");
            }
        };
        thread1.setName("a");
        thread1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                myObject.printUsernamePassword();
            }
        };
        thread2.start();
    }
}
