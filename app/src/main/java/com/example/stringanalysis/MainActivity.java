package com.example.stringanalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.stringanalysis.dfasensitive.SensitiveWordsUtils;
import com.example.stringanalysis.produce.AbstractStorage;
import com.example.stringanalysis.produce.Consumer;
import com.example.stringanalysis.produce.Producer;
import com.example.stringanalysis.produce.Storage1;
import com.example.stringanalysis.sensitivewdfilter.WordFilter;
import com.example.stringanalysis.similarity.util.CosineSimilarity;
import com.example.stringanalysis.stringsimilarity.Cosine;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Set<String> s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSet();
        // dfa敏感词过滤
        SensitiveWordsUtils.init(s);
        WordFilter.init(this);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                CosineSimilarity.getSimilarity("a", "b");
//            }
//        }).start();
    }

    private void initSet() {
        s = new HashSet<>();
        s.add("您好");
        s.add("小王");
        s.add("微信");
        System.out.println(s.toString());
    }

    /**
     * DFA测试
     * @param v
     */
    public void onTest1(View v) {
        boolean isContains = SensitiveWordsUtils.contains("微信号");
        boolean isContains1 = SensitiveWordsUtils.contains("微好信号");
        boolean isContains2 = SensitiveWordsUtils.contains("微 信 号");
        boolean isContains3 = SensitiveWordsUtils.contains("11微信号");
        boolean isContains4 = SensitiveWordsUtils.contains("号信微");
        System.out.println("=============================> isContains: " + isContains);
        System.out.println("=============================> isContains1: " + isContains1);
        System.out.println("=============================> isContains2: " + isContains2);
        System.out.println("=============================> isContains3: " + isContains3);
        System.out.println("=============================> isContains4: " + isContains4);
    }

    /**
     * DFA测试
     * https://github.com/andyzty/sensitivewd-filter
     */
    public void onTest2(View v) {
        String s = "你是逗比吗？ｆｕｃｋ！fUcK,你竟然用法轮功，法@!轮!%%%功";
        System.out.println("解析问题： " + s);
        System.out.println("解析字数 : " + s.length());
        String re;
        long nano = System.nanoTime();
        re = WordFilter.doFilter(s);
        nano = (System.nanoTime() - nano);
        System.out.println("解析时间 : " + nano + "ns");
        System.out.println("解析时间 : " + nano / 1000000 + "ms");
        System.out.println(re);
        System.out.println();

        nano = System.nanoTime();
        System.out.println("是否包含敏感词： " + WordFilter.isContains(s));
        nano = (System.nanoTime() - nano);
        System.out.println("解析时间 : " + nano + "ns");
        System.out.println("解析时间 : " + nano / 1000000 + "ms");

        boolean isContains = WordFilter.isContains("微信号");
        boolean isContains1 = WordFilter.isContains("微好信号");
        boolean isContains2 = WordFilter.isContains("微 信 号");
        boolean isContains3 = WordFilter.isContains("11微信号");
        boolean isContains4 = WordFilter.isContains("号信微");
        System.out.println("=============================> isContains: " + isContains);
        System.out.println("=============================> isContains1: " + isContains1);
        System.out.println("=============================> isContains2: " + isContains2);
        System.out.println("=============================> isContains3: " + isContains3);
        System.out.println("=============================> isContains4: " + isContains4);
    }

    /**
     * 判断2个字符串是否相等
     */
    public void onTest3(View v) {
        String str11 = "hello";
        String str12 = "hello1";
        boolean isEquals1 = StringUtils.isEquals(str11, str12);
        String str21 = "hello1";
        String str22 = "hello1";
        boolean isEquals2 = StringUtils.isEquals(str21, str22);
        System.out.println("=============================> isEquals1: " + isEquals1);
        System.out.println("=============================> isEquals2: " + isEquals2);
    }

    /**
     * 转换大小写
     */
    public void onTest4(View v) {
        String str = "Hello World";
        System.out.println("=============================> 转换成小写 : " + StringUtils.toLowerCase(str));
        System.out.println("=============================> 转换成大写 : " + StringUtils.toUpperCase(str));
    }

    /**
     * 字符串相似度
     */
    public void onTest5(View v) {
        String content1 = "今天小小和爸爸一起去摘草莓，小小说今天的草莓特别的酸，而且特别的小，关键价格还贵," +
                "今天小小和爸爸一起去摘草莓，小小说今天的草莓特别的酸，而且特别的小，关键价格还贵" +
                "今天小小和爸爸一起去摘草莓，小小说今天的草莓特别的酸，而且特别的小，关键价格还贵";

        String content2 = "今天小小和妈妈一起去草原里采草莓，今天的草莓味道特别好，而且价格还挺实惠的," +
                "今天小小和妈妈一起去草原里采草莓，今天的草莓味道特别好，而且价格还挺实惠的" +
                "今天小小和妈妈一起去草原里采草莓，今天的草莓味道特别好，而且价格还挺实惠的";
        long nano = System.nanoTime();
        double score = CosineSimilarity.getSimilarity(content1, content2);
        nano = (System.nanoTime() - nano) / 1000000;
        System.out.println("=============================> 解析时间 : " + nano + "ms");
        System.out.println("=============================> 相似度1：" + score);
        score = CosineSimilarity.getSimilarity(content1, content1);
        System.out.println("=============================> 相似度2：" + score);
    }

    /**
     * 去掉空格
     */
    public void onTest6(View v) {
        String message = "今天 小小  和妈妈一起    去草原里    采草莓";
        message = StringUtils.removeSpace(message);
        System.out.println("=============================> message：" + message);
    }

    /**
     * 字符串比对，使用分词库
     */
    public void onTest7(View v) {
        String message1 = "采草莓  今天   和妈妈一起  小小  去草原里    采草莓";
        String message2 = "今天 小小  和妈妈一起    去草原里    采草莓";
        String message3 = "今天 小小  和妈妈一起    去草原里    采草莓";
//        String message1 = "1212123，*****，*****，www.hsdhshdhsd.com";
//        String message2 = "1212123，*****，*****，www.hsdhshdhsd.com";
        long nano = System.nanoTime();
        double score = StringUtils.getSimilarity(message1, message2);
        System.out.println("=============================> score：" + score);
        nano = (System.nanoTime() - nano) / 1000000;
        System.out.println("=============================> 解析时间 : " + nano + "ms");
    }

    /**
     * 替换中文数字
     */
    public void onTest8(View v) {

        String message1 = "今天 小小  和妈妈一起    去草原里    采草莓";
        String result1 = StringUtils.replaceCharacters(message1);
        System.out.println("=============================> result：" + result1);


        String message2 = "今天 小小一一三和妈妈一起    去草原里    采草莓";
        String result2 = StringUtils.replaceCharacters(message2);
        System.out.println("=============================> result：" + result2);
        long nano = System.nanoTime();
        String message3 = "今天 小小  和妈妈一起一 五去草原里  六  采草莓 今天 小小  和妈妈一起一 五去草原里  六  采草莓 今天 小小  和妈妈一起一 五去草原里  六  采草莓";
        String result3 = StringUtils.replaceCharacters(message3);
        System.out.println("=============================> result：" + result3);
        nano = (System.nanoTime() - nano) / 1000000;
        System.out.println("=============================> 解析时间 : " + nano + "ms");
    }

    /**
     * 字符串相似度，使用普通类（余弦）
     */
    public void onTest9(View v) {
        String message1 = "123";
        String message2 = "123";
        String message3 = "今天 小小  和妈妈一起    去草原里    采草莓";
        long nano = System.nanoTime();
        // 余弦算法
        System.out.println("similarity");
        Cosine instance = new Cosine();
        double result = instance.similarity(message1, message2);
        System.out.println("=============================> 字符串相似度，使用普通类（余弦）");
        System.out.println("=============================> result：" + result);
        nano = (System.nanoTime() - nano) / 1000000;
        System.out.println("=============================> 解析时间 : " + nano + "ms");

    }

    /**
     * 浮点型比较大小
     */
    public void onTest10(View v) {
//        double a = 0.00001;
//        double b = 0.00001;
//        BigDecimal data1 = new BigDecimal(a);
//        BigDecimal data2 = new BigDecimal(b);

        System.out.println("=============================> 0.01比0.001大？ : " + compare(8.96352255 / 13.0, 0.8));

    }

    private boolean compare(double a, double b) {
        BigDecimal data1 = new BigDecimal(a);
        BigDecimal data2 = new BigDecimal(b);
        return data1.compareTo(data2) >= 0 ;
    }

    // 仓库对象
    AbstractStorage abstractStorage = new Storage1();

    public void onTest11(View v) {
        // 消费者对象
        Consumer c1 = new Consumer(abstractStorage);
        // 线程开始执行
        c1.start();
    }

    public void onTest12(View v) {
        // 生产者对象
        Producer p1 = new Producer(abstractStorage);
        p1.start();
    }

    /**
     * 筛选出所有的字母和数字
     */
    public void onTest13(View v) {
//        String str = "123abc你好efc";
        String str = "今天小小和爸爸一起去摘草莓，2小小说今天的草莓特别的酸，2而且特别的小，关键价格还贵," +
                "今天小小和爸爸cccc一起去摘草莓，小小说aaaa今天的草   莓特别的酸，而且特bbbb别的小，3关键价格还贵" +
                "今天小小和爸爸一起去摘草莓，小小说今天的草莓特别的酸，4而且特别的小，5关键价格还贵"+
                "今天小小和爸爸一起去摘草莓，2小小说今天的草莓特别的酸，2而且特别的小，关键价格还贵," +
                "今天小小和爸爸cccc一起去摘草莓，小小说aaaa今天的草   莓特别的酸，而且特bbbb别的小，3关键价格还贵" +
                "今天小小和爸爸一起去摘草莓，小小说今天的草莓特别的酸，4而且特别的小，5关键价格还贵"
                +"今天小小和爸爸一起去摘草莓，2小小说今天的草莓特别的酸，2而且特别的小，关键价格还贵," +
                "今天小小和爸爸cccc一起去摘草莓，小小说aaaa今天的草   莓特别的酸，而且特bbbb别的小，3关键价格还贵" +
                "今天小小和爸爸一起去摘草莓，小小说今天的草莓特别的酸，4而且特别的小，5关键价格还贵 www.baidu.com";
        String reg = "[\u4e00-\u9fa5]"; // 仅仅去掉中文
//        String reg = "[^a-z^A-Z^0-9\\u4e00-\\u9fa5]";
        Pattern pat = Pattern.compile(reg);

        Matcher mat = pat.matcher(str);
        String repickStr = mat.replaceAll("");

        System.out.println("=============================> 去中文后:" + repickStr);
//        long nano = System.nanoTime();
//        String str1 = str.replaceAll("[^a-z^A-Z^0-9]", ""); // 筛选出所有的字母和数字
//        nano = (System.nanoTime() - nano) / 1000000;
//        System.out.println("=============================> 解析时间 : " + nano + "ms");
//        System.out.println("=============================> 去中文后1:" + str1);
    }

    /**
     * 综合使用
     */
    public void onTest14(View v) {
        String str = "今天小小和爸爸一起去摘草莓，1小小说今天的草莓特别的酸，2而且特别的小，关键价格还贵," +
                "今天小小和爸爸cccc一起去摘草莓，小小说HHHH今天的草   莓特别的酸，而且特bbbb别的小，3关键AbC价格还贵" +
                "今天小小和爸爸一起去摘草莓，小小说今天的草莓特别的酸，4而且特别的小，5关键价格还贵";
        long nano = System.nanoTime();
        String str1 = change(str);
        nano = (System.nanoTime() - nano) / 1000000;
        System.out.println("=============================> 解析时间 : " + nano + "ms");
        System.out.println("=============================> 去中文后1:" + str1);
    }

    private String change(String str) {
        str = StringUtils.replaceCharacters(str); // 替换中文数字为阿拉伯数字
        str = str.replaceAll("[^a-z^A-Z^0-9]", ""); // 去中文后
        str = StringUtils.toLowerCase(str); // 转换成小写
        return str;
    }

    /**
     * 去掉标点
     */
    public void onTest15(View v) {
        long nano = System.nanoTime();
        String str = "!!！！去#$%^&*()~!符号标号！！当@然。!!..**半0㊀㊁㊂㈠㈡①②③⑴⑵⑶角15 963256322 www.baidu.com";
//        String str1 = str.replaceAll("\\p{Punct}", "");
//        String str2 = str.replaceAll("\\p{P}", "");
//        nano = (System.nanoTime() - nano) / 1000000;
//        System.out.println("=============================> 解析时间 : " + nano + "ms");
        System.out.println("=============================> str:" + str);
//        System.out.println("=============================> str1:" + str1);
//        System.out.println("=============================> str2:" + str2);

        String cstr= change1(str);
        System.out.println("=============================> cstr：" + cstr);

//        Cosine instance = new Cosine();
//        double result = instance.similarity(str, str1);
//        System.out.println("=============================> result：" + result);
    }

    private String change1(String str) {
        String reg = "[\u4e00-\u9fa5]"; // 仅仅去掉中文
        Pattern pat = Pattern.compile(reg);
        Matcher mat = pat.matcher(str);
        str = mat.replaceAll("");
        str = str.replaceAll("\\p{P}", "");
//        str = StringUtils.removeSpace(str);
        return str;
    }

    /**
     * 字符串变换测试
     */
    public void onTest16(View v) {
        String str = "字HELLO nihao符一三七 一 六 九 二 五 三五零串 测试 www.baidu.com ㊀ ㊁ ㊂㈠㈡①②③⑴⑵⑶";
        System.out.println("=============================> str1：" + str);
        String str2 = changeStrV2(str);
        System.out.println("=============================> str2：" + str2);
        Cosine instance = new Cosine();
        double result = instance.similarity(str2, str2);
        System.out.println("=============================> result：" + result);

    }

    private String changeStrV2(String str) {
        if(TextUtils.isEmpty(str))
            return null;
        str = StringUtils.changeStrV2(str); // 替换中文数字为阿拉伯数字
        return str;
    }

}