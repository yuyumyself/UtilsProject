package promotions;

import common.utils.AdbCommand;
import common.utils.AdbManipulateAppUtils;
import common.utils.OpenCMD;
import douying.ShuaBaoUtils;
import utils.ThreadUtils;

/**
 * @autor hecaigui
 * @date  2020-5-26
 * @description 13-22.20
 */
public class JingDong618 extends AdbCommand {

    public JingDong618(OpenCMD openCMD){
        super(openCMD);
        AdbManipulateAppUtils.wifiOpen(openCMD);
    }
    public JingDong618(OpenCMD openCMD, String deviceSerialNumber){
        super(openCMD,deviceSerialNumber);
        AdbManipulateAppUtils.wifiOpen(openCMD);
    }
    @Override
    public void execute(){
        //关闭音量
//        for (int i=0;i<20;i++) {
//            ShuaBaoUtils.downSoundVolume(openCMD);
//        }

        //第一次开启应用多等会
        new JingDongUtils().startQianKa(openCMD);
        ThreadUtils.sleep(1000*10);

        JingDongUtils.click(openCMD,"1000 1700");
        ThreadUtils.sleep(1000*10);
        // 进行的任务
        this.xiaoJingLing(60);
        this.zuoRenWU(30);

        //关闭
        openCMD.closeCmd();
    }
    /**
     * @description 点击小精灵拿金币
     * @author hecaigui
     * @date 2020-5-26
     * @param  * @param
     * @return
     */
    public void xiaoJingLing(int num){
        for (int j = 0; j < num;j++){
            for (int i = 0; i < 7;i++){
                JingDongUtils.click(openCMD,"960 1130");
            }
            //5s会获取一次积分
            ThreadUtils.sleep(1000*5);
        }
    }
    /**
     * @description 做任务拿金币
     * @author hecaigui
     * @date 2020-5-26
     * @param  * @param
     * @return
     */
    public void zuoRenWU(int num){
        JingDongUtils.click(openCMD,"550 1700");
        ThreadUtils.sleep(1000*5);
        for (int j = 0; j < num;j++){
            JingDongUtils.click(openCMD,"900 1250");
            ThreadUtils.sleep(1000*5);
            JingDongUtils.swipe(openCMD);
            ThreadUtils.sleep(1000*10);
            JingDongUtils.returnButton(openCMD);
            ThreadUtils.sleep(1000*5);
        }
    }
}
