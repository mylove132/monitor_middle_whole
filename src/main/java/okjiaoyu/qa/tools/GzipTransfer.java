package okjiaoyu.qa.tools;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Created by zhangxiaozheng on 2016/4/14.
 * GzipTransfer
 */
public class GzipTransfer {

    private Logger logger = Logger.getLogger(this.getClass());

    public File generateGzipFile(String jsonString, String path, String filename) throws IOException {
        filename = replaceSymbol(filename);
//        logger.info("--------- generateGzipFile a new file ----------");
        logger.info("[jsonString]:" + jsonString);
        logger.info("[filename]:" + filename);
        ByteArrayOutputStream ar = new ByteArrayOutputStream();

        byte[] da = jsonString.getBytes();

        OutputStream zi;
        try {
            zi = new GZIPOutputStream(ar);
            zi.write(da);
            zi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(path + File.separator + filename + ".binary");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(ar.toByteArray());
        fos.close();
        logger.info("--------- generateGzipFile complete ----------");
        return file;
    }

    public String replaceSymbol(String str) {
        String result = str.trim();
        if (str.contains("\\")) {
            result = str.replace("\\", "_");
        }
        return result;
    }

    public void generateGzipFile(String jsonString, String filename) {
        ByteArrayOutputStream ar = new ByteArrayOutputStream();
        try {
            byte[] da = jsonString.getBytes();

            OutputStream zi;
            try {
                zi = new GZIPOutputStream(ar);
                zi.write(da);
                zi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            File file = new File("F:\\gzip" + File.separator + filename + ".txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(ar.toByteArray());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void generateFiles() {
//

        String login = "{\"uname\":\"8130041\",\"pwd\":\"hF9DHQydsSHjZM57lsa4hLiKG/0M3pEhEPi3Gf6VTdLNYIBOtAL3ket4onijwT7OkjJb0RdDvLkB7jpW3rETFjMRi6Awd9zhXKR4tqrv7+/clEZywk2x1nm9oSJpmMOBC8xHS9+jv4sN1Fca7pE20/Ncwj+FtbROUNjkc/UAxcs=\"}";
        String listupdate = "{\"vs\":\"1.0\",\"vc\":\"1\",\"ua\":\"pad\",\"os\":\"android\",\"sw\":\"1280\"," + "\"sh\":\"752\",\"contype\":1,\"imei\":\"355267060681661\",\"mac\":\"9c:28:40:19:fd:9a\"," + "\"channel\":\"pad_unicom\",\"udid\":\"F3D72DABAC654388EAA126F50C94AA55\",\"sid\":\"94\",\n" + "\"orgtype\":\"2\",\"apps\":[{\"vcode\":\"123\",\"app\":\"com.okay.da131\"}]}";


        String getuserinfo = "{\"uid\":\"85621\",\"token\":\"8119c9288a675e4f71acf9a27b3378de5f\"}";
        String autologin = "{\"uid\":\"85621\",\"token\":\"8119c9288a675e4f71acf9a27b3378de5f\"}";
        String whitelist = "{\"sid\":\"80\"}";
        String checkupdate = "{\"vcode\":35,\"pkgname\":\"123\",\"token\":\"{{token}}\"}";

        String skres = "{\"uid\":\"85621\",\"pagesize\":10,\"token\":\"8119c9288a675e4f71acf9a27b3378de5f\",\"currentpage\":1,\"subjectid\":\"3\"}";
        String skgetcont = "{\"uid\":\"85621\",\"token\":\"8119c9288a675e4f71acf9a27b3378de5f\",\"resourceid\":\"1007692\",\"courseid\":\"1024945\",\"classid\":\"12155\"}";
        String hwquestions = "{\"uid\":\"8106369\",\"workid\":\"1209\",\"token\":\"816adbdd196a774ccc91985f13fd9769bd\"}";
        String hwhistorydetail = "{\"uid\":\"8106369\",\"workid\":\"1209\",\"token\":\"816adbdd196a774ccc91985f13fd9769bd\"}";
        String evalhistorydetail = "{\"uid\":\"8106369\",\"id\":\"1629\",\"token\":\"816adbdd196a774ccc91985f13fd9769bd\"}";
        String evalsubjects = "{\"uid\":\"87127\",\"token\":\"810b1eeea2c38d4d2dbe29e72096289c90\"}";
        String revckquests_chapter = "{uid\":\"8106369\",\"token\":\"8119c9288a675e4f71acf9a27b3378de5f\",\"flag\": 1,\"id\":\"14086\",\"level\":2,\"name\":\"zxz2016.01.14-章节-01\"}";
        String revckquests_knowledge = "{uid\":\"8106369\",\"token\":\"8119c9288a675e4f71acf9a27b3378de5f\",\"flag\": 2,\"id\":\"244\",\"level\":1,\"name\":\"zxz2016.01.20-知识点-03\"}";
        String revwroquests;
        String revhistories = "{\"uid\":\"8106369\",\"id\":\"1239163\",\"token\":\"816adbdd196a774ccc91985f13fd9769bd\"}";
        String itfywroquests;
        String kpresources = "{\"uid\":\"8106369\",\"token\":\"8119c9288a675e4f71acf9a27b3378de5f\",\"kpoint\":\"242\",\"currentpage\":1,\"pagesize\":10}";
        String wbquests;


        generateGzipFile(login, "login");
        generateGzipFile(listupdate, "listupdate");
        generateGzipFile(getuserinfo, "getuserinfo");
        generateGzipFile(autologin, "autologin");
        generateGzipFile(whitelist, "whitelist");
        generateGzipFile(checkupdate, "checkupdate");
        generateGzipFile(skres, "skres");
        generateGzipFile(skgetcont, "skgetcont");
        generateGzipFile(hwquestions, "hwquestions");
        generateGzipFile(hwhistorydetail, "hwhistorydetail");
        generateGzipFile(evalhistorydetail, "evalhistorydetail");
        generateGzipFile(evalsubjects, "evalsubjects");
        generateGzipFile(revckquests_chapter, "revckquests_chapter");
        generateGzipFile(revckquests_knowledge, "revckquests_knowledge");
        generateGzipFile(revhistories, "revhistories");
        generateGzipFile(kpresources, "kpresources");
    }

}
