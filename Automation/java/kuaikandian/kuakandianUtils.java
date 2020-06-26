package kuaikandian;

import common.utils.AdbManipulateAppUtils;
import common.utils.OpenCMD;

/**
 * @autor hecaigui
 * @date 2020-1-21
 * @description
 */
public class kuakandianUtils extends AdbManipulateAppUtils {
    @Override
    public   void startQianKa(OpenCMD openCMD){
        openCMD.writeIntoCmd("am start -n  com.yuncheapp.android.pearl/com.kuaishou.athena.MainActivity");
    }
}
