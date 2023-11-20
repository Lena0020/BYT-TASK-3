package org.example;

interface ObjectPool<T> {
    T borrowObject();
    void returnObject(T obj);
}