package com.example.stringanalysis.produce;

public interface AbstractStorage {
    Person consume();
    void produce(Person p);
}