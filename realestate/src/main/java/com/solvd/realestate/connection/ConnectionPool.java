package com.solvd.realestate.connection;

import com.solvd.realestate.exception.BadAddressException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    public static final Logger LOGGER = LogManager.getLogger(BadAddressException.class.getName());

    private final String DB = "realestate";
    private final String URL = "jdbc:mysql://localhost:3306/"+DB;
    private final String USER = "root";
    private final String PASS = "";

    private static ConnectionPool dataSource;
    private BasicDataSource basicDataSource=null;

    private ConnectionPool(){
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);

        //min of active connections
        basicDataSource.setMinIdle(5);
        //max of active connections
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWaitMillis(10000);
    }

    //initialization
    public static ConnectionPool getInstance(){
        if (dataSource == null) {
            dataSource = new ConnectionPool();
        /*
            return  dataSource;
        }else{
            return dataSource;
        }
         */
        }
        return dataSource;

    }

    public Connection getConnection(){
        Connection conn = null;
        try{
            conn = basicDataSource.getConnection();
        }catch (SQLException e){
            LOGGER.log(Level.ERROR, "Unable to connect DataBase");
        }
        return conn;
    }

    public void closeConnection(Connection conn) throws  SQLException{
        conn.close();
    }
}
