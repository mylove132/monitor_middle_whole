package okjiaoyu.qa.tools;

import com.noriental.utils.psssword.StrMD5;
import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhang_000 on 2015/8/21.
 */
public class MD5 {

    // 全局数组
    private final static String[] strDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public MD5() {
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String getMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }


    public static String getStudentMD5EncrtyptPwd(String rawPwd) {
        String firstEncryptPwd = getMD5Code(rawPwd + "#DsjW2014@xDf.Student.cn#");
        String result = "";
        try {
            result = Base64.encodeBase64String(new StrMD5(firstEncryptPwd).getResult().toLowerCase().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getTeacherMD5EncrtyptPwd(String rawPwd) {
        String firstEncryptPwd = getMD5Code(rawPwd + "#DsjW2014@xDf.Techer.cn#");
        String result = "";
        try {
            result = Base64.encodeBase64String(new StrMD5(firstEncryptPwd).getResult().toLowerCase().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getParentMD5EncrtyptPwd(String rawPwd) {
        String firstEncryptPwd = getMD5Code(rawPwd + "#DsjW2014@xDf.paRent.cn#");
        String result = "";
        try {
            result = Base64.encodeBase64String(new StrMD5(firstEncryptPwd).getResult().toLowerCase().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getMD5EncrtyptPwdByNewMethod(String rawPwd) {
        String firstEncryptPwd = getMD5Code(rawPwd + "#DsjW2014@xDf.User.cn#");
        String result = "";
        try {
            result = Base64.encodeBase64String(new StrMD5(firstEncryptPwd).getResult().toLowerCase().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Test
    public void test() {
//        System.out.println("123456#DsjW2014@xDf.Student.cn#");
        MD5 getMD5 = new MD5();
        System.out.println(getMD5.getTeacherMD5EncrtyptPwd("123456"));
    }


}

