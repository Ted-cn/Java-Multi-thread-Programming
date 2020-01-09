package com.cui.chapter01.p01_02_Thread_Runnable;

class ALogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost2("a", "aa");
    }
}

class BLogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost2("b", "bb");
    }
}

public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    public static void doPost1(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(3000);
            }
            passwordRef = password;
            System.out.println("username = " + usernameRef + "\t password = " + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized public static void doPost2(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username = " + usernameRef + "\t password = " + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 演示“非线程安全”问题
 */
class Run {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }
}
