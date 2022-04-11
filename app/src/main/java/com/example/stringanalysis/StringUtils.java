package com.example.stringanalysis;

import android.text.TextUtils;

import com.example.stringanalysis.similarity.util.CosineSimilarity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1.中文数字转成阿拉伯
 * 2.英文大小写统一为小写
 * 3.去掉所有空格
 * 4.对比相似度
 */
public class StringUtils {

//    private static final String[] chars = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
//    private static final String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private static final String[] chars = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "零"};
    private static final String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    public static String reg = "!|.|,|#|$|%|&| |  |";

    /**
     * 判断是否相等
     */
    public static boolean isEquals(String str1, String str2) {
        if(!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
            return str1.equals(str2);
        } else {
            return false;
        }
    }

    /**
     * 转换成小写
     */
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    /**
     * 转换成大写
     */
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    /**
     * 去掉空格
     */
    public static String removeSpace(String str) {
        return str.replaceAll("\\s+", "");
    }

    /**
     *
     * @param str1
     * @param str2
     * @return
     */
    public static double getSimilarity(String str1, String str2) {
        str1 = removeSpace(str1);
        str2 = removeSpace(str2);
        return CosineSimilarity.getSimilarity(str1, str2);
    }

    /**
     * 替换中文数字
     */
    public static String replaceCharacters(String str) {
        for(int i = 0; i < chars.length; i ++) {
            str = str.replaceAll(chars[i], nums[i]);
        }
        return str;
    }

    /**
     * 1.中文转阿拉伯
     * 2.去掉中文
     * 3.去掉标点
     * 4.转换成小写
     */
    public static String changeStrV2(String str) {
        if(TextUtils.isEmpty(str))
            return null;
        str = replaceCharacters(str); // 替换中文数字为阿拉伯数字
        String reg = "[\u4e00-\u9fa5]"; // 仅仅去掉中文
        Pattern pat = Pattern.compile(reg);
        Matcher mat = pat.matcher(str);
        str = mat.replaceAll("");
        if(!TextUtils.isEmpty(str)) {
            str = str.replaceAll("\\p{P}", ""); // 去掉标点符号
            if(!TextUtils.isEmpty(str)) {
                str = toLowerCase(str); // 转换成小写
                str = removeSpace(str); //去空格
            }
        }
        return str;
    }


}
