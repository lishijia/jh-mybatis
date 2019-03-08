package jh.mybatis.session;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-0810:48
 **/
public interface JhSqlSession {

    <T> T selectOne(String statement, Object paramenter);

    <T> T getMapper(Class<T> clazz);

}
