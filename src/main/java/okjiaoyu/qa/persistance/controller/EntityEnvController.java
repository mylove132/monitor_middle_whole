package okjiaoyu.qa.persistance.controller;

import okjiaoyu.qa.persistance.inter.EntityEnvMapper;
import okjiaoyu.qa.persistance.model.EntityEnv;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by zhangxiaozheng on 2016/2/28.
 */
public class EntityEnvController {

    public EntityEnv selectByPrimaryKey(int id) throws IOException {
        SqlSession session = null;
        EntityEnv entityEnv = null;
        try {
            Reader reader = Resources.getResourceAsReader("config/mybatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            EntityEnvMapper entityEnvMapper = session.getMapper(EntityEnvMapper.class);
            entityEnv = entityEnvMapper.selectByPrimaryKey(id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return entityEnv;
    }

}
