package com.cui.chapter07.p07_05_thread_exception;

class MyTread extends Thread {
    @Override
    public void run() {
        String username = null;
        System.out.println(username.hashCode());
    }
}

public class Run1 {
    public static void main(String[] args) {
        MyTread t = new MyTread();
        t.start();
    }
}
