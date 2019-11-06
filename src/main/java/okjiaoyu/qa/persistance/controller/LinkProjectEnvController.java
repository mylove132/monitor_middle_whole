package okjiaoyu.qa.persistance.controller;

import okjiaoyu.qa.persistance.inter.LinkProjectEnvMapper;
import okjiaoyu.qa.persistance.model.LinkProjectEnv;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.Reader;

/**
 * Created by zhangxiaozheng on 2016/2/28.
 */
public class LinkProjectEnvController {

    private Logger logger = Logger.getLogger(this.getClass());

    public LinkProjectEnv fetch(int projectId, int envId) {
        SqlSession sqlSession = null;
        LinkProjectEnv linkProjectEnv = null;
        try {
            Reader reader = Resources.getResourceAsReader("config/mybatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            LinkProjectEnvMapper linkProjectEnvMapper = sqlSession.getMapper(LinkProjectEnvMapper.class);
            linkProjectEnv = linkProjectEnvMapper.loadProjectEnv(projectId, envId);
            if (linkProjectEnv == null) {
                logger.info("Error fetch linkProjectEnv by projectId:" + projectId + "and envId:" + envId);
                linkProjectEnv = new LinkProjectEnv();
                linkProjectEnv.setUrlHeader("[empty, fail to get data]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取项目环境信息失败:" + e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.commit();
                sqlSession.close();
            }
        }
        return linkProjectEnv;
    }

}
