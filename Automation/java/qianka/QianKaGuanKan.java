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
public class QianKaGuanKan extends AdbCommand {

    public QianKaGuanKan(OpenCMD openCMD){
        super(openCMD);
        AdbManipulateAppUtils.wifiOpen(openCMD);
    }
    @Override
    public void execute(){
        new QianKaUtils().startQianKa(openCMD);
        //第一次开启应用多等会
        ThreadUtils.sleep(1000*20);

        QianKaUtils.click(openCMD,"590 400");

        int seeVedioNum = 300/15;
        for (int i=0;i<seeVedioNum;i++){
            QianKaUtils.click(openCMD,"1060 1560");
            ThreadUtils.sleep(1000*35);
            QianKaUtils.click(openCMD,"1125 66");//视频完结，X号
        }
        openCMD.closeCmd();
    }
}
