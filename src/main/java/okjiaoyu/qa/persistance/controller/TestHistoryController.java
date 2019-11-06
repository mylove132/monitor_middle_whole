package okjiaoyu.qa.persistance.controller;

import okjiaoyu.qa.persistance.inter.TestHistoryMapper;
import okjiaoyu.qa.persistance.model.TestHistory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.Reader;

/**
 * Created by zhangxiaozheng on 2016/2/19.
 */
public class TestHistoryController {

    private Logger logger = Logger.getLogger(this.getClass());

    public void insert(TestHistory testHistory) {
        SqlSession sqlSession = null;
        try {
            Reader reader = Resources.getResourceAsReader("config/mybatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            TestHistoryMapper testHistoryMapper = sqlSession.getMapper(TestHistoryMapper.class);
            testHistoryMapper.insert(testHistory);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("保存数据失败:" + e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.commit();
                sqlSession.close();
            }
        }
    }

}
