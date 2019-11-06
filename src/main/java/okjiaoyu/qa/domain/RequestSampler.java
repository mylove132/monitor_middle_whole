package okjiaoyu.qa.domain;

import okjiaoyu.qa.tools.APIHttpClient;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by zhang_000 on 2015/9/23.
 * request domain
 */
@Component
public class RequestSampler {

    private String requestProId;
    private String requestMethod;
    private String expectedCode;
    private String actualCode;
    private String requestUrl;
    private String requestInfo;
    private String requestId;
    private int httpStatus;
    private String responseInfo;
    private boolean isPass;
    private boolean dataCheck = true;
    public static Long startTime;
    public static Long endTime;
    public static Long responseTime;

    public RequestSampler() {

    }

    public List<String> getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        if (!StringUtils.isEmpty(keyWord)) {
            if (keyWord.contains(",")) {
                String[] split = keyWord.split(",");
                this.keyWord = Arrays.asList(split);
            } else {
                this.keyWord = new ArrayList<>();
                this.keyWord.add(keyWord);
            }
        }
    }


    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(String requestInfo) {
        this.requestInfo = requestInfo;
    }

    public String getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(String responseInfo) {
        this.responseInfo = responseInfo;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean isPass) {
        this.isPass = isPass;
        if (!isPass) {
            errorPrint();
        }
    }


    //添加响应时间
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setResponseTime() {
        // this.responseTime = getEndTime() - getStartTime();
//        this.responseTime = getEndTime() - getStartTime();
    }

    public Long getresponseTime() {
        return responseTime;
    }


    public String getExpectedCode() {
        return expectedCode;
    }

    public void setExpectedCode(String expectedCode) {
        this.expectedCode = expectedCode;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setRequestProId(String requestProId, String ran) {
        this.requestProId = requestProId;
    }

    public String getRequestProId() {
        return requestProId;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public boolean isDataCheck() {
        return dataCheck;
    }

    public void setDataCheck(boolean dataCheck) {
        this.dataCheck = dataCheck;
    }

    public String getDataCheckDetail() {
        return dataCheckDetail;
    }

    public void setDataCheckDetail(String dataCheckDetail) {
        this.dataCheckDetail = dataCheckDetail;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public Map<String, String> getFormValuePairs() {
        return formValuePairs;
    }

    public void setFormValuePairs(Map<String, String> formValuePairs) {
        this.formValuePairs = formValuePairs;
    }

    public Map<String, String> getFormFiles() {
        return formFiles;
    }

    public void setFormFiles(Map<String, String> formFiles) {
        this.formFiles = formFiles;
    }

    public CookieStore getCookieStore() {
        return cookieStore;
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
    }

    public void setActualCode(String actualCode) {
        this.actualCode = actualCode;
    }

    public List<NameValuePair> getGetRequsetParams() {
        return getRequsetParams;
    }

    public void setGetRequsetParams(List<NameValuePair> getRequsetParams) {
        this.getRequsetParams = getRequsetParams;
    }

    //from-data
    private Map<String, String> formValuePairs = new HashMap<>();
    private Map<String, String> formFiles = new HashMap<>();
    //get请求的参数
    private List<NameValuePair> getRequsetParams = new ArrayList<>();
    //cookies
    private Map<String, String> cookies = new HashMap<>();
    //cookieStore
    private CookieStore cookieStore;

    //infos
    private int type;//0：正常情况  1：异常情况  2；非测试用例
    private String mailInfo;
    private String dataCheckDetail = "Not verified";//返回数据错误的详细描述(不包括errorcode)
    private String interfaceName;
    private String testCaseName;
    private List<String> keyWord;

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }


    public RequestSampler(String requestJsonString) {
        this.requestInfo = requestJsonString;
    }

    public void judgePass() {
        isPass = actualCode.equals(expectedCode);
    }

    public Logger logger = Logger.getLogger(this.getClass());

    public void post() {
        new APIHttpClient().postJson(this);
    }

    public void postTest() {
        new APIHttpClient().postJsonTest(this);
    }

    public void postForTeacherspace() {
        new APIHttpClient().executePostRequest(this);
    }

    public String getTestCaseInfo() {
        return "[InterfaceName]:" + interfaceName + ", [TestCase]" + testCaseName;
    }

    public String getrequestDetailInfo() {
        return "[RequestUrl]: " + requestUrl + ", [RequestId]: " + requestId + ", [RequestJson]: " + requestInfo;
    }

    public String getHttpErrorInfo() {
        return " [Requestid]：" + requestId + ", " + getTestCaseInfo() + " 返回Http状态码：" + httpStatus;
    }

    public String getResultInfo() {
        String resultInfo = " [Requestid]：" + requestId + ", " + getTestCaseInfo() + ", [ExpectedCode]: " + expectedCode + ", [ActualCode]：" + actualCode + ", [TestResult]:" + (isPass && dataCheck);
        if (!dataCheckDetail.equals("Not verified")) {
            resultInfo += ", [DataCheck]:" + dataCheckDetail;
        }
        return resultInfo;
    }

    public void printRequestErrorDetail() {
        logger.error(getTestCaseInfo());
        logger.error(getrequestDetailInfo());
        logger.error("[ResponseJson]: " + responseInfo);
        logger.error("result:" + isPass());
    }

    public void errorPrint() {
        logger.error(getTestCaseInfo());
        logger.error(getrequestDetailInfo());
        logger.error(getHttpErrorInfo());
    }


}
