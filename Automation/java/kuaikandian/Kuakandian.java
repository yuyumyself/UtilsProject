package kuaikandian;

import common.utils.AdbCommand;
import common.utils.OpenCMD;
import utils.ThreadUtils;
import douying.JishuKuaShouUtils;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description 13-22.20
 */
public class Kuakandian extends AdbCommand {

    public Kuakandian(OpenCMD openCMD){
        super(openCMD);
    }
    public Kuakandian(OpenCMD openCMD, String deviceSerialNumber){
        super(openCMD,deviceSerialNumber);
    }
    @Override
    public void execute(){
        //关闭音量
//        for (int i=0;i<20;i++) {
//            JishuKuaShouUtils.downSoundVolume(openCMD);
//        }

        new kuakandianUtils().startQianKa(openCMD);
        //第一次开启应用多等会
        ThreadUtils.sleep(1000*20);
        //跳转到娱乐模块
        kuakandianUtils.click(openCMD,"840 155");
        ThreadUtils.sleep(1000*5);
        //int seeVedioNum = 180*60/10;
        for (int i=0;i<100;i++){
            kuakandianUtils.click(openCMD,"350 888");
            ThreadUtils.sleep(1000*10);
            for (int j=0;j<5;j++){
                JishuKuaShouUtils.swipe(openCMD);
                //
                ThreadUtils.sleep(1000*5);
                kuakandianUtils.click(openCMD,"955 2100");
                ThreadUtils.sleep(1000*2);
                JishuKuaShouUtils.returnButton(openCMD);
            }
            JishuKuaShouUtils.returnButton(openCMD);
            JishuKuaShouUtils.swipe(openCMD,"300 300 300 1200");
            ThreadUtils.sleep(1000*5);
        }
        openCMD.closeCmd();
    }
}
