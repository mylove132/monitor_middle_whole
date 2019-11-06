package okjiaoyu.qa.middle.auto.main;

import okjiaoyu.qa.tools.RunningParameter;
import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 晓 on 2015/7/13.
 */
public class MainJUnit {
    private Logger logger = Logger.getLogger(this.getClass());

    private static Logger logger1 = Logger.getLogger("");

    public static void main(String[] args) {
        String xmlPath = "";
        System.out.println("第一个参数：" + args[0]);
        System.out.println("第二个参数：" + args[1]);
        switch (args[0]) {
            case "pad": {
                if (args[1].equals("normal")) {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/studentpad_normal.xml";
                } else {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/studentpad_exception.xml";
                }
                break;
            }
            case "teacher": {
                if (args[1].equals("normal")) {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/teacherspace_normal.xml";
                } else {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/teacherspace_excepiton.xml";
                }
                break;
            }
            case "parentapp": {
                if (args[1].equals("normal")) {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/parentapp_normal.xml";
                } else {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/parentapp_exception.xml";
                }
                break;
            }
            case "ticket": {
                if (args[1].equals("normal")) {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/ticketverify_normal.xml";
                } else {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/ticketverify_exception.xml";
                }
                break;
            }
            case "stupad": {
                if (args[1].equals("normal")) {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/stupad_normal.xml";
                } else {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/stupad_exception.xml";
                }
                break;
            }
            case "mall": {
                if (args[1].equals("normal")) {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/mall_normal.xml";
                } else {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/mall_exception.xml";
                }
                break;
            }
            case "teacherpad": {
                if (args[1].equals("normal")) {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/teacherpad_normal.xml";

                } else {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/teacherspace_excepiton.xml";
                }
                break;
            }
            case "privateweb": {
                if (args[1].equals("normal")) {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/privateweb_normal.xml";
                } else {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/privateweb_exception.xml";
                }
                break;
            }
            case "publicweb": {
                if (args[1].equals("normal")) {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/publicweb_normal.xml";
                } else {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/publicweb_exception.xml";
                }
                break;
            }

            case "crm": {
                if (args[1].equals("normal")) {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/crm_normal.xml";
                } else {
                    xmlPath = "/xdfapp/autotest/monitor_middlers_online/target/classes/config/controller/crm_exception.xml";
                }
                break;
            }
        }
        System.out.println("XmlPath:" + xmlPath);
        //run test
        new MainJUnit().runMonitor(xmlPath);
        //跑jenkins...0418
        logger1.info("----调试用的--" + args.toString());
        buildParams(args);
//        String[] args1 = {args[0]};
//        TestNG.privateMain(args1, null);
    }

    public void runMonitor(String xmlPath) {
        logger.info(" --------------- monitor start ---------------");
        logger.info("xmlPath:" + xmlPath);
        String[] args = new String[1];
        args[0] = xmlPath;
        try {
            TestNG.privateMain(args, ( ITestListener ) null);
        } catch (Throwable e) {
            e.printStackTrace();
            logger.info("error in test running ------------------");
        }
        logger.info(" --------------- monitor complete ---------------");
    }

    public void test() {
        logger.info("Test start ---------------");
        String[] args = new String[1];
        args[0] = MainJUnit.class.getResource("/config/controller/studentpad_whole.xml").getPath();
        try {
            TestNG.privateMain(args, ( ITestListener ) null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("error in test running ------------------");
        }
    }

    public void autorun(Map<String, String> map) {
        logger.info("Test start ---------------");
        String[] args = new String[1];
        //get test target xml
        String xmlPath;
        switch (map.get("testTarget")) {
            case "studentpad-middle":
                xmlPath = "/config/controller/studentpad_whole.xml";
                break;
            case "teacherspace-middle":
                xmlPath = "/config/controller/TeacherSpace.xml";
                break;
            case "teacherpad-middle":
                xmlPath = "teacherpad_normal.xml";
                break;
            default:
                xmlPath = "/config/controller/studentpad_whole.xml";
        }
        RunningParameter.env = map.get(" ");
        logger.info("[env]:" + RunningParameter.env);
        RunningParameter.branch = map.get("branch");
        logger.info("[branch]:" + RunningParameter.branch);

        args[0] = MainJUnit.class.getResource(xmlPath).getPath();
        try {
            TestNG.privateMain(args, ( ITestListener ) null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("error in test running ------------------");
        }
    }

    @Test
    public void testRequest() {
        Map<String, String> map = new HashMap<>();
        map.put("testTarget", "teacherpad-middle");
        map.put("env", "online");
        map.put("branch", "online");
        autorun(map);
    }

    //跑jenkins...0418
    private static void buildParams(String[] args) {

        for (String arg : args) {

            logger1.info("----调试用的--" + arg);
            if (arg.contains("type")) {
                RunningParameter.executeType = arg.split("_")[1];
            }
            if (arg.contains("sendReport")) {
                RunningParameter.sendPassReport = Boolean.valueOf(arg.split("_")[1]);
            }
            if (arg.contains("mailContent")) {
                RunningParameter.mailContent = arg.split("_")[1];
            }
            if (arg.contains("mailReceiver")) {
                RunningParameter.mailReceiver = arg.split("_")[1].split(";");
            }
        }
    }
}
