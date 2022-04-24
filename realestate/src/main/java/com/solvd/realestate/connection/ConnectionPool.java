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

    private final String DB = "sql10487982";
    private final String URL = "jdbc:mysql://sql10.freesqldatabase.com:3306/"+DB;
    private final String USER = "sql10487982";
    private final String PASS = "MnNdCxbnC7";

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
            return  dataSource;
        }else{
            return dataSource;
        }
    }


    public Connection getConnection(){
        Connection conn = null;
        try{
            conn = basicDataSource.getConnection();
        }catch (SQLException e){
            LOGGER.log(Level.ERROR, "Unable to connect DataBase");
            e.printStackTrace();
            System.out.println(e.getErrorCode());
        }
        return conn;
    }

    public void closeConnection(Connection conn) throws  SQLException{
        conn.close();
    }
}
