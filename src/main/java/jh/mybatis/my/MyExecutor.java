package jh.mybatis.my;

import jh.mybatis.test.Test;

import java.sql.*;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-0817:20
 **/
public class MyExecutor {

    public <E> E query(String statement, Object parameter){
        Connection conn;
        PreparedStatement preparedStatement;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(String.format(statement, Integer.parseInt(String.valueOf(parameter))));

            ResultSet rs = preparedStatement.executeQuery();
            Test test = new Test();
            while(rs.next()){
                test.setId(rs.getInt(1));
                test.setName(rs.getString(2));
            }
            return (E) test;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }

    public Connection getConnection() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.0.134:3306/smart_trip?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456q";

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
