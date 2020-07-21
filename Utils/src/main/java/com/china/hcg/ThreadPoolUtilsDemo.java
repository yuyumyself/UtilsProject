package com.china.hcg;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.china.hcg.http.HttpClientUtil;
import com.sun.jmx.snmp.tasks.Task;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

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
        ThreadPoolUtilsDemo.controllerConcurrencyTest();
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
