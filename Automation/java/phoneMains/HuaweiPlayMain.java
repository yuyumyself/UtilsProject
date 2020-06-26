package phoneMains;

import common.utils.AdbCommand;
import common.utils.OpenCMD;
import douying.ShuaBao;
import promotions.JingDong618;
import qianka.QianKaGuanKan;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description 荣耀play
 */
public class HuaweiPlayMain {
    public static void main(String[] args) {
        OpenCMD openCMD = new OpenCMD();
        // 视屏类
        //AdbCommand startTask = new JishuDouYing(openCMD);
        //AdbCommand startTask = new JishuDouYing(openCMD,"6EJ4C18609008033");
       //i AdbCommand startTask = new JishuKuashou(openCMD,"6EJ4C18609008033");
       //AdbCommand startTask = new ShuaBao(openCMD,"6EJ4C18609008033");

       // 活动类
        AdbCommand startTask = new JingDong618(openCMD,"6EJ4C18609008033");
        startTask.execute();
    }

}
