package jh.mybatis.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-08 15:21
 **/
public class TestMapperXml {
    public static String NAMESPACE = "jh.mybatis.test.TestMapper";

    public static Map<String, String> methodMapping = new HashMap<String, String>();

    static{
        methodMapping.put("selectByPrimaryKey", "select id, cms_name from st_cms where id = %d");
    }
}
