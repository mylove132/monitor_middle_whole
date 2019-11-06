package okjiaoyu.qa.tools;

import okjiaoyu.qa.persistance.model.RequestHistory;
import okjiaoyu.qa.persistance.model.TestHistory;
import org.apache.http.client.CookieStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_000 on 2015/10/26.
 */
public class RunningParameter {

    //------------ setting by local or request start --------------
    public static String env = "";
    public static String branch = "";
    public static String redisIp = "";
    public static int redisPort = 0;
    //------------ setting by local or request end   --------------

    public static int caseAmount;
    public static int passAmount;
    public static int failAmount;

    public static String projectName = "";
    public static String settingFilePath = "";
    public static String settingFilePathforTeacher = "";
    public static String urlHeader = "";


    public static ParseXml apiXml;

    public static String apiXmlPath = "";

    public static String uname = "empty uname";

    public static CookieStore cookieStore;

//    ----------- generated during running the code -------------------


    //    ----------- for monitor record -------------------
    public static TestHistory testHistory = new TestHistory();

    public static List<RequestHistory> monitor_requestHistories = new ArrayList<>();

    public static int monitor_projectId = 0;

    public static String project_name = "base";

    //发送邮件
    public static String executeType = "";
    public static Boolean sendPassReport = null;
    public static String mailContent = "";
    public static String[] mailReceiver = new String[]{};
    public static String mall_token = "";
}
