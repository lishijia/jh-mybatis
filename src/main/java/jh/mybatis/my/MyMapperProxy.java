package jh.mybatis.my;

import jh.mybatis.test.TestMapperXml;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-0817:20
 **/
public class MyMapperProxy implements InvocationHandler {

    private MySqlSession sqlSession;

    public MyMapperProxy(MySqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().getName().equals(TestMapperXml.NAMESPACE)){
            String sql = TestMapperXml.methodMapping.get(method.getName());
            System.out.println(String.format("SQL [ %s ], parameter [ %s ]", sql, args[0]));
            return sqlSession.selectOne(sql, args[0]);
        }
        return null;
    }
}
