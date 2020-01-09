package com.cui.chapter02.p02_01_synchronized_method;

class PublicVar {
    public String username = "A";
    public String password = "AA";

    synchronized public void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(1000);
            this.password = password;
            System.out.println("setValue method thread name=" + Thread.currentThread().getName() +
                    " username=" + username + " password=" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getValue() {
        System.out.println("getValue method thread name=" + Thread.currentThread().getName() +
                " username=" + username + " password=" + password);
    }
}

class ThreadA5 extends Thread {
    private PublicVar publicVar;

    public ThreadA5(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B", "BB");
    }
}

/**
 * 2.1.5 脏读
 *
 * 发生脏读的情况是在读取实例变量时，此值已经被其他线程更改过了。
 *
 * 解决办法就是在getValue()方法也加上synchronized关键字。
 */
public class Run5 {
    public static void main(String[] args) {
        PublicVar publicVarRef = new PublicVar();
        ThreadA5 thread = new ThreadA5(publicVarRef);
        thread.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        publicVarRef.getValue();
    }
}
