package com.leon.common.utils;


import cn.hutool.core.util.StrUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  字符串操作工具类，扩展自 hutool.cn
 * @author minglei.chen
 * Date: 2018-06-15
 * Time: 14:42
 */
public class StringUtil extends StrUtil {

    /**
     *  格式化字符串（替换符为%s）
     */
    public static String formatIfArgs(String format, Object... args) {
        if (StrUtil.isEmpty(format)) {
            return format;
        }

        return (args == null || args.length == 0)  ? String.format(format.replaceAll("%([^n])", "%%$1")) : String.format(format, args);
    }

    /**
     *  格式化字符串(替换符自己指定)
     */
    public static String formatIfArgs(String format, String replaceOperator, Object... args) {
        if (isEmpty(format) || isEmpty(replaceOperator)) {
            return format;
        }

        format = replace(format, replaceOperator, "%s");
        return formatIfArgs(format, args);
    }

    /**
     * 替换字符串
     */
    public static String replace(String inString, String oldPattern, String newPattern) {
        if (isNotEmpty(inString) && isNotEmpty(oldPattern) && newPattern != null) {
            int index = inString.indexOf(oldPattern);
            if (index == -1) {
                return inString;
            } else {
                int capacity = inString.length();
                if (newPattern.length() > oldPattern.length()) {
                    capacity += 16;
                }

                StringBuilder sb = new StringBuilder(capacity);
                int pos = 0;

                for(int patLen = oldPattern.length(); index >= 0; index = inString.indexOf(oldPattern, pos)) {
                    sb.append(inString.substring(pos, index));
                    sb.append(newPattern);
                    pos = index + patLen;
                }

                sb.append(inString.substring(pos));
                return sb.toString();
            }
        } else {
            return inString;
        }
    }

    /**
     * 格式化 2020-07-08T02:33:49.103766524Z
     * @param oldDate
     * @return
     */
    public static String dealDateFormat(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = df.parse(oldDate);
            SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date1 = df1.parse(date.toString());
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return df2.format(date1);
    }


    /***
     * * 生成固定长度随机中文
     * * @param n 中文个数
     * * @return 中文串 	 */
    public static String getRandomChineseString(int n){
        String zh_cn = "";
        String str ="";

        // Unicode中汉字所占区域\u4e00-\u9fa5,将4e00和9fa5转为10进制
        int start = Integer.parseInt("4e00", 16);
        int end = Integer.parseInt("9fa5", 16);

        for(int ic=0;ic<n;ic++){
            // 随机值
            int code =(new Random()).nextInt(end - start + 1) + start;
            // 转字符
            str = new String(new char[] { (char) code });
            zh_cn=zh_cn+str;
        }
        return zh_cn;
    }


    public static String getRandomIp() {

        // ip范围
        int[][] range = {
                {607649792, 608174079}, // 36.56.0.0-36.63.255.255
                {1038614528, 1039007743}, // 61.232.0.0-61.237.255.255
                {1783627776, 1784676351}, // 106.80.0.0-106.95.255.255
                {2035023872, 2035154943}, // 121.76.0.0-121.77.255.255
                {2078801920, 2079064063}, // 123.232.0.0-123.235.255.255
                {-1950089216, -1948778497}, // 139.196.0.0-139.215.255.255
                {-1425539072, -1425014785}, // 171.8.0.0-171.15.255.255
                {-1236271104, -1235419137}, // 182.80.0.0-182.92.255.255
                {-770113536, -768606209}, // 210.25.0.0-210.47.255.255
                {-569376768, -564133889}, // 222.16.0.0-222.95.255.255
        };

        Random random = new Random();
        int index = random.nextInt(10);
        String ip = num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
        return ip;
    }

    /*
     * 将十进制转换成IP地址
     */
    public static String num2ip(int ip) {
        int[] b = new int[4];
        String ipStr = "";
        b[0] = (int) ((ip >> 24) & 0xff);
        b[1] = (int) ((ip >> 16) & 0xff);
        b[2] = (int) ((ip >> 8) & 0xff);
        b[3] = (int) (ip & 0xff);
        ipStr = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);

        return ipStr;
    }

    public static void main(String[] args) {
        System.out.println(StringUtil.getRandomChineseString(4));
        System.out.println(StringUtil.getRandomIp());

    }

}
