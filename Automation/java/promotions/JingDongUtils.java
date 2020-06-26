package promotions;

import common.utils.AdbManipulateAppUtils;
import common.utils.OpenCMD;

/**
 * @autor hecaigui
 * @date  2020-5-26
 * @description
 */
public class JingDongUtils extends AdbManipulateAppUtils {
    @Override
    public   void startQianKa(OpenCMD openCMD){
        openCMD.writeIntoCmd("am start -n  com.jingdong.app.mall/.main.MainActivity");
    }
}
