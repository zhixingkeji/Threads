package com.company.one_thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//线程锁
public class Tlock {


    public static void main(String[] args) {
        test();
    }

    static int sum = 0;



    public static void test() {

        ExecutorService threadpool = Executors.newCachedThreadPool();
        Object lock  = new Object();

        for (int i = 0 ; i<1000 ; i++) {
            threadpool.execute(()->{
                //synchronized包裹临界区代码 同步执行
                synchronized (lock){
                    sum++;
                }

                System.out.println(sum);
            });
        }



    }
}
