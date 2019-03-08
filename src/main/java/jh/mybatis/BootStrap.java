package jh.mybatis;

import jh.mybatis.session.JhDefaultSqlSession;
import jh.mybatis.session.JhSqlSession;
import jh.mybatis.test.Test;
import jh.mybatis.test.TestMapper;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-08 14:24
 **/
public class BootStrap {

    public static void main(String args[]){
        System.out.println(String.format("aaaaaaaaaaaaa%s", "12"));
        JhSqlSession sqlSession = new JhDefaultSqlSession(null, null);
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(10004);
        System.out.println(test.toString());
    }

}
