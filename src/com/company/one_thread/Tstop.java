package com.company.one_thread;

import java.util.concurrent.TimeUnit;

public class Tstop {


    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        //
        Thread t1 = new Thread(() -> {
            while(true) {
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("收到中断请求,退出");
                    break;
                }
            }

            System.out.println("新线程执行结束");

        });

        t1.start();

        //休眠2秒
        try {
            System.out.println("休眠2秒");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程发起中断请求");
        //主线程发起中断请求
        t1.interrupt();

    }
}
