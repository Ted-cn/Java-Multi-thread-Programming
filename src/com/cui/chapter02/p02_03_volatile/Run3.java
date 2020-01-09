package com.cui.chapter02.p02_03_volatile;

class RunThread extends Thread {
    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入run()方法了！");
        while (isRunning) {
            // System.out.println("我进循环了");
        }
        System.out.println("线程被停止了！");
    }
}

/**
 * 2.3.3 解决异步死循环
 *
 * 在启动RunTread.java线程时，变量private boolean isRunning = true; 存在于公共堆栈及线程的私有堆栈中。
 * 在JVM为-server模式时，为了线程运行的效率，线程一直在私有堆栈中取得isRunning的值是true。而代码
 * thread.setRunning(false)虽然被执行，更新的却是公共堆栈中的isRunning变量，并没有更新thread线程的私有
 * 堆栈，所以就一直是死循环状态。
 *
 * 同样的这里的while()循环体内不能有任务线程有关的代码，否则就不会出现死循环。
 */
public class Run3 {
    public static void main(String[] args) {
        try {
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("已经赋值为false");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
