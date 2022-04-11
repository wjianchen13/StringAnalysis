package com.example.stringanalysis.produce;

import android.os.SystemClock;

public class Consumer extends Thread {

    // 所在放置的仓库
    private AbstractStorage abstractStorage1;

    // 构造函数，设置仓库
    public Consumer(AbstractStorage abstractStorage1) {
        this.abstractStorage1 = abstractStorage1;
    }

    // 线程run函数
    public void run() {
        while (true) {
            Person p = abstractStorage1.consume();
            if(p != null)
                System.out.println("==========================> name: " + p.getName() + "  age: " + p.getAge());
            SystemClock.sleep(6000);
            System.out.println("==========================> sleep: ");
        }
    }

    // 调用仓库Storage的生产函数
    public void consume() {
        abstractStorage1.consume();
    }

}