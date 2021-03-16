package com.china.hcg.file;

import jdk.nashorn.internal.runtime.regexp.JdkRegExp;

import java.io.*;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.apache.commons.codec.binary.Hex;

/**
 * @autor hecaigui
 * @date 2020-3-9
 * @description
 */
public class FileUtils {
    /**
     * @description 读取文件夹下的所有文件
     * @param  * @param path
     * @return
     */
    public static List<File> traverseFolder(String path) {
        List<File> traverseFolderResults = new ArrayList<File>();
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        //System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder(file2.getAbsolutePath());
                    } else {
                        traverseFolderResults.add(file2);
                        //System.out.println("文件:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }

        return traverseFolderResults;
    }
    /**
     * @description 文件复制
     * @param  * @param path
     * @param  destFilePathName F:\autoGenerateMapper\test.txt
     * @return
     */
    public static void copyFileUsingFileStreams(File source, String destFilePathName) {
        File dest ;
        if (destFilePathName !=null && ! "".equals(destFilePathName)){
            dest =  new File(destFilePathName);
        } else{
            return;
        }
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];

            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } catch (IOException exception){
            System.err.println(exception);
        } finally {
            try {
                input.close();
                output.close();
            } catch (IOException exception){
                System.err.println(exception);
            }
        }
    }


    /**
     * @description 读取文本内容
     * @param  * @param file
     * @return
     */
    public static String readFileContent(File file) {
        StringBuilder content = new StringBuilder();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
             fileReader = new FileReader(file);
             bufferedReader = new BufferedReader(fileReader);
            String line =bufferedReader.readLine();
            while (line != null){
                //System.out.println(line);
				if (line != null){
                    content.append(line+"\n");
                }
                line = bufferedReader.readLine();
            }
        }catch (IOException exception){
            System.err.println(exception);
        }finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException exception){
                System.err.println(exception);
            }
        }
        return content.toString();
    }
    /**
     * @description 文件转byte[]
     * @param  * @param file
     * @return
     */
    public static byte[] fileToByte(File file) {
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        //byte[] buffer = null;
        byte[] bytes = null;
        try {

            fis = new FileInputStream(file);
            baos = new ByteArrayOutputStream(fis.available());
            bytes = new byte[fis.available()];
            int temp;
            while ((temp = fis.read(bytes)) != -1) {
                baos.write(bytes, 0, temp);
            }
            //buffer = baos.toByteArray();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                baos.close();
            } catch (IOException exception){
                System.err.println(exception);
            }
        }
        //System.out.println(buffer.length);
        System.err.println(bytes.length);
        return bytes;
    }
    /**
     * @description 往文本写入内容
     * @param  * @param file
     * @return
     */
    public static void writeToFile(File file,String content) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.flush(); // 把缓存区内容压入文件
        }catch (IOException exception){
            System.err.println(exception);
        }finally {
            try {
                fileWriter.close();
                bufferedWriter.close();
            } catch (IOException exception){
                System.err.println(exception);
            }
        }
    }
    /**
     * @description 生成sha1，可用来验证文件完整性
     * <p>
     *     https://www.cnblogs.com/-beyond/p/10575078.html
     *     摘要算法简介：
     * 　　   摘要算法，也是加密算法的一种，还有另外一种叫法：指纹。
     *        摘要算法就是对指定的数据进行一系列的计算，然后得出一个串内容，该内容就是该数据的摘要。不同的数据产生的摘要是不同的.
     *     摘要算法作用：
     *        所以，可以用它来进行一些数据加密的工作：通过对比两个数据加密后的摘要是否相同，来判断这两个数据是否相同。
     * 　　   还可以用来保证数据的完整性，常见的软件在发布之后，会同时发布软件的md5和sha值，这个md5和sha值就是软件的摘要。当用户将软件下载之后，然后去计算软件的摘要，如果计算所得的摘要和软件发布方提供的摘要相同，则证明下载的软件和发布的软件一模一样，否则，就是下载过程中数据（软件）被篡改了。
     *
     * 　　常见的摘要算法包括：
     *          md、sha这两类。md包括md2、md4、md5；sha包括sha1、sha224、sha256、sha384、sha512。
     * </p>
     * @param
     * @return
     */
    public static String fileSha1(byte[] bytes) throws NoSuchAlgorithmException {
        // 获取指定摘要算法的messageDigest对象
        MessageDigest messageDigest = MessageDigest.getInstance("SHA"); // 此处的sha代表sha1

        // 调用digest方法，进行加密操作
        byte[] cipherBytes = messageDigest.digest(bytes);

        // 使用Apache的Hex类实现Hex(16进制字符串和)和字节数组的互转
        String cipherStr = Hex.encodeHexString(cipherBytes);

        System.out.println(cipherStr);
        return cipherStr;
    }
    /**
     * @description 通过字节来判断文件是否改变
     * @author hecaigui
     * @date 2021-3-5
     * @param bytes1
     * @param bytes2
     * @return true 文件改变 false 文件没改变
     */
    public static boolean fileChangeForByte(byte[] bytes1,byte[] bytes2)throws NoSuchAlgorithmException{
        String byte1ShaString = FileUtils.fileSha1(bytes1);
        String byte2ShaString = FileUtils.fileSha1(bytes2);
        if (byte1ShaString.equals(byte2ShaString)){
            return false;
        }
        return true;
    }

//    /**
//     * @description 二进制流（来源要为字符）转字符串。
//     * @param  * @param args
//     * @return
//     */
//    public static String streamToString(InputStream inputStream)
//    {
//        byte[] bytes = "hello world".getBytes();
//        // 字节进行base64编码
//        String encoded = Base64.getEncoder().encodeToString(bytes);
//        System.out.println( encoded );
//        // base64解码
//        byte[] decoded = Base64.getDecoder().decode(encoded);
//        System.out.println( new String(decoded) );
//    }

    public static void main(String[] args)
    {

//        String filePath = "C:\\Users\\Administrator\\Desktop\\1.pdf";
//        File file = new File(filePath);

        byte[] bytes = "hello world".getBytes();
        // 字节进行base64编码
        String encoded = Base64.getEncoder().encodeToString(bytes);
        System.out.println( encoded );
        // base64解码
        byte[] decoded = Base64.getDecoder().decode(encoded);
        System.out.println( new String(decoded) );
    }

//    public static void readFileContent(File file) {
//        String content = "";
//        FileReader fileReader = null;
//        BufferedReader bufferedReader = null;
//        try {
//            fileReader = new FileReader(file);
//            bufferedReader = new BufferedReader(fileReader);
//            String line =bufferedReader.readLine();
//            while (line!=null){
//                System.out.println(line);
//                line = bufferedReader.readLine();
//            }
//        }catch (IOException exception){
//            System.err.println(exception);
//        }finally {
//            try {
//                fileReader.close();
//                bufferedReader.close();
//            } catch (IOException exception){
//                System.out.println(exception);
//            }
//        }
//    }

	//文件转流
//	File file = new File(resourcePath);
//	new FileInputStream(file);
//	//将流转成字节数组
//	  ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//	  byte[] buff = new byte[100]; //buff用于存放循环读取的临时数据
//	  int rc = 0;
//	  while ((rc = inputIs.read(buff, 0, 100)) > 0) {
//		  outStream.write(buff, 0, rc);
//	  }
//	  //合并之后的字节数组
//	  byte[] in_merge = outStream.toByteArray();
}
