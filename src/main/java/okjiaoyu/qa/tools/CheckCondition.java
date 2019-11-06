package okjiaoyu.qa.tools;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by zhangxiaozheng on 2016/3/9.
 */
public class CheckCondition {

    Logger logger = Logger.getLogger(this.getClass());

    public CheckCondition() {

    }

    public CheckCondition(String str) {
        String[] arr = str.split(":");
        this.path = arr[0];
        this.expectedString = arr[1];
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExpectedString() {
        return expectedString;
    }

    public void setExpectedString(String expectedString) {
        this.expectedString = expectedString;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    String path;
    String expectedString;
    String relationship;

    @Test
    public void testVerify() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", "123456");
        jsonObject.put("msg", "成功");
        String condition = "data:123456;msg:成功";
        CheckCondition checkCondition = new CheckCondition(condition);
        logger.info(checkCondition.verify(jsonObject, condition));
    }

    public boolean verify(JSONObject responsJson, String checkdata) {
        boolean isTrue = true;
        String[] conditions = checkdata.split(";");
        for (int i = 0; i < conditions.length; i++) {
            CheckCondition checkCondition = new CheckCondition(conditions[i]);
            isTrue = isTrue && checkCondition.isTrue(responsJson);
        }
        return isTrue;
    }

    public boolean isTrue(JSONObject responsJson) {
        boolean isTrue;
        String actualString = getActualString(responsJson);
        if (actualString.equals(this.expectedString)) {
            isTrue = true;
        } else {
            isTrue = false;
        }
        return isTrue;
    }


    public String getActualString(JSONObject responsJson) {

        String actualString = "";
        try {
            int level = countStr(this.path, ".");
            if (level == 0) {
                actualString = responsJson.get(this.path).toString();
            } else if (level == 1) {
                String[] gradeName = this.path.split("\\.");
                actualString = responsJson.getJSONObject(gradeName[0]).get(gradeName[1]).toString();
            } else if (level == 2) {
                String[] gradeName = this.path.split("\\.");
                actualString = responsJson.getJSONObject(gradeName[0]).getJSONObject(gradeName[1]).get(gradeName[2]).toString();
            }
        } catch (Exception e) {
            logger.error("Error with responsJson:" + responsJson.toString());
        }

        return actualString;
    }

    public int countStr(String str1, String str2) {
        int counter = 0;
        if (str1.indexOf(str2) == -1) {
            return 0;
        }
        while (str1.indexOf(str2) != -1) {
            counter++;
            str1 = str1.substring(str1.indexOf(str2) + str2.length());
        }
        return counter;
    }

    @Test
    public void test() {
        logger.info(countStr("123.21.21", "."));
    }
}
