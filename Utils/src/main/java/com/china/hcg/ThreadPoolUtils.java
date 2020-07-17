package com.china.hcg;



import com.sun.jmx.snmp.tasks.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @autor hecaigui
 * @date 2020-7-8
 * @description
 */
public class ThreadPoolUtils {

    /**
     * @description  * FixedThreadPool使用了有限的线程集来执行所提交的任务，
     *  * 一次性预先执行代价高昂的线程分配，因而可以限制线程数量和节约创建线程时间。、
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		Date date=new Date();
        ExecutorService exec= Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new Runnable(){
                @Override
                public void run(){
                    ThreadPoolUtils.staticMethodCanCalledByThreadHowMuchOnSameTime();
                }
            });
        }
        exec.shutdown();
//		Date date2=new Date();
//		System.out.println(date2.getTime()-date.getTime());
    }

    // 静态方法可以被多线程同时调用，然后同时运行
    // 变量共享问题了？
    // 内存回收问题了？
    public static void  staticMethodCanCalledByThreadHowMuchOnSameTime(){
        System.err.println(Thread.currentThread().getName());
        while(true){

        }
        //System.err.println(Thread.currentThread().getName()+"over");
    }
}
