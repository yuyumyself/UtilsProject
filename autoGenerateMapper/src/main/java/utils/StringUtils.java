package utils;

import java.util.Map;

/**
 * @autor hecaigui
 * @date 2020-3-10
 * @description
 */
public class StringUtils {
    /**
     * @description  根据map替换参数，来替换字符串
     */
    public static String traverseMapForReplaceString(Map<String,String> replaceParams, String sourceString ){
        String resultString = sourceString;
        for (String key : replaceParams.keySet()){
            resultString = resultString.replaceAll(key,replaceParams.get(key));
        }
        return resultString;
    }
}
