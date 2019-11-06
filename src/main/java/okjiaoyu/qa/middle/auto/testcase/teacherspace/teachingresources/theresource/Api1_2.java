package okjiaoyu.qa.middle.auto.testcase.teacherspace.teachingresources.theresource;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by leo on 16/1/17.  更新资源
 */
public class Api1_2 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        requestSampler.getFormValuePairs().put("chapter_id", param.get("chapter_id"));
        requestSampler.getFormValuePairs().put("file_name", param.get("file_name"));
        requestSampler.getFormValuePairs().put("file_size", param.get("file_size"));
        requestSampler.getFormValuePairs().put("md5", param.get("md5"));
        requestSampler.getFormValuePairs().put("open_to_student", param.get("open_to_student"));
        requestSampler.getFormValuePairs().put("resource_name", param.get("resource_name"));
        requestSampler.getFormValuePairs().put("share_type", param.get("share_type"));
        requestSampler.getFormValuePairs().put("id", param.get("id"));
        requestSampler.getFormValuePairs().put("file_type", param.get("file_type"));
        requestSampler.getFormValuePairs().put("directory_id", param.get("directory_id"));
        requestSampler.getFormValuePairs().put("type", param.get("type"));
        requestSampler.getFormValuePairs().put("custom_directory_id", param.get("custom_directory_id"));
        requestSampler.getFormValuePairs().put("custom_system_id", param.get("custom_system_id"));
        requestSampler.getFormValuePairs().put("version_id", param.get("version_id"));
        requestSampler.getFormValuePairs().put("topics", param.get("topics"));
        requestSampler.getFormValuePairs().put("file_id", param.get("file_id"));
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
