package common.utils;

/**
 * @autor hecaigui
 * @date 2020-1-9
 * @description
 */
//命令接口。让所有的命令对象具有同一个方法。
public abstract class AdbCommand {
    public OpenCMD openCMD;
    public AdbCommand(OpenCMD openCMD){
        this.openCMD = openCMD;
        openCMD.writeIntoCmd("F:");
        openCMD.writeIntoCmd("cd F:\\he_space\\VersionControl\\projectRepository\\myself\\Automation\\ADB");
        openCMD.writeIntoCmd("adb shell");

        //AdbManipulateAppUtils.wifiOpen(openCMD);
    }
    public AdbCommand(OpenCMD openCMD,String deviceSerialNumber){
        this.openCMD = openCMD;
        openCMD.writeIntoCmd("F:");
        openCMD.writeIntoCmd("cd F:\\he_space\\VersionControl\\projectRepository\\myself\\Automation\\ADB");
        openCMD.writeIntoCmd("adb -s "+ deviceSerialNumber +" shell");

        //AdbManipulateAppUtils.wifiOpen(openCMD);
    }
    public AdbCommand(OpenCMD openCMD,String deviceSerialNumber,boolean openShell){
        this.openCMD = openCMD;
        openCMD.writeIntoCmd("F:");
        openCMD.writeIntoCmd("cd F:\\he_space\\VersionControl\\projectRepository\\myself\\Automation\\ADB");
        if (openShell){
            openCMD.writeIntoCmd("adb -s "+ deviceSerialNumber +" shell");
        }

        //AdbManipulateAppUtils.wifiOpen(openCMD);
    }
    public  abstract void execute();
}
