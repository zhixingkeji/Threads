package com.company.one_thread;

public class RandomT implements Runnable{
    @Override
    public void run() {
        java.util.Random random = new java.util.Random();
        for (int i = 0 ;i<10 ; i++) {
            int nextInt = random.nextInt(10);

            //获取当前的线程名
            System.out.println('['+ Thread.currentThread().getName() + ']' + "生成随机数"+nextInt);
        }
    }
}
