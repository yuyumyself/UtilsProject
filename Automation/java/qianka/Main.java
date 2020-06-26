package qianka;

import common.utils.AdbCommand;
import common.utils.OpenCMD;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description
 */
public class Main {
    public static void main(String[] args) {
        OpenCMD openCMD = new OpenCMD();
        //AdbCommand startTask = new QianKaGuanKan(openCMD);
        //AdbCommand startTask = new QianKaYueDu(openCMD);
        //AdbCommand startTask = new QianKaTrialTask(openCMD);
        AdbCommand startTask = new QianKaMalashong(openCMD);
        startTask.execute();
    }
}
