package jh.mybatis.my;

import java.lang.reflect.Proxy;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-0817:20
 **/
public class MySqlSession {

    private MyExecutor executor = new MyExecutor();

    public MySqlSession(MyExecutor executor) {
        //this.executor = executor;
    }

    public <T> T selectOne(String statement, Object parameter) {
        return executor.query(statement, parameter);
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MyMapperProxy(this));
    }

}
