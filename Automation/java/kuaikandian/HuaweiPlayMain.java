package kuaikandian;

import common.utils.AdbCommand;
import common.utils.OpenCMD;
import douying.JishuKuashou;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description 荣耀play
 */
public class HuaweiPlayMain {
    public static void main(String[] args) {
        OpenCMD openCMD = new OpenCMD();
        //AdbCommand startTask = new JishuDouYing(openCMD);
        AdbCommand startTask = new Kuakandian(openCMD,"6EJ4C18609008033");
        startTask.execute();
    }
}
