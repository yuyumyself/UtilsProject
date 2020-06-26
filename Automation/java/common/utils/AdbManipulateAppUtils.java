package common.utils;

import common.utils.OpenCMD;
import utils.ThreadUtils;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description
 */
public abstract class AdbManipulateAppUtils {
    public abstract   void startQianKa(OpenCMD openCMD);

    /*
     * 操作手势
     */

    /**
     * @description 点击
     * @param coordinate  单个坐标点例 "955 2100"
     */
    public static  void click(OpenCMD openCMD,String coordinate){
        openCMD.writeIntoCmd("input tap "+coordinate);
    }
    /**
     * @description 固定滑动
     */
    public static  void swipe(OpenCMD openCMD){
        openCMD.writeIntoCmd("input swipe  300 800 300 300");
    }
    /**
     * @description
     * @param swipeCoordinate  滑动坐标点例 300 800 300 300
     * @return
     */
    public static  void swipe(OpenCMD openCMD,String swipeCoordinate){
        openCMD.writeIntoCmd("input swipe "+swipeCoordinate);
    }
    /*
     * 实体键
     */

    public static  void returnButton(OpenCMD openCMD){
        openCMD.writeIntoCmd("input keyevent 4");
    }

    public static  void downSoundVolume(OpenCMD openCMD){
        openCMD.writeIntoCmd("input keyevent 25");
    }

    /*
     * 设置
     */
    public static  void wifiOpen(OpenCMD openCMD){
        openCMD.writeIntoCmd("svc wifi enable");
    }
    /*
     * 截屏
     */
    public static  void screen(String screenFileName , String outputAddress){
        OpenCMD openCMD = new OpenCMD();
        AdbCmd adbCmd = new AdbCmd(openCMD,"6EJ4C18609008033");
        if(screenFileName == null || screenFileName.isEmpty()){
            screenFileName = "/sdcard/screen.png";
        }
        if(outputAddress == null || outputAddress.isEmpty()){
            String currentUserWorkingPath = System.getProperty("user.dir");
            outputAddress = currentUserWorkingPath;
            System.err.println(outputAddress);
        }

        openCMD.writeIntoCmd("adb shell screencap "+ screenFileName);
        ThreadUtils.sleep(2000);
        openCMD.writeIntoCmd("adb pull "+ screenFileName +" "+ outputAddress);
        ThreadUtils.sleep(2000);
        openCMD.closeCmd();
    }


    public static void main(String[] args) {
        screen("","");
    }

    public static class  AdbCmd extends AdbCommand{
        public AdbCmd(OpenCMD openCMD, String deviceSerialNumber){
            super(openCMD,deviceSerialNumber,false);
            AdbManipulateAppUtils.wifiOpen(openCMD);
        }
        @Override
        public void execute(){

        }
    }

}
