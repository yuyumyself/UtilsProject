/**
 * 
 */
package com.china.hcg;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 *
 */
public class StringUtils {
	/**
	 * 生成唯一标识符
	 * @return
	 */
	public static String uuidString(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	/**
	 * 字符串转为二进制流
	 * @param string
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static ByteArrayInputStream toStream(String string) throws UnsupportedEncodingException {
		return new ByteArrayInputStream(string.getBytes("utf-8"));
	}
	/**
	 * 第一个字符大写
	 * @param fildeName
	 * @return
	 * @throws Exception
	 */
    public static String firstCapital(String fildeName) throws Exception{  
        byte[] items = fildeName.getBytes();  
        items[0] = (byte) ((char) items[0] - 'a' + 'A');  
        return new String(items);  
    }  
	/**
	 * 第一个字符小写
	 * @param fildeName
	 * @return
	 * @throws Exception
	 */
    public static String firstLower(String fildeName) throws Exception{  
        byte[] items = fildeName.getBytes();  
        items[0] = (byte) ((char) items[0]+32);  
        return new String(items);  
    }    
    /**
     * 获取文件后缀名
     * @param fileName
     * @return
     */
    public static String fileSuffix(String fileName) {
		String[] strings=fileName.split("\\.");
		if (strings.length>=2) return strings[strings.length-1];
    	return null;
	}
    /**
     * 获取文件前缀名
     * @param fileName
     * @return
     */
    public static String filePrefix(String fileName) {
		String[] strings=fileName.split("\\.");
		String name="";
		if (strings.length>=2) {
			for (int i = 0; i < strings.length-1; i++) {
				name+=strings[i];
			}
			return name;
		}
    	return null;
	}
    /**
     * 字符串为null或leng为0 返回true
     * @return
     */
    public static boolean isNull(String string) {
		if(string==null||string.length()==0)return true;
		return false;
	}
    /**
     * 子字符串在父字符串内，返回true。区分大小写
     * @param parentStr
     * @param sonStr
     * @return
     */
    public static Boolean isContain(String parentStr,String sonStr) {
    	if (parentStr==null||sonStr==null) {
			return null;
		}
        if(parentStr.indexOf(sonStr)!=-1){ 
        	//System.out.println("包含"); 
        	return true;
        }else{ 
        	//System.out.println("不包含"); 
        	return false;
        }     	
    }
    public static String delHTMLTag(String htmlStr){ 
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤  
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

        return htmlStr.trim(); //返回文本字符串 
    } 
    public static String delSpace(String htmlStr){ 
        htmlStr = htmlStr.replaceAll("\n", "");
        htmlStr = htmlStr.replaceAll("\t", "");
        return htmlStr.trim(); //返回文本字符串 
    }
	/*
	字符串截取：
		https://blog.csdn.net/zjx2016/article/details/74557301

		String sb = "bbbdsajj,d,s";
		1.
			sb.substring(2);//结果：bdsajj,d,s。从索引号为2开始截取，一直到字符串末尾
			sb.substring(2, 4);//结果：bd 。索引号2开始到索引好4结束
	字符串分割：
		String[]  strs=sb.split(",");//结果：bbbdsajj    d    s
		将正则传入split()。返回的是一个字符串数组类型。不过通过这种方式截取会有很大的性能损耗，因为分析正则非常耗时。
		注：
			1.无法分割点，.是正则表达式里的一个关键字，
			如果没有经过转义split会把它当作一个正则表达式来处理的，
			所以str.split("\\.");
			2.sb为"",好像会切割为[]。 !
	字符串替换
		http://c.biancheng.net/view/836.html
		例：
			../正则.txt
			//根据map替换参数，来替换字符串 replaceParams.put("域对象类名","User");
			public static String traverseMapForReplaceString(Map<String,String> replaceParams,String sourceString ){
				String resultString = sourceString;
				for (String key : replaceParams.keySet()){
					resultString = resultString.replaceAll(key,replaceParams.get(key));
				}
				return resultString;
			}			
			
	字符串转字符数组：
	    char ss[] = "rgrgd rgre 444".toCharArray();//利用toCharArray方法转换
        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i]);
        }
	将byte转为String：
		可以使用 String 接收 byte[] 参数的构造器来进行转换，
		注：
			需要注意的点是要使用的正确的编码，否则会使用平台默认编码。	
	String类中的intern()方法：！
		intern()方法会首先从常量池中查找是否存在该常量值，如果常量池中不存在则现在常量池中创建，如果已经存在则直接返回。
		例：
			String s1=”aa”; 
			String s2=s1.intern(); 
			System.out.print(s1==s2);//返回true			
	*/
	/*
	
	String和StringBuilder、StringBuffer的区别：
		Java平台提供了两种类型的字符串：String和StringBuffer/StringBuilder，它们均可以储存和操作字符串。
		String是常量字符串：
			String引用的字符串内容是不能被改变的。
			例：
				String str="abc";System.out.println(str);
				str=str+"de";System.out.println(str);
				该段代码会先输出“abc”，然后又输出“abcde”，好像是str这个对象被更改了，其实，这只是一种假象罢了。
				JVM对于这几行代码是这样处理的，首先创建一个String对象str，并把“abc”赋值给str，
				然后在第三行中，其实JVM又创建了一个新的对象也名为str，然后再把原来的str的值和“de”加起来再赋值给新的str。
				而原来的str就会被JVM的垃圾回收机制（GC）给回收掉了，所以，str实际上并没有被更改，也就是前面说的String对象一旦创建之后就不可更改了。
				所以，Java中对String对象进行的操作实际上是一个不断创建新的对象并且将旧的对象回收的一个过程，所以执行速度很慢。
		StringBuffer/StringBuilder是变量字符串：
			其表示的字符串对象可以直接进行修改。
			StringBuilder是Java 5中引入的，它和StringBuffer的方法完全相同，
			区别在于StringBuilder是在单线程环境下使用的，因为它的所有方法都没有被synchronized修饰，因此它的效率也比StringBuffer要高。
		总结：
	　　String：适用于少量的字符串操作的情况
	　　StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
	　　StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况	
	*/
    public static void main(String[] args){
        String regState = "id=\"__VIEWSTATE\" value=\".*\"{1}";
        String regValidation = "id=\"__EVENTVALIDATION\" value=\".*\"{1}";
        Pattern pattern = Pattern.compile(regValidation);
        String test = "17:04:12.869 [main] DEBUG org.springframework.web.client.RestTemplate - Created POST request for \"http://sp.fuzhou.gov.cn/Wechat_SM_Old/channel/wechat/WwyyDetail_WeChat.aspx?DeptName=%25u516c%25u5b89%25u4ea4%25u7ba1&YYSX=%25u7535%25u52a8%25u81ea%25u884c%25u8f66%25u65b0%25u8f66%25u62a5%25u724c&YYNO=0100107000&TargetType=0100107000&Pid=&Phone=\"\n" +
                "17:04:12.876 [main] DEBUG org.springframework.web.client.RestTemplate - Setting request Accept header to [text/plain, */*, application/json, application/*+json]\n" +
                "17:04:12.878 [main] DEBUG org.springframework.web.client.RestTemplate - Writing [{yysj=[2020-06-14]}] as \"application/x-www-form-urlencoded\" using [org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter@6743e411]\n" +
                "17:04:13.198 [main] DEBUG org.springframework.web.client.RestTemplate - POST request for \"http://sp.fuzhou.gov.cn/Wechat_SM_Old/channel/wechat/WwyyDetail_WeChat.aspx?DeptName=%25u516c%25u5b89%25u4ea4%25u7ba1&YYSX=%25u7535%25u52a8%25u81ea%25u884c%25u8f66%25u65b0%25u8f66%25u62a5%25u724c&YYNO=0100107000&TargetType=0100107000&Pid=&Phone=\" resulted in 200 (OK)\n" +
                "17:04:13.206 [main] DEBUG org.springframework.web.client.RestTemplate - Reading [java.lang.String] as \"text/html;charset=gb2312\" using [org.springframework.http.converter.StringHttpMessageConverter@2de23121]\n" +
                "post请求结果：\n" +
                "\n" +
                "<!DOCTYPE html>\n" +
                "\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    <title>预约服务</title>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;\">\n" +
                "    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n" +
                "    <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\n" +
                "    <meta name=\"format-detection\" content=\"telephone=no\">\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <link href=\"pwximg/map.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "    <link rel=\"stylesheet\" href=\"pwximg/plugmenu.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"images/wxp.css\">\n" +
                "    <script src=\"pwximg/zepto.min.js\" type=\"text/javascript\"></script>\n" +
                "    <script src=\"pwximg/plugmenu.js\" type=\"text/javascript\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"js/toTop.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"js/jquery-1.7.2.min.js\"></script>\n" +
                "    <script src=\"js/des.js\"></script>\n" +
                "    <script type=\"text/javascript\">\n" +
                "        $(function () {\n" +
                "            $(window).toTop({\n" +
                "                showHeight: 100,//设置滚动高度时显示\n" +
                "                speed: 500 //返回顶部的速度以毫秒为单位\n" +
                "            });\n" +
                "        });\n" +
                "    </script>\n" +
                "    <script>\n" +
                "        window.onload = function () {\n" +
                "            var oWin = document.getElementById(\"win\");\n" +
                "            var oLay = document.getElementById(\"overlay\");\n" +
                "            var oBtn = document.getElementById(\"popmenu\");\n" +
                "            oBtn.onclick = function () {\n" +
                "                oLay.style.display = \"block\";\n" +
                "                oWin.style.display = \"block\"\n" +
                "            };\n" +
                "            oLay.onclick = function () {\n" +
                "                oLay.style.display = \"none\";\n" +
                "                oWin.style.display = \"none\"\n" +
                "            }\n" +
                "        };\n" +
                "    </script>\n" +
                "    <style type=\"text/css\">\n" +
                "        button {\n" +
                "            width: 100%;\n" +
                "            text-align: center;\n" +
                "            border-radius: 10px;\n" +
                "        }\n" +
                "\n" +
                "        .button2 {\n" +
                "            font-size: 16px;\n" +
                "            padding: 8px 0;\n" +
                "            border: 1px solid #adadab;\n" +
                "            color: #000000;\n" +
                "            background-color: #e8e8e8;\n" +
                "            background-image: linear-gradient(to top, #dbdbdb, #f4f4f4);\n" +
                "            background-image: -webkit-gradient(linear, 0 100%, 0 0, from(#dbdbdb), to(#f4f4f4));\n" +
                "            box-shadow: 0 1px 1px rgba(0,0,0,0.45), inset 0 1px 1px #efefef;\n" +
                "            text-shadow: 0.5px 0.5px 1px #ffffff;\n" +
                "            border-radius: 10px;\n" +
                "            width: 80px;\n" +
                "        }\n" +
                "\n" +
                "            .button2:active {\n" +
                "                background-color: #dedede;\n" +
                "                background-image: linear-gradient(to top, #cacaca, #e0e0e0);\n" +
                "                background-image: -webkit-gradient(linear, 0 100%, 0 0, from(#cacaca), to(#e0e0e0));\n" +
                "            }\n" +
                "\n" +
                "        div:after {\n" +
                "            content: \".\";\n" +
                "            display: block;\n" +
                "            height: 0;\n" +
                "            clear: both;\n" +
                "            visibility: hidden;\n" +
                "        }\n" +
                "\n" +
                "        .detail {\n" +
                "            width: 100%;\n" +
                "            border-collapse: collapse;\n" +
                "            border: none;\n" +
                "            margin: 20px auto;\n" +
                "        }\n" +
                "\n" +
                "        .title {\n" +
                "            width: 40%;\n" +
                "            text-align: right;\n" +
                "        }\n" +
                "\n" +
                "        .content {\n" +
                "            width: 60%;\n" +
                "            text-align: left;\n" +
                "        }\n" +
                "\n" +
                "        .detail input, .detail select {\n" +
                "            border-radius: 10px;\n" +
                "            min-width: 150px;\n" +
                "            border: 1px solid #cccccc;\n" +
                "            height: 20px;\n" +
                "            line-height: 20px;\n" +
                "        }\n" +
                "    </style>\n" +
                "    <script type=\"text/javascript\">\n" +
                "        var InterValObj; //timer变量，控制时间\n" +
                "        var count = 60; //间隔函数，1秒执行\n" +
                "        var curCount;//当前剩余秒数\n" +
                "        var code = \"\"; //验证码\n" +
                "        var isright = 0;//验证码是否正确\n" +
                "        var hidcode = \"\";//输入一次成功后比较的验证码\n" +
                "        var codeLength = 6;//验证码长度\n" +
                "        function sendMessage() {\n" +
                "            curCount = count;\n" +
                "            var phone = document.all(\"telNo\").value;\n" +
                "            if (phone == \"\") {\n" +
                "                alert(\"手机号不能为空！\");\n" +
                "                return;\n" +
                "            }\n" +
                "            if (!IsMobile(phone)) {\n" +
                "                alert(\"手机号不正确！\");\n" +
                "                return;\n" +
                "            }\n" +
                "            //产生验证码\n" +
                "            for (var i = 0; i < codeLength; i++) {\n" +
                "                code += parseInt(Math.random() * 9).toString();\n" +
                "            }\n" +
                "            hidcode = code;\n" +
                "            isright = 0;\n" +
                "            //设置button效果，开始计时\n" +
                "            $(\"#btnSendCode\").attr(\"disabled\", \"true\");\n" +
                "            $(\"#btnSendCode\").val(\"请在\" + curCount + \"秒内输入验证码\");\n" +
                "            InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次\n" +
                "            //向后台发送处理数据\n" +
                "            $.ajax({\n" +
                "                type: \"POST\", //用POST方式传输\n" +
                "                dataType: \"text\", //数据格式:JSON\n" +
                "                url: '../Appointment/SendMessage.ashx', //目标地址\n" +
                "                data: \"count=\" + count + \"&phone=\" + phone + \"&code=\" + code,\n" +
                "                error: function (XMLHttpRequest, textStatus, errorThrown) { },\n" +
                "                success: function (msg) {\n" +
                "                    //alert(msg);\n" +
                "                    if (msg == \"1\") {\n" +
                "\n" +
                "                    } else if (msg == \"0\") {\n" +
                "\n" +
                "                    }\n" +
                "                }\n" +
                "            });\n" +
                "        }\n" +
                "        //timer处理函数\n" +
                "        function SetRemainTime() {\n" +
                "            if (curCount == 0) {\n" +
                "                window.clearInterval(InterValObj);//停止计时器\n" +
                "                $(\"#btnSendCode\").removeAttr(\"disabled\");//启用按钮\n" +
                "                $(\"#btnSendCode\").val(\"重新发送验证码\");\n" +
                "                code = \"\"; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效 \n" +
                "            }\n" +
                "            else {\n" +
                "                curCount--;\n" +
                "                $(\"#btnSendCode\").val(\"请在\" + curCount + \"秒内输入验证码\");\n" +
                "            }\n" +
                "        }\n" +
                "        function jiancepin() {\n" +
                "            var pin = document.all(\"pin\").value;\n" +
                "            if (isright == 0) {\n" +
                "                if (code != \"\") {\n" +
                "                    if (pin == code) {\n" +
                "                        document.getElementById(\"wrong\").style.display = \"none\";\n" +
                "                        document.getElementById(\"right\").style.display = \"block\";\n" +
                "                        isright = 1;\n" +
                "                        return true;\n" +
                "                    } else {\n" +
                "                        document.getElementById(\"right\").style.display = \"none\";\n" +
                "                        document.getElementById(\"wrong\").style.display = \"block\";\n" +
                "                        return false;\n" +
                "                    }\n" +
                "                }\n" +
                "            } else {\n" +
                "                if (hidcode != \"\") {\n" +
                "                    if (pin == hidcode) {\n" +
                "                        document.getElementById(\"wrong\").style.display = \"none\";\n" +
                "                        document.getElementById(\"right\").style.display = \"block\";\n" +
                "                        return true;\n" +
                "                    } else {\n" +
                "                        document.getElementById(\"right\").style.display = \"none\";\n" +
                "                        document.getElementById(\"wrong\").style.display = \"block\";\n" +
                "                        return false;\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "            return false;\n" +
                "        }\n" +
                "        function showResult(r, msg) {\n" +
                "            if (r == \"0\") {\n" +
                "                alert(msg);\n" +
                "                document.location.href = \"WwyySelect_WeChat.aspx\";\n" +
                "            }\n" +
                "            else if (r == \"1\") {\n" +
                "                alert(msg);\n" +
                "            }\n" +
                "        }\n" +
                "    </script>\n" +
                "    <script>\n" +
                "        function IsMobile(s) {\n" +
                "            var flg = false;\n" +
                "            var field13 = /^13\\d{9}$/g;\n" +
                "            var field14 = /^14\\d{9}$/g;\n" +
                "            var field15 = /^15\\d{9}$/g;\n" +
                "            var field17 = /^17\\d{9}$/g;\n" +
                "            var field18 = /^18\\d{9}$/g;\n" +
                "            if ((field13.exec(s)) || (field14.exec(s)) || (field15.exec(s)) || (field17.exec(s)) || (field18.exec(s))) {\n" +
                "                flg = true;\n" +
                "            }\n" +
                "            else {\n" +
                "                flg = false;\n" +
                "            }\n" +
                "            return flg;\n" +
                "        }\n" +
                "        function IsNoid(e) {\n" +
                "            var flag = 0;\n" +
                "            var v15 = /^\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d$/;\n" +
                "            var v18 = /^\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d[0-9x]$/;\n" +
                "            var area = { 11: \"北京\", 12: \"天津\", 13: \"河北\", 14: \"山西\", 15: \"内蒙古\", 21: \"辽宁\", 22: \"吉林\", 23: \"黑龙江\", 31: \"上海\", 32: \"江苏\", 33: \"浙江\", 34: \"安徽\", 35: \"福建\", 36: \"江西\", 37: \"山东\", 41: \"河南\", 42: \"湖北\", 43: \"湖南\", 44: \"广东\", 45: \"广西\", 46: \"海南\", 50: \"重庆\", 51: \"四川\", 52: \"贵州\", 53: \"云南\", 54: \"西藏\", 61: \"陕西\", 62: \"甘肃\", 63: \"青海\", 64: \"宁夏\", 65: \"xingjiang\", 71: \"台湾\", 81: \"香港\", 82: \"澳门\", 91: \"国外\" }\n" +
                "            if (area[parseInt(e.substr(0, 2))] == null) {\n" +
                "                //alert(\"diqufeifa\");\n" +
                "                flag = 5;\n" +
                "            } else if (e.length == 15) {\n" +
                "                if (!e.match(v15)) {\n" +
                "                    alert(e.length);\n" +
                "                    flag = 1;\n" +
                "                    //return false;\n" +
                "                }\n" +
                "                var year = e.substring(6, 8);\n" +
                "                var month = e.substring(8, 10);\n" +
                "                var day = e.substring(10, 12);\n" +
                "                var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));\n" +
                "                // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法   \n" +
                "                if (temp_date.getYear() != parseFloat(year)\n" +
                "                    || temp_date.getMonth() != parseFloat(month) - 1\n" +
                "                    || temp_date.getDate() != parseFloat(day)) {\n" +
                "                    //alert(\"youwentia!!\");\n" +
                "                    flag = 4;\n" +
                "                    //return false;   \n" +
                "                }\n" +
                "            } else if (e.length == 18) {\n" +
                "                if (!e.match(v18)) {\n" +
                "                    //alert(\"18位身份证号码应为数字,最后一位可为x\");\n" +
                "                    flag = 2;\n" +
                "                    //return false;\n" +
                "                }\n" +
                "                var year = e.substring(6, 10);\n" +
                "                var month = e.substring(10, 12);\n" +
                "                var day = e.substring(12, 14);\n" +
                "                var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));\n" +
                "                // 这里用getFullYear()获取年份，避免千年虫问题   \n" +
                "                if (temp_date.getFullYear() != parseFloat(year)\n" +
                "                    || temp_date.getMonth() != parseFloat(month) - 1\n" +
                "                    || temp_date.getDate() != parseFloat(day)) {\n" +
                "                    //alert(\"18weiyouwentia!!\");\n" +
                "                    flag = 4;\n" +
                "                    //return false;   \n" +
                "                }\n" +
                "            } else {\n" +
                "                //alert(\"身份证号码应为15或18位\");\n" +
                "                flag = 3;\n" +
                "                //return false;\n" +
                "            }\n" +
                "            return flag;\n" +
                "        }\n" +
                "        function checkNo() {\n" +
                "            if ($(\"#yysj\").val() == \"请选择\") {\n" +
                "                alert(\"预约日期还未选择\");\n" +
                "                return false;\n" +
                "            }\n" +
                "            if ($(\"#yysd\").val() == \"请选择\") {\n" +
                "                alert(\"预约时段还未选择\");\n" +
                "                return false;\n" +
                "            }\n" +
                "            if ($(\"#name\").val() == \"\") {\n" +
                "                alert(\"姓名不能为空\");\n" +
                "                return false;\n" +
                "            }\n" +
                "            if ($(\"#idNo\").val() == \"\") {\n" +
                "                alert(\"身份证号不能为空\");\n" +
                "                return false;\n" +
                "            } else {\n" +
                "                if ($(\"#telNo\").val() == \"\") {\n" +
                "                    alert(\"手机号不能为空\");\n" +
                "                    return false;\n" +
                "                }\n" +
                "                var flg = IsMobile($(\"#telNo\").val());\n" +
                "                if (!flg) {\n" +
                "                    alert(\"请输入正确的手机号\");\n" +
                "                    return false;\n" +
                "                }\n" +
                "                var flag = IsNoid($(\"#idNo\").val().toLowerCase());\n" +
                "                //alert(flag);\n" +
                "                if (($(\"#idNo\").val().startsWith(\"81\") || $(\"#idNo\").val().startsWith(\"82\") || $(\"#idNo\").val().startsWith(\"83\")) && $(\"#idNo\").val().length == 18) {\n" +
                "                    //港澳台证件\n" +
                "                }\n" +
                "                else {\n" +
                "                    if (flag == 1) {\n" +
                "                        alert(\"15位身份证号码应为数字\");\n" +
                "                        return false;\n" +
                "                    }\n" +
                "                    if (flag == 2) {\n" +
                "                        alert(\"18位身份证号码应为数字,最后一位可为x\");\n" +
                "                        return false;\n" +
                "                    }\n" +
                "                    if (flag == 3) {\n" +
                "                        alert(\"身份证号码应为15或18位\");\n" +
                "                        return false;\n" +
                "                    }\n" +
                "                    if (flag == 4) {\n" +
                "                        alert(\"身份证号码出生日期有误\");\n" +
                "                        return false;\n" +
                "                    }\n" +
                "                    if (flag == 5) {\n" +
                "                        alert(\"身份证号码地区非法\");\n" +
                "                        return false;\n" +
                "                    }\n" +
                "                }\n" +
                "                //if (hidcode == \"\") {\n" +
                "                //    alert(\"验证码还未发送！\");\n" +
                "                //    return false;\n" +
                "                //}\n" +
                "                //if (!jiancepin()) {\n" +
                "                //    alert(\"验证码不正确！\");\n" +
                "                //    return false;\n" +
                "                //}\n" +
                "            }\n" +
                "            if ($(\"#ddlObjectType\").val() == \"2\") {\n" +
                "                if (escape($(\"#entname\").val()).indexOf(\"%u\") < 0) {\n" +
                "                    alert(\"请输入正确的企业名称\");\n" +
                "                    return false;\n" +
                "                }\n" +
                "            }\n" +
                "\n" +
                "            //document.getElementById(\"idNo\").value = encMe(document.getElementById(\"idNo\").value, 'wechat');\n" +
                "            return true;\n" +
                "        }\n" +
                "        function reset1() {\n" +
                "            document.getElementById(\"idNo\").value = \"\";\n" +
                "            document.getElementById(\"telNo\").value = \"\";\n" +
                "            return true;\n" +
                "        }\n" +
                "    </script>\n" +
                "</head>\n" +
                "\n" +
                "<body class=\"map\">\n" +
                "    <form name=\"form1\" method=\"post\" action=\"WwyyDetail_WeChat.aspx?DeptName=%25u516c%25u5b89%25u4ea4%25u7ba1&amp;YYSX=%25u7535%25u52a8%25u81ea%25u884c%25u8f66%25u65b0%25u8f66%25u62a5%25u724c&amp;YYNO=0100107000&amp;TargetType=0100107000&amp;Pid=&amp;Phone=\" id=\"form1\">\n" +
                "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"/wEPDwUKMTM2MTQ1MjA0NA9kFgICAQ9kFgYCAw8WAh4JaW5uZXJodG1sBRvnlLXliqjoh6rooYzovabmlrDovabmiqXniYxkAgUPEGQQFRAJ6K+36YCJ5oupCjIwMjAtMDYtMTQKMjAyMC0wNi0xNQoyMDIwLTA2LTE2CjIwMjAtMDYtMTcKMjAyMC0wNi0xOAoyMDIwLTA2LTE5CjIwMjAtMDYtMjAKMjAyMC0wNi0yMQoyMDIwLTA2LTIyCjIwMjAtMDYtMjMKMjAyMC0wNi0yNAoyMDIwLTA2LTI2CjIwMjAtMDYtMjcKMjAyMC0wNi0yOAoyMDIwLTA2LTI5FRAJ6K+36YCJ5oupCjIwMjAtMDYtMTQKMjAyMC0wNi0xNQoyMDIwLTA2LTE2CjIwMjAtMDYtMTcKMjAyMC0wNi0xOAoyMDIwLTA2LTE5CjIwMjAtMDYtMjAKMjAyMC0wNi0yMQoyMDIwLTA2LTIyCjIwMjAtMDYtMjMKMjAyMC0wNi0yNAoyMDIwLTA2LTI2CjIwMjAtMDYtMjcKMjAyMC0wNi0yOAoyMDIwLTA2LTI5FCsDEGdnZ2dnZ2dnZ2dnZ2dnZ2cWAWZkAgcPEGQQFQEJ6K+36YCJ5oupFQEJ6K+36YCJ5oupFCsDAWcWAWZkZJ+ZxUulzLMyz55c5+GRzt34hm3y\" />\n" +
                "\n" +
                "<input type=\"hidden\" name=\"__EVENTVALIDATION\" id=\"__EVENTVALIDATION\" value=\"/wEWGwLAmMr8BwKUifDpDgLR69qYBwLR696YBwLR69KYBwLR69aYBwLR66qYBwLR666YBwLQ68qYBwLQ686YBwLQ68KYBwLQ68aYBwLQ69qYBwLQ69KYBwLQ69aYBwLQ66qYBwLQ666YBwKUicj5BwKyrss8ArOuyzwClf/L7QoC+7j0HQK7+8OuCQLdxK2uBQKX1KCrDwLPktFkAqC3sP0KNW/BaD45lrNMqTjZLkHAPP4ySOM=\" />\n" +
                "        <div id=\"ui-header\">\n" +
                "            <div class=\"fixed\"><a class=\"ui-title\" id=\"popmenu\"><font style=\"font-size: 18px;\">预约服务</font></a><a class=\"ui-btn-left_pre\" href=\"javascript:\" onclick=\"window.history.go(-1)\"></a><a class=\"ui-btn-right_home\" href=\"Home_WeChat.aspx\"></a></div>\n" +
                "        </div>\n" +
                "        <div id=\"overlay\"></div>\n" +
                "        <div id=\"win\">\n" +
                "    <ul class=\"dropdown\">\n" +
                "        <li><a href=\"BsznType_WeChat.aspx\"><span>办事指南</span></a></li>\n" +
                "        <li><a href=\"Bjcx_WeChat.aspx\"><span>办件查询</span></a></li>\n" +
                "        <li><a href=\"Wwyy_WeChat.aspx\"><span>预约服务</span></a></li>\n" +
                "        <li><a href=\"Wwyz_WeChat.aspx\"><span>预置服务</span></a></li>\n" +
                "        <li><a href=\"Weather_WeChat.aspx\"><span>天气查询</span></a></li>\n" +
                "        <li><a href=\"Map_WeChat.aspx\"><span>中心地图</span></a></li>\n" +
                "        <li><a href=\"CKTel_WeChat.aspx\"><span>咨询电话</span></a></li>\n" +
                "        <li><a href=\"Floor_WeChat.aspx\"><span>楼层分布</span></a></li>\n" +
                "        <li><a href=\"WwpdXXYM_WeChat.aspx\"><span>排队查询</span></a></li>\n" +
                "        <li><a href=\"Zxjj_WeChat.aspx\"><span>中心简介</span></a></li>\n" +
                "        <div class=\"clr\"></div>\n" +
                "    </ul>\n" +
                "</div>\n" +
                "\n" +
                "        <div class=\"Listpage\">\n" +
                "            <div class=\"top46\"></div>\n" +
                "            <div class=\"page-bizinfo\">\n" +
                "                <div class=\"text\">\n" +
                "                    <span></span>\n" +
                "                    <div style=\"line-height: 160%; font-size: 16px;\">\n" +
                "                        <div style=\"margin: 0 auto; text-align: center; min-height: 100px;\">\n" +
                "                            <table class=\"detail\">\n" +
                "                                <tr>\n" +
                "                                    <td class=\"title\">预约事项：</td>\n" +
                "                                    <td class=\"content\"><span id=\"yysx\">电动自行车新车报牌</span></td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"title\">预约日期：</td>\n" +
                "                                    <td class=\"content\">\n" +
                "                                        <select name=\"yysj\" id=\"yysj\">\n" +
                "\t<option selected=\"selected\" value=\"请选择\">请选择</option>\n" +
                "\t<option value=\"2020-06-14\">2020-06-14</option>\n" +
                "\t<option value=\"2020-06-15\">2020-06-15</option>\n" +
                "\t<option value=\"2020-06-16\">2020-06-16</option>\n" +
                "\t<option value=\"2020-06-17\">2020-06-17</option>\n" +
                "\t<option value=\"2020-06-18\">2020-06-18</option>\n" +
                "\t<option value=\"2020-06-19\">2020-06-19</option>\n" +
                "\t<option value=\"2020-06-20\">2020-06-20</option>\n" +
                "\t<option value=\"2020-06-21\">2020-06-21</option>\n" +
                "\t<option value=\"2020-06-22\">2020-06-22</option>\n" +
                "\t<option value=\"2020-06-23\">2020-06-23</option>\n" +
                "\t<option value=\"2020-06-24\">2020-06-24</option>\n" +
                "\t<option value=\"2020-06-26\">2020-06-26</option>\n" +
                "\t<option value=\"2020-06-27\">2020-06-27</option>\n" +
                "\t<option value=\"2020-06-28\">2020-06-28</option>\n" +
                "\t<option value=\"2020-06-29\">2020-06-29</option>\n" +
                "\n" +
                "</select><font color=\"red\">*</font>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"title\">预约时段：</td>\n" +
                "                                    <td class=\"content\">\n" +
                "                                        <select name=\"yysd\" id=\"yysd\">\n" +
                "\t<option selected=\"selected\" value=\"请选择\">请选择</option>\n" +
                "\n" +
                "</select><font color=\"red\">*</font>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"title\">可预约数：</td>\n" +
                "                                    <td class=\"content\">\n" +
                "                                        <span id=\"lblRemainingQuantity\"></span>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr id=\"type\">\n" +
                "\t<td class=\"title\">服务对象：</td>\n" +
                "\t<td class=\"content\">\n" +
                "                                        <select name=\"ddlObjectType\" id=\"ddlObjectType\">\n" +
                "\t\t<option selected=\"selected\" value=\"1\">个人办事</option>\n" +
                "\t\t<option value=\"2\">法人办事</option>\n" +
                "\n" +
                "\t</select>\n" +
                "                                    </td>\n" +
                "</tr>\n" +
                "\n" +
                "                                <tr id=\"qy\" style=\"display: none;\">\n" +
                "\t<td class=\"title\">企业名称：</td>\n" +
                "\t<td class=\"content\">\n" +
                "                                        <input name=\"entname\" type=\"text\" id=\"entname\" /><font color=\"red\">*</font>\n" +
                "                                    </td>\n" +
                "</tr>\n" +
                "\n" +
                "                                <tr id=\"qybz\" style=\"display: none;\">\n" +
                "\t<td class=\"title\"></td>\n" +
                "\t<td class=\"content\">\n" +
                "                                        <span style=\"color: red;\">备注：新设立企业或个体户请填写拟申请的企业名称或商户名称</span></td>\n" +
                "</tr>\n" +
                "\n" +
                "\n" +
                "                                <tr id=\"xm\">\n" +
                "\t<td class=\"title\">姓名：</td>\n" +
                "\t<td class=\"content\">\n" +
                "                                        <input name=\"name\" type=\"text\" id=\"name\" /><font color=\"red\">*</font></td>\n" +
                "</tr>\n" +
                "\n" +
                "                                <tr id=\"sfzh\">\n" +
                "\t<td class=\"title\">身份证号：</td>\n" +
                "\t<td class=\"content\">\n" +
                "                                        <input name=\"idNo\" type=\"text\" id=\"idNo\" /><font color=\"red\">*</font></td>\n" +
                "</tr>\n" +
                "\n" +
                "                                <tr id=\"sjh\">\n" +
                "\t<td class=\"title\">手&nbsp;机&nbsp;号：</td>\n" +
                "\t<td class=\"content\">\n" +
                "                                        <input name=\"telNo\" type=\"text\" id=\"telNo\" /><font color=\"red\">*</font></td>\n" +
                "</tr>\n" +
                "\n" +
                "                                \n" +
                "                            </table>\n" +
                "                            <input name=\"deptName\" type=\"hidden\" id=\"deptName\" value=\"公安交管\" />\n" +
                "                            <input type=\"submit\" name=\"btnYY\" value=\"预 约\" onclick=\"if(!checkNo()){return false;};\" language=\"javascript\" id=\"btnYY\" class=\"button2\" />&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"submit\" name=\"btnReset\" value=\"重 置\" onclick=\"if(!reset1()){return false;};\" language=\"javascript\" id=\"btnReset\" class=\"button2\" />\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"plug-div\">\n" +
                "<!--  <div class=\"plug-phone\" tabindex=\"0\" style=\"outline: none\">\n" +
                "    <div class=\"plug-menu themeStyle\"><span class=\"close\"></span></div>\n" +
                "    <div class=\"themeStyle plug-btn plug-btn1 close\"><a href=\"Home_WeChat.aspx\" title=\"微官网首页\"><span style=\"background-image: url(pwximg/plugmenu6.png);\"></span></a></div>\n" +
                "    <div class=\"themeStyle plug-btn plug-btn2 close\"><a href=\"Zxjj_WeChat.aspx\" title=\"中心简介\"><span style=\"background-image: url(pwximg/plugmenu2.png);\"></span></a></div>\n" +
                "    <div class=\"themeStyle plug-btn plug-btn3 close\"><a href=\"Map_WeChat.aspx\" title=\"中心地图\"><span style=\"background-image: url(pwximg/plugmenu7.png);\"></span></a></div>\n" +
                "    <div class=\"themeStyle plug-btn plug-btn4 close\"><a href=\"CKTel_WeChat.aspx\" title=\"咨询电话\"><span style=\"background-image: url(pwximg/plugmenu1.png);\"></span></a></div>\n" +
                "    <div class=\"plug-btn plug-btn5 close\"></div>\n" +
                "  </div>-->\n" +
                "  <div class=\"plug-phone\" style=\"float:right\">\n" +
                "    <div class=\"plug-top themeStyle\" style=\"display:none;\"><span ></span></div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "<style>\n" +
                "    .bottom {\n" +
                "        line-height:21px;\n" +
                "    }\n" +
                "</style>\n" +
                "\n" +
                "<div class=\"bottom\">\n" +
                "    <div class=\"fixed1\">\n" +
                "        <div><font color=\"#FFFFFF\" style=\"font-weight:bold;\">业务咨询电话：0591-83451234</font></div>\n" +
                "        <div><font color=\"#FFFFFF\" style=\"font-weight:bold;\">技术咨询电话：0591-87276026</font></div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</form>\n" +
                "\n" +
                "    <script>\n" +
                "        $(\"#ddlObjectType\").change(function () {\n" +
                "            switch ($(\"#ddlObjectType\").val()) {\n" +
                "                case \"1\":\n" +
                "                    $(\"#qy\").hide();\n" +
                "                    $(\"#qybz\").hide();\n" +
                "                    break;\n" +
                "                case \"2\":\n" +
                "                    $(\"#qy\").show();\n" +
                "                    $(\"#qybz\").show();\n" +
                "                    break;\n" +
                "            }\n" +
                "        });\n" +
                "        $().ready(function () {\n" +
                "            switch (getQueryVariable('TargetType')) {\n" +
                "                case '1':\n" +
                "                    $(\"#ddlObjectType option[value='1']\").prop(\"selected\", true);\n" +
                "                    $(\"#ddlObjectType\").change();\n" +
                "                    break;   //自然人\n" +
                "                case '2':\n" +
                "                    $(\"#ddlObjectType option[value='2']\").prop(\"selected\", true);\n" +
                "                    $(\"#ddlObjectType\").change();\n" +
                "                    break;   //法人\n" +
                "            }\n" +
                "\n" +
                "\n" +
                "            if (typeof String.prototype.startsWith !== 'function') {\n" +
                "                String.prototype.startsWith = function (prefix) {\n" +
                "                    return this.slice(0, prefix.length) === prefix;\n" +
                "                };\n" +
                "            }\n" +
                "\n" +
                "            if (typeof String.prototype.endsWith !== 'function') {\n" +
                "                String.prototype.endsWith = function (suffix) {\n" +
                "                    return this.indexOf(suffix, this.length - suffix.length) !== -1;\n" +
                "                };\n" +
                "            }\n" +
                "\n" +
                "        });\n" +
                "        function getQueryVariable(variable) {\n" +
                "            var query = window.location.search.substring(1);\n" +
                "            var vars = query.split(\"&\");\n" +
                "            for (var i = 0; i < vars.length; i++) {\n" +
                "                var pair = vars[i].split(\"=\");\n" +
                "                if (pair[0] == variable) { return pair[1]; }\n" +
                "            }\n" +
                "            return (false);\n" +
                "        }\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>\n" +
                "\n";
        Matcher matcher = pattern.matcher(test);
        matcher.find();
        System.out.println(matcher.start());//返回3
        System.out.println(matcher.end());//返回7
        System.out.println(matcher.group());//返回Java
        String r = matcher.group();
        //System.out.println(r.substring(24,r.length()-1));//返回Java
        System.out.println(r.substring(30,r.length()-1));//返回Java
    }
}
