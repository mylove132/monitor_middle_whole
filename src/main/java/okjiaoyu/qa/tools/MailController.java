package okjiaoyu.qa.tools;

import okjiaoyu.qa.mail.*;
import okjiaoyu.qa.mail.content.ReportBuilder;
import okjiaoyu.qa.mail.content.ReportBuilderFactory;
import okjiaoyu.qa.persistance.model.RequestHistory;
import okjiaoyu.qa.persistance.model.TestHistory;
import okjiaoyu.qa.persistance.model.TestResultCollection;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by zhangxiaozheng on 2016/7/5.
 */

public class MailController {

    private Logger logger = Logger.getLogger(this.getClass());

    private TestResultCollection testResultCollection;

    public void sendTestReport(String projectName, String reportType) {
        logger.info("开始发送邮件......");
        TestHistory testHistory = RunningParameter.testHistory;
        List<RequestHistory> requestHistories = RunningParameter.monitor_requestHistories;
//        String envName = Config.getGlobalValue("env");
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        String envName = getPropertiesData.getData("env");
//        ResourceBundle envname = ResourceBundle.getBundle("teacherweb");
//        String envName = envname.getString("env");
        String[] mailReceivers = getMailReceivers();
        String[] errorLogPaths = getErrorLogPath();
        try {
            testResultCollection = new TestResultCollection(testHistory, requestHistories);

            String executeType = testHistory.getExecutetype();
            String subject = SubjectBuilder.build(projectName, envName, executeType);

            ReportBuilder reportBuilder = ReportBuilderFactory.generateReportBuiler(testResultCollection, reportType);
            String mailContent = reportBuilder.buildReport();

            Mail mail = new Mail(mailReceivers, subject, MailMimeType.TEXT, errorLogPaths, mailContent);
            new MailBox().sendMail(mail);
            logger.info("testHistoryId:" + testResultCollection.getTestHistory().getId() + "发送邮件成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("testHistoryId:" + testResultCollection.getTestHistory().getId() + "发送邮件失败");
            logger.error(e.getMessage());
        }
    }

    private String[] getErrorLogPath() {
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        String[] result = getPropertiesData.getLogPath("machine");
        return result;
    }
//    private String[] getErrorLogPath(){
//        String machine = Config.getGlobalValue("machine");
//        String[] errorLogPaths = null;
//        switch (machine){
//            case "windows":
//                errorLogPaths = new String[] {Config.getModuleConfig("errorlogPath-windows") +",errorlog.txt"};
//                break;
//            case "linux":
//                errorLogPaths = new String[] {Config.getModuleConfig("errorlogPath-linux") +",errorlog.txt"};
//                break;
//            default:
//                errorLogPaths = new String[]{};
//                logger.error("no error log!");
//                break;
//        }
//        return errorLogPaths;
//    }

    private String[] getMachine(String machine) {
        String[] errorLogPaths = null;
        if (machine.equals("windows")) {
            errorLogPaths = new String[]{Config.getModuleConfig("errorlogPath-windows") + ",errorlog.txt"};
        } else if (machine.equals("linux")) {
            errorLogPaths = new String[]{Config.getModuleConfig("errorlogPath-linux") + ",errorlog.txt"};
        }
        return errorLogPaths;
    }

    private String[] getMailReceivers() {
//        String[] failReceivers;
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        String[] failReceivers = getPropertiesData.getData("mailReceivers").split(";");
//        if(Config.getModuleConfig("mailReceivers") != null
//                && !Config.getModuleConfig("mailReceivers").equals("")){
//            failReceivers = Config.getModuleConfig("mailReceivers").split(";");
//        }else{
//            failReceivers = new String[] {"leihoujian@okjiaoyu.cn"};
//            logger.error("Fail to get FailReceivers! please check!");
//        }
        return failReceivers;
    }
}
