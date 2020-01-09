package com.cui.chapter01.p01_07_stop_thread;

class SynchronizedObject {
    private String username = "a";
    private String password = "aa";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SynchronizedObject{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    synchronized public void printString(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(100000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread9 extends Thread {
    private SynchronizedObject object;

    public MyThread9(SynchronizedObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        object.printString("b", "bb");
    }
}

/**
 * 使用stop()释放锁将会给数据造成不一致性的后果。如果出现这样的情况，
 * 程序处理的数据就有可能遭到破坏，最终导致程序执行的流程错误用。
 */
public class Run9 {
    public static void main(String[] args) throws InterruptedException {
        try {
            SynchronizedObject object = new SynchronizedObject();
            MyThread9 myThread9 = new MyThread9(object);
            myThread9.start();
            Thread.sleep(500);
            myThread9.stop();
            System.out.println(object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
