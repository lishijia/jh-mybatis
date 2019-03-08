package jh.mybatis.session;

import jh.mybatis.config.JhConfiguration;
import jh.mybatis.executor.JhExecutor;
import jh.mybatis.mapper.MapperProxy;

import java.lang.reflect.Proxy;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-0810:50
 **/
public class JhDefaultSqlSession implements JhSqlSession{

    private JhConfiguration configuration;
    private JhExecutor executor = new JhExecutor();

    public JhConfiguration getConfiguration() {
        return configuration;
    }

    public JhDefaultSqlSession(JhConfiguration configuration, JhExecutor executor) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement, Object paramenter) {
        return executor.query(statement, paramenter);
    }

    @Override
    public <T> T getMapper(Class<T> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz},
                new MapperProxy(this, clazz));
    }
}
