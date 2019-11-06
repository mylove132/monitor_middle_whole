package okjiaoyu.qa.middle.auto.testcase.teacherspace.usercenter;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import okjiaoyu.qa.tools.APIHttpClient;
import okjiaoyu.qa.tools.RunningEnv;
import okjiaoyu.qa.tools.RunningParameter;
import okjiaoyu.qa.tools.singleLogin.SingleLogin;
import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;



/**
 * Created by 晓 on 2015/7/9.
 * for interface 2.1 apiRequest
 */
public class Th_login extends TeacherSpace {

    @Test
    public void loginTest() {
        //requestInfo
        requestSampler.setType(0);//更新cookies，不属于测试用例
        requestSampler.setRequestUrl("https://jiaoshi.qa-hotfix.xk12.cn/");
        requestSampler.setInterfaceName("teacherspace登陆");
        requestSampler.setTestCaseName("更新cookies");
        requestSampler.setExpectedCode("success:false");
        //form-data
        requestSampler.getFormValuePairs().put("loginUser", loginUser);
        requestSampler.getFormValuePairs().put("password", password);
        requestSampler.getFormValuePairs().put("validateCode", validateCode);
        requestSampler.getFormValuePairs().put("password_new", password_new);
        //发送请求
        APIHttpClient httpClient = new APIHttpClient();
        httpClient.postFormdata(requestSampler);
        RunningParameter.cookieStore = requestSampler.getCookieStore();
        //断言，打印结果
        isSuccess(requestSampler);
    }

    @Test
    public void login() {
        //requestInfo
        requestSampler.setType(2);//更新cookies，不属于测试用例
        requestSampler.setRequestUrl(getInterfaceUrl());
        requestSampler.setInterfaceName(getInterfaceName());
        requestSampler.setTestCaseName("获取cookies给其他接口使用");
        requestSampler.setExpectedCode("data.user_state:4");
        //form-data
        requestSampler.getFormValuePairs().put("username", loginUser);
        requestSampler.getFormValuePairs().put("password", password);
        requestSampler.getFormValuePairs().put("validate_code", validateCode);
        //记录请求信息
        requestSampler.setRequestInfo(JSONObject.toJSONString(requestSampler.getFormValuePairs()));
        APIHttpClient httpClient = new APIHttpClient();
        try {
            String url = RunningParameter.urlHeader;
            String header = url.substring(0, url.length() - 1);
            CookieStore cookieStore = new SingleLogin(header, loginUser, password).login().getCookieStore();
            RunningParameter.cookieStore = cookieStore;
//            //发送请求 & 记录响应信息
//            httpClient.postFormdata(requestSampler);
//            //共享cookies给其他接口使用
//            RunningParameter.cookieStore = requestSampler.getCookieStore();
            logger.debug("------- login end --------");
            //判断是否通过你
            JSONObject responseJson = JSONObject.parseObject(requestSampler.getResponseInfo());
//            boolean isPass = isTestCasePass(responseJson, requestSampler.getExpectedCode());
            boolean isPass = !cookieStore.toString().isEmpty();

            if (isPass) {
                requestSampler.setPass(true);
                //  shutDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
            requestSampler.setPass(false);
            shutDown();
        }
    }

//    @Test
//    public void login(){
//        //requestInfo
//        requestSampler.setType(2);//更新cookies，不属于测试用例
//        requestSampler.setRequestUrl(getInterfaceUrl());
//        requestSampler.setInterfaceName(getInterfaceName());
//        requestSampler.setTestCaseName("获取cookies给其他接口使用");
//        requestSampler.setExpectedCode("success:true");
//        //form-data
//        requestSampler.getFormValuePairs().put("loginUser", loginUser);
//        requestSampler.getFormValuePairs().put("password", password);
//        requestSampler.getFormValuePairs().put("validateCode", validateCode);
//        requestSampler.getFormValuePairs().put("password_new", password_new);
//        //记录请求信息
//        requestSampler.setRequestInfo(JSONObject.toJSONString(requestSampler.getFormValuePairs()));
//        APIHttpClient httpClient = new APIHttpClient();
//        try{
//            //发送请求 & 记录响应信息
//            httpClient.postFormdata(requestSampler);
//            //共享cookies给其他接口使用
//            RunningParameter.cookieStore = requestSampler.getCookieStore();
//            logger.debug("------- login end --------");
//            //判断是否通过你
//            JSONObject responseJson = JSONObject.parseObject(requestSampler.getResponseInfo());
//            boolean isPass = isTestCasePass(responseJson, requestSampler.getExpectedCode());
//            if(!isPass){
//                TestReport.isPass = false;
//                shutDown();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            TestReport.isPass = false;
//            shutDown();
//        }
//    }

    @Test
    public void loginAndFetchToken(RunningEnv runningEnv) {
        //requestInfo
        requestSampler.setType(2);//更新cookies，不属于测试用例
        requestSampler.setRequestUrl(getInterfaceUrl());
        requestSampler.setInterfaceName(getInterfaceName());
        requestSampler.setTestCaseName("登陆并更新cookies");
        //form-data
        requestSampler.getFormValuePairs().put("loginUser", loginUser);
        requestSampler.getFormValuePairs().put("password", password);
        requestSampler.getFormValuePairs().put("validateCode", validateCode);
        requestSampler.getFormValuePairs().put("password_new", password_new);
        //发送请求
        APIHttpClient httpClient = new APIHttpClient();
        httpClient.postFormdata(requestSampler);
        RunningParameter.cookieStore = requestSampler.getCookieStore();
        logger.debug("------- login end --------");
//        断言，打印结果
        isSuccess(requestSampler);
    }

    @Test
    public void getWithCookieTest() {
        RequestSampler requestSampler = new RequestSampler();
        requestSampler.setRequestUrl("http://172.18.4.180:7000/quizcenter/quizset_detail?request_id=1451961936005&collection_id=30&type=2");
//        setCookies("teacher_id", "3c8bb400f54f47d5980a2723c44482f8","172.18.4.180","/");
        APIHttpClient apiHttpClient = new APIHttpClient();
        apiHttpClient.setCookies();
        apiHttpClient.getRequest(requestSampler);
        logger.info("[ResponseJson]: " + requestSampler.getRequestInfo());
    }


}
