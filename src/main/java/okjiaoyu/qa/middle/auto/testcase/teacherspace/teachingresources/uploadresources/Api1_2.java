package okjiaoyu.qa.middle.auto.testcase.teacherspace.teachingresources.uploadresources;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by leo on 17/5/25.保存并上传题集
 */
public class Api1_2 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
//        requestSampler.getFormValuePairs().put("chapter_id", param.get("chapter_id"));
//        requestSampler.getFormValuePairs().put("chapter_level", param.get("chapter_level"));
        requestSampler.getFormValuePairs().put("collection_id", param.get("collection_id"));
//        requestSampler.getFormValuePairs().put("directory_id", param.get("directory_id"));
        requestSampler.getFormValuePairs().put("question_ids", param.get("question_ids"));
        requestSampler.getFormValuePairs().put("share_info", param.get("share_info"));
        requestSampler.getFormValuePairs().put("sort_type", param.get("sort_type"));
        requestSampler.getFormValuePairs().put("title", param.get("title"));
        requestSampler.getFormValuePairs().put("custom_system_id", param.get("custom_system_id"));
        requestSampler.getFormValuePairs().put("custom_directory_id", param.get("custom_directory_id"));
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