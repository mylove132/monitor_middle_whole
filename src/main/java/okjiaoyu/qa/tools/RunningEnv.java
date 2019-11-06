package okjiaoyu.qa.tools;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.persistance.controller.LinkProjectEnvController;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
//import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by zhang_000 on 2015/10/26.
 * 存储运行时参数
 */
public class RunningEnv {

    Logger logger = Logger.getLogger(this.getClass());

    /**
     * save env info
     *
     * @param projectId     projectId
     * @param entity_env_id env_id
     * @param uname         uname
     * @param pwd           pwd
     * @param contentFormat contentFormat(Gzip or http)
     */

    public RunningEnv(int projectId, int entity_env_id, String uname, String pwd, String contentFormat) {
        //save data to local
        this.project_id = projectId;
        this.entity_env_id = entity_env_id;
        this.uname = uname;
        this.pwd = pwd;
        this.contentFormat = contentFormat;
        //get urlHeader
        this.urlHeader = new LinkProjectEnvController().fetch(this.project_id, this.entity_env_id).getUrlHeader();

        //get encrypt password
        switch (projectId) {
            case 1:
                this.encryptPwd = new RSA().getPasswordFromRedis(this.pwd, this.entity_env_id);
                break;
            case 3:
            case 4:
                String salt = "17802ec2980353bdc3f082b0668bd1e4";
                String key = StringUtils.substring(salt, 0, salt.length() / 8 * 8);
                try {
                    this.encryptPwd = DesUtil.encrypt(this.pwd, key);
                } catch (Throwable e) {
                    e.printStackTrace();
                    logger.error("Error occur during encrypt :" + ExceptionUtils.getFullStackTrace(e));
                }
                break;
            default:
                this.encryptPwd = new RSA().getPasswordFromRedis(this.pwd, this.entity_env_id);
                logger.error("[Error with projectId]:" + projectId);
        }
        //print RunningEnv
        logger.info("[RunningEnv]:" + JSONObject.toJSONString(this));
    }

    public int getEntity_env_id() {
        return entity_env_id;
    }

//    public void setEntity_env_id(int entity_env_id) {
//        this.entity_env_id = entity_env_id;
//    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEncryptPwd() {
        return encryptPwd;
    }

//    public void setEncryptPwd(String encryptPwd) {
//        this.encryptPwd = encryptPwd;
//    }

    public int getProject_id() {
        return project_id;
    }

//    public void setProject_id(int project_id) {
//        this.project_id = project_id;
//    }

    public String getUrlHeader() {
        return urlHeader;
    }

//    public void setUrlHeader(String urlHeader) {
//        this.urlHeader = urlHeader;
//    }

    public String getContentFormat() {
        return contentFormat;
    }

//    public void setContentFormat(String contentFormat) {
//        this.contentFormat = contentFormat;
//    }


    private int project_id;

    private int entity_env_id;

    private String urlHeader;

    private String uname;

    private String pwd;

    private String encryptPwd;

    private String uid;

    private String token;

    private String contentFormat;


    public String buildRealUpData(String jsonString) {
        String realJsonString;
        JSONObject json = new JSONObject();
        try {
            json = JSONObject.parseObject(jsonString);
            //replace wtih running param
            replaceJsonValue(json, "system_id_value", this.uname);
            replaceJsonValue(json, "account_value", this.uname);
            replaceJsonValue(json, "uname_value", this.uname);
            replaceJsonValue(json, "pwd_value", this.encryptPwd);
            replaceJsonValue(json, "uid_value", this.uid);
            replaceJsonValue(json, "token_value", this.token);
        } catch (Throwable e) {
            e.printStackTrace();
            logger.error("[Error]:encounter a problem during update request jsonString!!! [jsonString]:" + jsonString + "\n\r" + ExceptionUtils.getFullStackTrace(e));
        }
        realJsonString = JSONObject.toJSONString(json);
        return realJsonString;
    }

    @Test
    public void test() {
        String jsonString = "{\"pwd\":\"pwd_value\",\"uname\":\"uname_value\"}";
        this.uname = "339484995";
        this.encryptPwd = "2323dsofjowajeoqjdfopqjeofq";
        String realJsonString = buildRealUpData(jsonString);
        logger.info(realJsonString);
    }

    //替换Json中的字符串
    public void replaceJsonValue(JSONObject json, String beReplace, String replaceString) {
        if (json.containsValue(beReplace)) {
            logger.info("[JsonObject json]:" + JSONObject.toJSONString(json) + "--- replace:\"" + beReplace + "\"to\"" + replaceString + "\"");
            Set<String> keySet = json.keySet();
            for (String key : keySet) {
                if (json.get(key).equals(beReplace)) {
                    json.remove(key);
                    json.put(key, replaceString);
                    break;
                }
            }
        }
    }

}
