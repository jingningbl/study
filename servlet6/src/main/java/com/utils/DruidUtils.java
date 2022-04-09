package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author:Administrator
 * @data:2021/11/27
 * @description:
 */
public class DruidUtils {
    //    用户名
    static String username = null;
    //    密码
    static String pwd = null;
    //    驱动
    static String driverName = null;
    //    url
    static String url = null;

    static {
        try {
//            读取配置文件
            FileInputStream is = new FileInputStream("D:\\IDEA\\Web\\servlet6\\src\\main\\resources\\druil.properties");
//            获取文件信息
            Properties properties = new Properties();
//            加载
            properties.load(is);
//            赋值
            username = properties.getProperty("username");
            pwd = properties.getProperty("pwd");
            driverName = properties.getProperty("driverName");
            url = properties.getProperty("url");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    建立连接
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        return DriverManager.getConnection(url, username, pwd);
    }

    //    关闭连接
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}