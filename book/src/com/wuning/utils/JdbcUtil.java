package com.wuning.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author wu
 * @date 2020-04-17 22:49
 */
public class JdbcUtil {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns=new ThreadLocal<Connection>();

    static {
        try {
            Properties properties = new Properties();
            InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
//            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }

    public static Connection getConnection() {
        Connection conn = conns.get();
        if(conn==null){
            try {
                conn = dataSource.getConnection();
                conn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return conn;
    }

    public static void commitAndClose() {
        Connection connection = conns.get();
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally{
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();
    }
    public static void rollbackAndClose() {
        Connection connection = conns.get();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally{
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();
    }
}
