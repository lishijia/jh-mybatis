package jh.mybatis.mapper;

import jh.mybatis.session.JhSqlSession;
import jh.mybatis.test.TestMapper;
import jh.mybatis.test.TestMapperXml;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-0814:31
 **/
public class MapperProxy<T> implements InvocationHandler {

    private final JhSqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(JhSqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().getName().equals(TestMapperXml.NAMESPACE)){
            String sql = TestMapperXml.methodMapping.get(method.getName());
            System.out.print(String.format("SQL[ %s ], parameter [ %s ] ", sql, args[0]));
            return sqlSession.selectOne(sql, String.valueOf(args[0]));
        }
        return null;
    }
}
