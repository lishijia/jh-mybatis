package jh.mybatis.my;

import jh.mybatis.test.Test;
import jh.mybatis.test.TestMapper;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-0817:31
 **/
public class MyBootStrap {

    public static void main(String args[]){

        MySqlSession sqlSession = new MySqlSession(null);
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(10004);
        System.out.println(test.toString());
    }

}
