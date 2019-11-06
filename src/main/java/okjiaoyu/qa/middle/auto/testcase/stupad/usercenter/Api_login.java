package okjiaoyu.qa.middle.auto.testcase.stupad.usercenter;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.base.TestBase;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import okjiaoyu.qa.persistance.model.RequestHistory;
import okjiaoyu.qa.tools.RunningParameter;
import okjiaoyu.qa.tools.TestReport;

/**
 * Created by 晓 on 2015/7/9.
 * for interface 2.1 apiRequest
 */
public class Api_login extends Pad {

    public void updateLogin() {
        //uame and pwd
        JSONObject requestJson = new JSONObject();
        requestJson.put("uname", account_uname);
        requestJson.put("pwd", account_pwd);
        requestJson.putAll(account_commonUp);
        //request
        requestSampler.setRequestInfo(requestJson.toString());
        logger.debug(requestSampler.getrequestDetailInfo());
        try {
            requestSampler.setInterfaceName("学生登陆接口");
            requestSampler.setTestCaseName("获取最新token,提供给其他接口测试");
            requestSampler.setType(2);
            requestSampler.setRequestUrl(getInterfaceUrl());
            requestSampler.post();
            JSONObject json_response = JSONObject.parseObject(requestSampler.getResponseInfo());
            requestSampler.setResponseInfo(json_response.toJSONString());
            System.out.println("打印: " + json_response.toJSONString());
            //update uid and token
            account_uid = JSONObject.parseObject(json_response.get("data").toString()).get("uid").toString();
            account_token = JSONObject.parseObject(json_response.get("data").toString()).get("token").toString();
            if (account_token != null && !account_token.equals("")) {
                requestSampler.setPass(true);
            }

            logger.debug("重新进行登录操作，更新后的uid和token：" + account_uid + " " + account_token);
        } catch (Exception e) {
            //控制台打印错误信息
            e.printStackTrace();
            //测试集的结果判定为false
            requestSampler.setPass(false);
            //输出错误信息到邮件
            TestReport.errorContent.append("<br> LOGIN FAIL!!! </br>");
            TestReport.errorContent.append("<br>[login requestInfo]: " + requestSampler.getrequestDetailInfo() + "<br>");
            TestReport.errorContent.append("<br>[login responseInfo]" + requestSampler.getResponseInfo() + "<br>");
            //输出错误信息到日志
            logger.error(requestSampler.getTestCaseInfo());
            logger.error("LOGIN FAIL!!!");
            logger.error("[login requestInfo]: " + requestSampler.getrequestDetailInfo());
            logger.error("[login responseInfo]" + requestSampler.getResponseInfo());
            logger.error("[error message]:" + e.getMessage());

            RequestHistory requestHistory = convertSampler2History(this.requestSampler);
            RunningParameter.monitor_requestHistories.add(requestHistory);

            new TestBase().saveRecord();
            System.exit(1);
        }
    }
}
