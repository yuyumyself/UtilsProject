package douying;

import common.utils.AdbCommand;
import common.utils.AdbManipulateAppUtils;
import common.utils.OpenCMD;
import utils.ThreadUtils;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description 13-22.20
 */
public class JishuKuashou extends AdbCommand {

    public JishuKuashou(OpenCMD openCMD){
        super(openCMD);
        AdbManipulateAppUtils.wifiOpen(openCMD);
    }
    public JishuKuashou(OpenCMD openCMD, String deviceSerialNumber){
        super(openCMD,deviceSerialNumber);
        AdbManipulateAppUtils.wifiOpen(openCMD);
    }
    @Override
    public void execute(){
        //关闭音量
        for (int i=0;i<20;i++) {
            JishuKuaShouUtils.downSoundVolume(openCMD);
        }

        new JishuKuaShouUtils().startQianKa(openCMD);
        //第一次开启应用多等会
        ThreadUtils.sleep(1000*20);

        int seeVedioNum = 180*60/10;
        for (int i=0;i<seeVedioNum+10;i++){
            JishuKuaShouUtils.swipe(openCMD);
            //25s会获取一次积分
            ThreadUtils.sleep(1000*10);
        }
        openCMD.closeCmd();
    }
}
