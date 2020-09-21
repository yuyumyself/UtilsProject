package com.china.hcg.thread;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.china.hcg.http.HttpClientUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @autor hecaigui
 * @date 2020-7-8
 * @description
 */
public class ThreadPoolUtilsDemo {

    /**
     * @description  * FixedThreadPool使用了有限的线程集来执行所提交的任务，
     *  * 一次性预先执行代价高昂的线程分配，因而可以限制线程数量和节约创建线程时间。、
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		Date date=new Date();
        //ThreadPoolUtilsDemo.controllerConcurrencyTest();
//		Date date2=new Date();
//		System.out.println(date2.getTime()-date.getTime());
    }

    /**
     * 控制层接口并发简易测试
     * @author hecaigui
     * @date 2020-7-21
     * @param
     * @return
     */
    public static void controllerConcurrencyTest(){
        ExecutorService exec= Executors.newFixedThreadPool(2000);
        JSONArray concurrencyResult = new JSONArray();

        for (int i = 0; i < 2500; i++) {
            exec.execute(new Runnable(){
                @Override
                public void run(){
                    //System.err.println(Thread.currentThread().getName()+"============");
                    Date date=new Date();
                    ArrayList toread =new ArrayList<>();
                    toread.add("toread");
                    ArrayList moduleList =new ArrayList<>();
                    moduleList.add("RECEIVAL");

                    JSONObject postObj = new JSONObject();
                    postObj.put("tokenid","dXNlcm5hbWU9dGVzdCZkdD0yMDIwMDExNzA5NDA0NyZjb2RlPTYzZTQ4NTk1ZmIyMTY3NGY0ODZjMjUzMWFmNDBkNDcx");
                    postObj.put("stateList",toread);
                    postObj.put("moduleList",moduleList);
                    HttpClientUtil.post("http://192.168.210.171:6051/openApi/wflow/getTodoAndToRead",postObj);
                    Date date2=new Date();
                    System.err.println(Thread.currentThread().getName()+"============耗时"+(date2.getTime()-date.getTime())+"毫秒");
                    concurrencyResult.add(Thread.currentThread().getName()+"============耗时"+(date2.getTime()-date.getTime())+"毫秒");
                    //System.err.println(concurrencyResult.toJSONString());
                }
            });
        }
        exec.shutdown();
    }
    /**
     * 静态方法测试： 静态方法可以被多线程同时调用，然后同时运行
     * @author hecaigui
     * @date 2020-7-21
     * @param args
     * @return
     */
    public static void staticMethodTest(String[] args) {
        ExecutorService exec= Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new Runnable(){
                @Override
                public void run(){
                    ThreadPoolUtilsDemo.staticMethodCanCalledByThreadHowMuchOnSameTime();
                }
            });
        }
        exec.shutdown();
    }
    // https://www.cnblogs.com/-ROCKS/p/6108490.html 静态方法并发问题
    // 静态方法可以被多线程同时调用，然后同时运行
    // 变量共享问题了？
    // 内存回收问题了？
    public static void  staticMethodCanCalledByThreadHowMuchOnSameTime(){
        System.err.println(Thread.currentThread().getName());
        while(true){

        }
        //System.err.println(Thread.currentThread().getName()+"over");
    }


    /**
     * @description 自定义线程池
     * @author hecaigui
     * @date 2020-8-27
     * @param
     * @return
     */
    public void selfDefThreadPoolExecutor(){
//        通过ThreadPoolExecutor类可以快速创建自定义的线程池。
//        构造方法参数介绍：
//        corePoolSize：线程池中所保存的核心线程数，包括空闲线程。
//        maximumPoolSize：池中允许的最大线程数。
//        keepAliveTime：线程池中的空闲线程所能持续的最长时间。
//        unit：持续时间的单位。
//        workQueue：任务执行前保存任务的队列，仅保存由execute方法提交的Runnable任务。
        //注:
            //要使用带有ThreadFactory参数的ThreadPoolExecutor构造方法哦，这样你就可以方便的设置线程名字啦。
            //创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。创建线程池的时候请使用带ThreadFactory的构造函数，并且提供自定义ThreadFactory实现或者使用第三方实现。
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MICROSECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("线程名自定义");
                t.setDaemon(true);
                System.out.println("创建线程"+t);
                return  t;
            }
        });
        MyTask1 task = new MyTask1();
        es.submit(task);
    }
    public static class MyTask1 implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+"当前运行的Thrad为:"+Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
