package com.example.stringanalysis.produce;

import java.util.LinkedList;

/**
 *  生产者和消费者的问题
 *  wait、notify/notifyAll() 实现
 */
public class Storage1 implements AbstractStorage {

    //仓库存储的载体
    private LinkedList<Person> list = new LinkedList<>();

    //生产产品
    public synchronized void produce(Person p){
        if(list != null) {
            list.add(p);
            notifyAll();
        }
    }

    //消费产品
    public synchronized Person consume(){
        if(list.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(list != null && list.size() > 0) {
            Person p = list.get(0);
            list.remove(0);
            return p;
        }
        return null;
    }

}