package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author bai
 * @version V1.0
 * @Package com.utils
 * @date 2021/12/7 14:23
 * @describe
 */
public class DBUtils {
    static String username = null;
    static String pwd = null;
    static String driverName = null;
    static String url = null;

    static {
        try {
            FileInputStream is = new FileInputStream("D:\\IDEA\\Web\\music\\src\\main\\resources\\db.properties");
            Properties properties = new Properties();
            properties.load(is);
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

    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        return DriverManager.getConnection(url, username, pwd);
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
