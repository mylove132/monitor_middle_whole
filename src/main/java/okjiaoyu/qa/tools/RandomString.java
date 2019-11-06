package okjiaoyu.qa.tools;

import java.util.Random;

/**
 * Created by leo on 17/8/5.
 */
public class RandomString {
    //length表示生成字符串的长度
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            //获取十个随机数字
            int number = random.nextInt(base.length());
            //获取base的指定number位置的字符
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
