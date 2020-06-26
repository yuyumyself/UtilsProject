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
public class QianKaYueDu extends AdbCommand {
    public QianKaYueDu(OpenCMD openCMD){
        super(openCMD);
        AdbManipulateAppUtils.wifiOpen(openCMD);
    }
    @Override
    public void execute(){
        new QianKaUtils().startQianKa(openCMD);
        //第一次开启应用多等会
        ThreadUtils.sleep(1000*20);

        int seeVedioNum = 200/10;
        for (int i=0;i<seeVedioNum;i++){
            if (i >= 10){
                QianKaUtils.click(openCMD,"165 1230");
                ThreadUtils.sleep(1000*10);
            }
            QianKaUtils.click(openCMD,"550 1360");
            ThreadUtils.sleep(1000*10);
            int huadongNum = 20;
            for (int huadong=0;huadong<huadongNum;huadong++){
                QianKaUtils.swipe(openCMD);
            }
            ThreadUtils.sleep(1000*10);
            QianKaUtils.returnButton(openCMD);
            QianKaUtils.click(openCMD,"1140 100");
            ThreadUtils.sleep(1000*30);
        }
        openCMD.closeCmd();
    }
}
