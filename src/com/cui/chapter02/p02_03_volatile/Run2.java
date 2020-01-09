package com.cui.chapter02.p02_03_volatile;

class PrintString2 extends Thread {
    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    @Override
    public void run() {
        printStringMethod();
    }

    public void printStringMethod() {
        try {
            while (isContinuePrint) {
                //System.out.println("run printStringMethod threadName=" + Thread.currentThread().getName());
                //Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 2.3.2 解决同步死循环
 *
 * volatile关键字的作用是强制从公共堆栈中取得变量的值，而不是从线程私有数据栈中取。
 *
 * 书上说“但当上面的救命代码的格式运行在-server服务模式中64bit的JVM上时，会出现死循环。解决的办法是使用volatile关键字”
 *
 * 但使用java -version命令查看运行环境后，发现本机就是-server服务模式中64bit的JVM（64位的jdk 1.8 amd64，只能运行在Server模式下）
 * 却并没有出现预期的死循环，搜索无果后，这个问题值得保留！!!
 *
 * 发现问题与while()循环体内的代码有关，注释后即可。但仍不知为何！！！
 */
public class Run2 {
    public static void main(String[] args) {
        PrintString2 printString = new PrintString2();
        new Thread(printString).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我要停止它！stopThread=" + Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }
}
