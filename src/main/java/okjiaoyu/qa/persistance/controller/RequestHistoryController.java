package okjiaoyu.qa.persistance.controller;

import okjiaoyu.qa.persistance.inter.RequestHistoryMapper;
import okjiaoyu.qa.persistance.model.RequestHistory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.Reader;
import java.util.List;

/**
 * Created by zhangxiaozheng on 2016/2/19.
 */
public class RequestHistoryController {

    private Logger logger = Logger.getLogger(this.getClass());

    public void insertMonitorRequestHistorys(List<RequestHistory> requestHistories, Long testHistoryId) {
        SqlSession sqlSession = null;
        try {
            Reader reader = Resources.getResourceAsReader("config/mybatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            RequestHistoryMapper requestHistoryMapper = sqlSession.getMapper(RequestHistoryMapper.class);
            for (RequestHistory requestHistory : requestHistories) {
                requestHistory.setTestHistoryId(testHistoryId);
                check(requestHistory);
                requestHistoryMapper.insert(requestHistory);
            }
            logger.info("[sum of insert requestHistories]:" + requestHistories.size());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("保存数据失败:" + e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.commit();
                sqlSession.close();
            }
        }
    }

    private void check(RequestHistory requestHistory) {
        if (requestHistory.getRequestdata() == null) {
            requestHistory.setRequestdata("null");
        }
        if (requestHistory.getResponsedata() == null) {
            requestHistory.setResponsedata("null");
        }
        if (requestHistory.getRequestdata().length() > 1000) {
            requestHistory.setRequestdata(requestHistory.getRequestdata().substring(0, 900) + "...");
        }
        if (requestHistory.getResponsedata().length() > 1000) {
            requestHistory.setResponsedata(requestHistory.getResponsedata().substring(0, 900) + "...");
        }

        if (requestHistory.getRequestdata() == null) {
            requestHistory.setRequestdata("null");
        }
        if (requestHistory.getResponsedata() == null) {
            requestHistory.setResponsedata("null");
        }
        if (requestHistory.getRequestdata().length() > 1000) {
            requestHistory.setRequestdata(requestHistory.getRequestdata().substring(0, 900) + "...");
        }
        if (requestHistory.getResponsedata().length() > 1000) {
            requestHistory.setResponsedata(requestHistory.getResponsedata().substring(0, 900) + "...");
        }
    }

}
