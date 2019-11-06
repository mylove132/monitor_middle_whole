package okjiaoyu.qa.tools;


import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Thinkpad on 2014/10/11.
 * common function useed in many class
 */
public class CommonFun {

    private Logger logger = Logger.getLogger(CommonFun.class);

    public int getNumber(String str) {
        if (str.contains("-")) {
            return 0 - Integer.parseInt(str.replaceAll("[^0-9]", ""));
        } else {
            return Integer.parseInt(str.replaceAll("[^0-9]", ""));
        }
    }

    /*public static String getCurrentDate() {
        SimpleDateFormat df;//设置日期格式
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = df.format(new Date());
        return s;
    }*/

    public static String dateFormat(Date date) {
        SimpleDateFormat df;//设置日期格式
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = df.format(date);
        return s;
    }

    public static Date getCurrentDate() {
        SimpleDateFormat df;//设置日期格式
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        df.format(date);
        return date;
    }

    public static String getCurrentDate(String format) {
        SimpleDateFormat df;//设置日期格式
        df = new SimpleDateFormat(format);
        String s = df.format(new Date());
        return s;
    }

    public static void createFolder(String path) {
        File Folder = new File(path);
        if (!Folder.exists()) {
            Folder.mkdir();
        } else {
            LogPrint.errorPrint("Info-- 文件夹" + path + "已经存在了");
        }
    }

    public static void createFile(String path) {
        File logFile = new File(path);
        try {
            logFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            LogPrint.errorPrint("创建文件报错，文件地址是：" + path);
        }
    }

    public static boolean matchNumber(String str) {
        return str.matches("[-]?[0-9]+");
    }


}
