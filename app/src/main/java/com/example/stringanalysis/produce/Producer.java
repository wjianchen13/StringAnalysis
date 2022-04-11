package com.example.stringanalysis.produce;

public class Producer extends Thread {

    public static int index = 0;

    //所属的仓库
    public AbstractStorage abstractStorage;


    public Producer(AbstractStorage abstractStorage){
        this.abstractStorage = abstractStorage;
    }

    // 线程run函数
    @Override
    public void run() {
        Person p = new Person("hello", index ++);
        produce(p);
    }

    // 调用仓库Storage的生产函数
    public void produce(Person p) {
        abstractStorage.produce(p);
    }
}