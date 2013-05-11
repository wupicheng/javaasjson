package com.db;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-10
 * Time: 下午4:04
 * To change this template use File | Settings | File Templates.
 */
public class DBManager {
    static String url = "jdbc:oracle:thin:@10.204.16.213:1521:CMSUAT";
    static String user = "sinocms";
    static String password = "sinocms";

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnetion() {
        Connection connection = null;
        try {


            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void DBClose(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
             e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        Connection connection = DBManager.getConnetion();
        System.out.println(connection);
        DBManager.DBClose(connection, null, null);
        System.out.println("数据库关闭");
    }
}
