package okjiaoyu.qa.tools;

import com.noriental.utils.encrypt.Base64Utils;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by zhang on 2016/1/22.
 */
public class RSA {

    private Logger logger = Logger.getLogger(this.getClass());

//    ./redis-cli -h 172.18.4.178 -p 6381
//            (find port on project params)
//    keys *
//    get RSA_PUB_KEY

//    @Test
//    public void getPwd(){
////        RunningParameter.redisIp = Config.getGlobalValue("redisIp_test");
//        RunningParameter.redisIp = "10.60.0.63";
//        RunningParameter.redisPort = 6380;
//
//        getPassword("123456");
//    }


    public String getPasswordFromRedis(String pwd, int env_id) {
        String password = "";
        try {
            //获取公钥加密密码
            String pubkey = getPublicKeyFromRedis(env_id);

            byte[] src = pwd.getBytes("utf-8");
            byte[] dst = RSAUtils.encryptByPublicKey(src, pubkey);
            password = Base64Utils.encode(dst);

            logger.debug("encrypted password is" + " " + password + " ------------------");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(" get password error! ");
        }
        return password;
    }

    public String getPasswordFromRedis_V2(String pwd, String redis_ip, int redis_port) {
        String password = "";
        try {
            //获取公钥加密密码
            String pubkey = getPublicKeyFromRedis_V2(redis_ip, redis_port);

            byte[] src = pwd.getBytes("utf-8");
            byte[] dst = RSAUtils.encryptByPublicKey(src, pubkey);
            password = Base64Utils.encode(dst);

            logger.info("encrypted password is" + " " + password + " ------------------");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(" get password error! ");
        }
        return password;
    }

    public String getPassword(String pwd) {
        String password = "";
        try {
            //获取公钥加密密码
            String pubkey = getPublicKey();
            logger.info("[pubkey]:" + pubkey);
            byte[] src = pwd.getBytes("utf-8");
            byte[] dst;
            try {
                dst = new RSAUtils().encryptByPubKey(src, pubkey);
                password = Base64Utils.encode(dst);
            } catch (Exception e) {
                e.printStackTrace();
            }

            logger.info("[password]:" + password);
            logger.info("encrypted password is" + " " + password + " ------------------");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(" get password error! ");
        }
        return password;
    }

    //从Redis中取公钥
    public String getPublicKeyFromRedis_V2(String redis_ip, int redis_port) {
        RedisUtil redisUtil = new RedisUtil();
        String publicKey = redisUtil.getStringFromRedis_V2("RSA_PUB_KEY", redis_ip, redis_port);
        if (publicKey == null) {
//            test code, remove generating key codes
//            genKeyPair();
//            publicKey = redisUtil.getString("RSA_PUB_KEY");
            logger.error("RSA_PUB_KEY is null!");
            publicKey = "";
        }
        return publicKey;
    }

    @Test
    public void getPubKey() {
        logger.info(getPublicKeyFromRedis_V2("172.18.4.178", 6381));
    }

    @Test
    public void getPwd() {
        logger.info(getPasswordFromRedis_V2("123456", "10.60.0.63", 6381));
//        logger.info(getPasswordFromRedis_V2("123456", "172.18.4.178", 6381));
    }

    //从Redis中取公钥
    public String getPublicKeyFromRedis(int env_id) {
        RedisUtil redisUtil = new RedisUtil();
        String publicKey = redisUtil.getStringFromRedis("RSA_PUB_KEY", env_id);
        if (publicKey == null) {
//            test code, remove generating key codes
//            genKeyPair();
//            publicKey = redisUtil.getString("RSA_PUB_KEY");
            logger.error("RSA_PUB_KEY is null!");
            publicKey = "";
        }
        return publicKey;
    }

    public String getPublicKey() {
        RedisUtil redisUtil = new RedisUtil();
        String publicKey = redisUtil.getString("RSA_PUB_KEY");
        if (publicKey == null) {
//            test code, remove generating key codes
//            genKeyPair();
//            publicKey = redisUtil.getString("RSA_PUB_KEY");
            logger.error("RSA_PUB_KEY is null!");
            publicKey = "";
        }
        return publicKey;
    }

    @Test
    public void getPub() {
        logger.info("[RSA_PUB_KEY]:" + getPublicKey());
    }

}
