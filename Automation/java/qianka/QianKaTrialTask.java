package qianka;

import common.utils.AdbCommand;
import common.utils.AdbManipulateAppUtils;
import common.utils.OpenCMD;
import utils.ThreadUtils;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description
 */
public class QianKaTrialTask extends AdbCommand {
    public QianKaTrialTask(OpenCMD openCMD){
        super(openCMD);
        AdbManipulateAppUtils.wifiOpen(openCMD);
    }
    @Override
    public void execute(){
        new QianKaUtils().startQianKa(openCMD);

        ThreadUtils.sleep(1000*20);//第一次开启应用多等会
        QianKaUtils.click(openCMD,"310 650");//试玩
        ThreadUtils.sleep(1000*10);

        //todo：手动填
        int todayTaskNum = 3;
        for (int i=0;i<todayTaskNum;i++){
            QianKaUtils.click(openCMD,"300 650");//我的任务
            QianKaUtils.click(openCMD,"80 430");//我的任务，第一个
            ThreadUtils.sleep(1000*10);

            QianKaUtils.click(openCMD,"600 1025");//开始任务
            ThreadUtils.sleep(1000*10);
            for (int tongyiquanxian=0;tongyiquanxian<5;tongyiquanxian++){
                QianKaUtils.click(openCMD,"850 1085"); //同意权限
                ThreadUtils.sleep(1000*3);
            }
            ThreadUtils.sleep(1000*60*5);//等待3分钟
            new QianKaUtils().startQianKa(openCMD);//返回应用
            ThreadUtils.sleep(1000*10);
            QianKaUtils.click(openCMD,"600 1135");//领取奖励
            ThreadUtils.sleep(1000*10);
            QianKaUtils.click(openCMD,"600 1250");//继续赚钱
            ThreadUtils.sleep(1000*10);
        }
        openCMD.closeCmd();
    }
}
