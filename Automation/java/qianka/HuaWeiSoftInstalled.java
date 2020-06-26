package qianka;

import common.utils.DefaultSleepTime;
import common.utils.OpenCMD;
import utils.ThreadUtils;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description
 */
public abstract class HuaWeiSoftInstalled {
    /**
     * cmd应用
     */
    protected OpenCMD openCMD;
    /**
     * 安装应用等待时间
     */
    protected long sleepTime = 1000*60*3;
    /**
     * 安装应用 坐标
     */
    protected  String installSoftCoordinate;
    /**
     * 完成安装返回 坐标
     */
    protected  String returnCoordinate;

    public HuaWeiSoftInstalled(OpenCMD openCMD){
        this.openCMD = openCMD;
    }
    public void installSoftAndReturn(){
        openCMD.writeIntoCmd("input tap  "+installSoftCoordinate);
        ThreadUtils.sleep(sleepTime);
        openCMD.writeIntoCmd("input tap  "+returnCoordinate);
        ThreadUtils.sleep(DefaultSleepTime.DefaultSleepTime);
    }
}
