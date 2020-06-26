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
public class QianKaMalashong extends AdbCommand {
    public QianKaMalashong(OpenCMD openCMD){
        super(openCMD);
        AdbManipulateAppUtils.wifiOpen(openCMD);
    }
    @Override
    public void execute(){
        new QianKaUtils().startQianKa(openCMD);

        ThreadUtils.sleep(1000*20);//第一次开启应用多等会
        QianKaUtils.click(openCMD,"250 820");//马拉松
        ThreadUtils.sleep(1000*10);
 
        //默认4个50米
        int fiftyMetersNum = 8;
        for (int i=0;i<fiftyMetersNum;i++){
            QianKaUtils.click(openCMD,"120 1700");//50米
            ThreadUtils.sleep(1000*10);
        }
        //2个视频
        int vedioNum = 2;
        for (int i=0;i<vedioNum;i++){
            QianKaUtils.click(openCMD,"1080 1700");//视频
            ThreadUtils.sleep(1000*10);
            ThreadUtils.sleep(1000*35);//视频30s
            QianKaUtils.click(openCMD,"1125 66");//视频完结，X号
            ThreadUtils.sleep(1000*10);
        }
        openCMD.closeCmd();
    }
}
