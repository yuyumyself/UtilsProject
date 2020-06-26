package common.utils;

import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @autor hecaigui
 * @date 2020-2-18
 * @description
 */
public class ScheduledMultiThreadTool {
    private  static Integer taskExecuteCount = 0;
    public void timerExecute(Runnable task, Integer runTaskNum , long initialDelay , long period){
        if (runTaskNum == null || runTaskNum == 1){
            runTaskNum = 1;
        }
        ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(2);
        //initialDelay表示首次执行任务的延迟时间，period表示每次执行任务的间隔时间，TimeUnit.MILLISECONDS执行的时间间隔数值单位
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("time:"+System.currentTimeMillis());
                taskExecuteCount++;
            }
        }, 10, 5, TimeUnit.SECONDS);
        //执行两次后关闭计划任务
        while (!scheduled.isTerminated()){
            if (taskExecuteCount > 1){
                scheduled.shutdown();
            }
        }
    }

    public static void main(String[] args) {
//        ScheduledMultiThreadTool startTask = new ScheduledMultiThreadTool();
//        startTask.timerExecute();
        String s = 11+"//"+22;
        Map map = new HashMap();
        map.put("1","11");
        System.err.println(map.get("222"));

    }
}
