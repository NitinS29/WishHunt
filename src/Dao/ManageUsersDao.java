package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.User;
import Model.Wish;
import Utils.ConnectionPool;
import Utils.DBUtil;

public class ManageUsersDao {
	
	public static User validateUser(String userName, String password) throws ClassNotFoundException, SQLException{
		User user = null;
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT u.*, e.expertArea FROM User u LEFT OUTER JOIN Expert e " 
        		+ "ON u.userName = e.userName "
        		+ "WHERE u.userName= ? AND u.password = ?";
        
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            //Wish wish = null;
            System.out.println(query);      
            if (rs.next()) {
            	user = new User();
            	user.setUserName(rs.getString("userName"));
            	user.setFirstName(rs.getString("firstName"));
            	user.setLastName(rs.getString("lastName"));
            	user.setEmail(rs.getString("email"));
            	user.setAddress(rs.getString("address"));
            	user.setPhone(rs.getInt("phone"));
            	user.setUserType(rs.getInt("userType"));
            	user.setExpertArea(rs.getString("expertArea"));
            	user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

		
	}
	
	public static int addUser(User user) throws ClassNotFoundException, SQLException{
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO User(userName, firstName, lastName, email, address, phone, userType, password) "		
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
        	
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getPhone());
            ps.setInt(7, user.getUserType());
            ps.setString(8, user.getPassword());
            //ps.setDate(7, );
            //ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            int result = ps.executeUpdate();
            
            if (result == 1 && user.getUserType() == 1){          	   
            	   String query3 = "INSERT into Expert(userName,expertArea) VALUES (?,?)";
            	   PreparedStatement ps3 = connection.prepareStatement(query3);
            	   ps3.setString(1, user.getUserName());
                   ps3.setString(2, user.getExpertArea());
                   //ps.setDate(7, );
                   //ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                   result = ps3.executeUpdate();  
            }
            return result;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        //return 0;
	}
	
	public static ArrayList<User> getExperts()  throws ClassNotFoundException, SQLException{
		ArrayList<User> experts = new ArrayList<User>();
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT u.*, e.expertArea FROM User u,Expert e WHERE EXISTS "+
        "(Select * from Expert WHERE u.userName = e.userName) "; 
        		 
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            User user = null;
            System.out.println(query);      
            while (rs.next()) {
            
            	user = new User();
            	user.setUserName(rs.getString("userName"));
            	user.setFirstName(rs.getString("firstName"));
            	user.setLastName(rs.getString("lastName"));
            	user.setEmail(rs.getString("email"));
            	user.setAddress(rs.getString("address"));
            	user.setPhone(rs.getInt("phone"));
            	user.setUserType(rs.getInt("userType"));
            	user.setExpertArea(rs.getString("expertArea"));
            	experts.add(user);
            }
            return experts;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
	}

	public static User getUser(String userName) throws ClassNotFoundException, SQLException{
		User user = new User();
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT u.*, e.expertArea FROM User u LEFT OUTER JOIN Expert e " 
        		+ "ON u.userName = e.userName "
        		+ "WHERE u.userName= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            //Wish wish = null;
            System.out.println(query);      
            if (rs.next()) {
            	user.setUserName(rs.getString("userName"));
            	user.setFirstName(rs.getString("firstName"));
            	user.setLastName(rs.getString("lastName"));
            	user.setEmail(rs.getString("email"));
            	user.setAddress(rs.getString("address"));
            	user.setPhone(rs.getInt("phone"));
            	user.setUserType(rs.getInt("userType"));
            	user.setExpertArea(rs.getString("expertArea"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

		
	}
	
	public static int editUser(User user) throws ClassNotFoundException, SQLException{
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement ps = null;

        String query
                = "UPDATE User set firstName = ?, lastName = ?, email = ?, address = ?, phone = ?, userType = ?, password = ? "		
                + "where username = ?";
        try {
        	
            ps = connection.prepareStatement(query);
            //ps.setString(1, user.getUserName());
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddress());
            ps.setInt(5, user.getPhone());
            ps.setInt(6, user.getUserType());
            ps.setString(7, user.getPassword());
            ps.setString(8, user.getUserName());
            //ps.setDate(7, );
            //ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            int result = ps.executeUpdate();
            
            if (result == 1 && user.getUserType() == 1){          	   
            	   String query3 = "INSERT into Expert(userName,expertArea) VALUES (?,?)";
            	   PreparedStatement ps3 = connection.prepareStatement(query3);
            	   ps3.setString(1, user.getUserName());
                   ps3.setString(2, user.getExpertArea());
                   //ps.setDate(7, );
                   //ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                   result = ps3.executeUpdate();  
            }
            return result;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        //return 0;
	}


}
