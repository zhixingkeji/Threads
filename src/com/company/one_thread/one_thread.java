package com.company.one_thread;

import com.company.config.Logger;

import java.util.random.RandomGenerator;

public class one_thread {
//    private static Logger logger = Logger.getLogger(one_thread.class);


    public static void main(String[] args) {
//        logger.info("测试");


        //测试单线程
//        test1();

        //测试多线程
//        test2();


        //线程的四种创建方法
//        t1_create();
//        t2_create();
//        t3_create();
        t4_create();

    }


    // 测试单线程
    public static void test1(){
        RandomT randomT = new RandomT();
        Thread thread = new Thread(randomT);
        thread.start();
    }


    //测试多线程
    public static void test2(){
        RandomT randomT = new RandomT();
        Thread t1 = new Thread(randomT);
        Thread t2 = new Thread(randomT);
        Thread t3 = new Thread(randomT);
        Thread t4 = new Thread(randomT);

        // run方法不能启动新线程 start方法可以启动新线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();

//        t1.run();
//        t2.run();
//        t3.run();
//        t4.run();

    }






    //创建线程方法1
    static class Task1 implements Runnable{

        @Override
        public void run() {
            System.out.println('['+ Thread.currentThread().getName() + ']' + "创建线程第1个方法");
        }
    }



    public static void t1_create() {
        //第2个参数可选,可以指定线程名称
        new Thread (new Task1(),"wl1").start();
    }



    //创建线程方法2 推荐
    public static void t2_create() {
        //第2个参数可选,可以指定线程名称

        new Thread (() -> {
            System.out.println('['+ Thread.currentThread().getName() + ']' + "创建线程第2个方法");
        },"wl2").start();
    }

    //创建线程方法3 继承thread类
    static class Task3 extends Thread {
        @Override
        public void run(){
            System.out.println('['+ Thread.currentThread().getName() + ']' + "创建线程第3个方法");
        }
    }

    public static void t3_create() {
        new Thread (new Task3(),"wl3").start();
    }


    //创建线程方法4 内部类

    public static void t4_create() {

        new Thread (
                new Thread(){
                    @Override
                    public void run(){
                        System.out.println('['+ Thread.currentThread().getName() + ']' + "创建线程第4个方法");
                    }
                },"wl4"
        ).start();
    }
}
