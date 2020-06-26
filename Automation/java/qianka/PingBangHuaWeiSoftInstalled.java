package qianka;

import common.utils.DefaultSleepTime;
import common.utils.OpenCMD;
import utils.ThreadUtils;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description
 */
public class PingBangHuaWeiSoftInstalled extends HuaWeiSoftInstalled{
    /**
     * 删除安装包 坐标
     */
    protected String deletePackageCoordinate = "795 1015";
    public PingBangHuaWeiSoftInstalled(OpenCMD openCMD){
        super(openCMD);//调用父类的有参构造方法。注：默认是调用父类的无参构造方法
        super.installSoftCoordinate = "895 1740";
        super.returnCoordinate = "335 1740";
    }
    @Override
    public void installSoftAndReturn(){
        super.installSoftAndReturn();
        super.openCMD.writeIntoCmd("input tap  "+deletePackageCoordinate);
        ThreadUtils.sleep(DefaultSleepTime.DefaultSleepTime);
    }
}
