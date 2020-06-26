package utils;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description
 */
public class ThreadUtils {
    /**
     * @description 当前线程休眠
     * @param   sleepTime ms
     */
    public static void sleep(long sleepTime){
        try {
            Thread.sleep(sleepTime);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * @description 当前线程休眠1s
     */
    public static void sleep(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
