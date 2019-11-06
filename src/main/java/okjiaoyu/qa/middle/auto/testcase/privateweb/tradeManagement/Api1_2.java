//package okjiaoyu.qa.middle.auto.testcase.privateweb.tradeManagement;
//
//import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * 商品列表-保存
// * Created by zhangchenglin on 2018/5/24.
// */
//public class Api1_2 extends PrivateWeb {
//
//    @Override
//    public void getParams(Map<String, String> param) {
//        List<NameValuePair> getRequestParams = new ArrayList<>();
////        String rr="{↵ \"topic\":1806,↵ \"directory_id\": \"12\",↵  \"ksu_id\": \"\",↵  \"ksu_name\": \"0516创建商品-02\",↵  \"module_list\": [↵  {↵ \"content\":\"http://common.okjiaoyu.cn/fb_YLk3y4l5jW.png\",↵  \"intro\": \"说明文字\",↵  \"sub_title\": \"标题老师简介\",↵  \"title\": \"模块一老师简介\"↵  }↵  ],↵  \"server_list\": [↵  {↵  \"price\": \"11.00\",↵  \"type\": 2↵  }↵  ],↵  \"stage_id\": \"1\",↵  \"subject_id\": \"3\",↵  \"status\": 2,↵  \"teacher\": {↵  \"content\":\"http://common.okjiaoyu.cn/fb_YLk1ILychi.png\",↵  \"intro\": \"SADA\"↵  },↵  \"teacher_id\": \"62951118988\",↵  \"version_id\": \"0\"↵  }";
//        //parms
//        getRequestParams.add(new BasicNameValuePair("org_id", param.get("org_id")));
//        getRequestParams.add(new BasicNameValuePair("org_name", param.get("org_name")));
//        getRequestParams.add(new BasicNameValuePair("org_type", param.get("org_type")));
//        getRequestParams.add(new BasicNameValuePair("admin_id", param.get("admin_id")));
//        getRequestParams.add(new BasicNameValuePair("raw_data", param.get("raw_data")));
//        requestSampler.setGetRequsetParams(getRequestParams);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"normal"})
//    public void test(Map<String, String> param) {
//        postRequest(param);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"exception"})
//    public void exceptionTest(Map<String, String> param) {
//        postRequest(param);
//    }
//
//}
