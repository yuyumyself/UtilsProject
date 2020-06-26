package phoneMains;

import common.utils.AdbCommand;
import common.utils.OpenCMD;
import douying.ShuaBao;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description oppo
 * oppo快速开启开发者模式：1. 拨号键盘直接拨号 *#8011#  2. https://blog.csdn.net/blovecat/article/details/84751243
 */
public class OppoMain {
    public static void main(String[] args) {
        OpenCMD openCMD = new OpenCMD();
        //AdbCommand startTask = new JishuDouYing(openCMD);
        //AdbCommand startTask = new JishuDouYing(openCMD,"7aad0e6");
        //AdbCommand startTask = new JishuKuashou(openCMD,"7aad0e6");
        AdbCommand startTask = new ShuaBao(openCMD,"7aad0e6");
        startTask.execute();
    }
}
