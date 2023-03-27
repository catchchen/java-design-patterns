package com.iluwatar.singleton;

public class Singleton {
//    volatile是一个变量修饰符，只能用来修饰变量.Java并发编程中比较重要的一个关键字
//    声明一个可能被多线程同时访问的变量时，使用volatile修饰就可以了。
    private volatile static Singleton singleton;
    private Singleton (){}//https://juejin.cn/post/6844903656274264078
    public static Singleton getSingleton() {
        if (singleton == null) {
            // 双重锁校验的形式实现单例  volatile的作用 多线程下也是单例的
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
