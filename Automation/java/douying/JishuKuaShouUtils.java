package douying;

import common.utils.AdbManipulateAppUtils;
import common.utils.OpenCMD;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description
 */
public class JishuKuaShouUtils extends AdbManipulateAppUtils {
    @Override
    public   void startQianKa(OpenCMD openCMD){
        openCMD.writeIntoCmd("am start -n  com.kuaishou.nebula/com.yxcorp.gifshow.HomeActivity");
    }
}
