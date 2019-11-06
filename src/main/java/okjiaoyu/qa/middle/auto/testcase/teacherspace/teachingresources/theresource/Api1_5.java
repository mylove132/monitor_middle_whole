package okjiaoyu.qa.middle.auto.testcase.teacherspace.teachingresources.theresource;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by leo on 16/1/17.  保存资源包
 */
public class Api1_5 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        requestSampler.getFormValuePairs().put("resource_ids", param.get("resource_ids"));
        requestSampler.getFormValuePairs().put("title", param.get("title"));
        requestSampler.getFormValuePairs().put("chapter_id", param.get("chapter_id"));
        requestSampler.getFormValuePairs().put("chapter_level", param.get("chapter_level"));
        requestSampler.getFormValuePairs().put("directory_id", param.get("directory_id"));
//        requestSampler.getFormValuePairs().put("topics", param.get("topics"));
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postFormRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postFormRequest(param);
    }

}
