package com.company.one_thread;

import java.util.concurrent.TimeUnit;

//线程休眠
public class Tsleep {

    public static void main(String[] args) {
        //测试主线程休眠
//        test_sleep();

        //测试多线程休眠
        test_sleep2();
    }


    //主线程休眠
    public static void test_sleep(){
        System.out.println("开始执行");
        try {
            System.out.println("开始休眠2秒");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("结束执行");
    }



    //多线程分别休眠
    public static void test_sleep2(){
        //先启动子线程
        new Thread (() -> {

            System.out.println("新线程开启");
            try {
                System.out.println("新线程休眠5秒");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("新线程结束");
        }).start();




        System.out.println("主线程开始执行");
        try {
            System.out.println("主线程开始休眠2秒");
//            Thread.sleep(2000);
            // 使用更明显的api进行休眠
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程结束执行");




    }

}
