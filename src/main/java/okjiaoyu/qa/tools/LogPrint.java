package okjiaoyu.qa.tools;

import java.io.*;

/**
 * Created by Thinkpad on 2014/10/16.
 * handle the file data
 */
public class LogPrint extends CommonFun {

    public static String getErrorFolderAddr() {
        return errorFolderAddr;
    }

    static String logFileAddr;
    static String logFolderAddr;
    public static String errorLogAddr;
    static String errorFolderAddr;
    static String logFolderHead = "E:" + File.separator + "My_Work" + File.separator + "AutoTest" + File.separator + "testlog";

    public static void createlogFolder() {
        //****创建运行时日志和错误日志的文件夹和文件****
        //日志文件夹
        String logFolderName = getCurrentDate("yyyy-MM-dd E");
        //日志文件名
        String logFileName = getCurrentDate("yyyy-MM-dd HH时mm分ss秒 E");
        //记录日志文件夹地址
        LogPrint.logFolderAddr = logFolderHead + File.separator + logFolderName;
        LogPrint.errorFolderAddr = logFolderAddr + File.separator + "error";
        //记录日志文件地址
        LogPrint.logFileAddr = logFolderAddr + File.separator + logFileName + ".txt";
        LogPrint.errorLogAddr = errorFolderAddr + File.separator + logFileName + ".txt";
        //创建日志和错误日志文件

        createFolder(logFolderAddr);
        createFolder(errorFolderAddr);
        createFile(logFileAddr);
        createFile(errorLogAddr);
    }


    public static void printToFile(String filepath, String str) {
        //打印系统运行日志
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filepath, true));
            bw.write(str);
            bw.newLine();
            bw.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                assert bw != null;
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void errorPrint(String str) {
        //打印错误日志
        BufferedWriter bw = null;
        BufferedWriter bw2 = null;
        try {
            String info = getCurrentDate() + " >>> Error：" + str;
//            MailInfo.errorContent += info + "<br>";
            System.out.println(info);
            //打印到错误日志中
            bw = new BufferedWriter(new FileWriter(LogPrint.errorLogAddr, true));
            bw.write(info);
            bw.newLine();
            bw.flush();
            //在正常日志中也打印出来
            bw2 = new BufferedWriter(new FileWriter(LogPrint.logFileAddr, true));
            bw2.write(info);
            bw2.newLine();
            bw2.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (bw2 != null) {
                    bw2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void errorLogOpen() {
        //打开错误日志txt文件
        try {
            Process p1 = Runtime.getRuntime().exec("notepad " + errorLogAddr);
            Process p2 = Runtime.getRuntime().exec("notepad " + logFileAddr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
