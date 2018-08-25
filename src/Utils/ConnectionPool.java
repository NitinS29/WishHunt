package Utils;

import java.sql.*;
import javax.sql.DataSource;


public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    private ConnectionPool() {
    }

    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {         
    	Class.forName("com.mysql.jdbc.Driver");        
    	String dbName = "mydatabase";      
    	//String dbName = "wishdb";
    	String userName = "root";         
    	String password = "Nbad2017";   
    	//String password = "Ssdi@2017";
    	String hostname = "wishhuntdb.cxh9eamh24mb.us-east-1.rds.amazonaws.com";//"mydb.cx2xixbse7xd.us-west-2.rds.amazonaws.com";         
    	//String hostname = "localhost";
    	String port = "3306"; 
        String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;        
        return DriverManager.getConnection(jdbcUrl); 
    }

    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}