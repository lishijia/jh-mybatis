package jh.mybatis.executor;

import jh.mybatis.test.Test;

import java.sql.*;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-0810:49
 **/
public class JhExecutor {

    public <E> E query(String statement, Object paramenter){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = this.getConnection();
            preparedStatement = conn.prepareStatement(String.format(statement, Integer.parseInt(String.valueOf(paramenter))));
            ResultSet rs = preparedStatement.executeQuery();
            Test test = new Test();
            while (rs.next()) {
                test.setId(rs.getInt(1));
                test.setName(rs.getString(2));
            }
            return (E) test;
        }catch(Exception e){
            e.printStackTrace();;
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

//    public Connection getConnection(){
//        String driver = "com.mysql.cj.jdbc.Driver";
//        String url = "jdbc:mysql://192.168.0.134:3306/smart_trip?useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
//        String username = "root";
//        String password = "123456q";
//        Connection conn = null;
//        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }

    public Connection getConnection() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.0.134:3306/smart_trip?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456q";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
