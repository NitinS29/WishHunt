package Dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


import Model.Wish;
import Utils.ConnectionPool;
import Utils.DBUtil;

public class ManageWishesDao {
	
	public static ArrayList<Wish> getWishes()  throws ClassNotFoundException, SQLException{
		ArrayList<Wish> wishlist = new ArrayList<Wish>();
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT title,description,postedAt,activityId FROM Activity WHERE EXISTS "+
        "(Select * from Wish WHERE Activity.activityId = Wish.wishID) " + 
        		"ORDER BY Activity.postedAt DESC"; 
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Wish wish = null;
            System.out.println(query);      
            while (rs.next()) {
            	System.out.println(rs.getString("postedAt")); 
            	wish = new Wish();
            	wish.setWishTitle(rs.getString("title"));
            	wish.setDescription(rs.getString("description"));
            	wish.setPostedAt(rs.getTimestamp("postedAt"));
            	wish.setWishId(rs.getInt("activityId"));
            	wishlist.add(wish);
            }
            return wishlist;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
	}
	
	public static int addWish(Wish wish) throws ClassNotFoundException, SQLException{
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Activity (title, description, location, postedAt, startDate,"
                		+ "endDate, posteBy) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
        	
            ps = connection.prepareStatement(query);
            ps.setString(1, wish.getWishTitle());
            ps.setString(2, wish.getDescription());
            ps.setString(3, wish.getLocation());
            ps.setTimestamp(4, wish.getPostedAt());
            ps.setDate(5, Wish.getInsertDate(wish.getStartDate()));
            ps.setDate(6, Wish.getInsertDate(wish.getEndDate()));
            ps.setString(7, wish.getPostedBy());
            //ps.setDate(7, );
            //ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            int result = ps.executeUpdate();
            
            if (result == 1){
            	String query2 = "SELECT activityId FROM Activity WHERE Activity.title = ? AND Activity.description = ?";
            	   PreparedStatement stmt2 = connection.prepareStatement(query2);
            	   stmt2.setString(1, wish.getWishTitle());
            	   stmt2.setString(2, wish.getDescription());
            	   ResultSet result1 = stmt2.executeQuery();
            	   System.out.println("postedAT: " + wish.getPostedAt());
            	   
            	   if(result1.next()){

            	   int  activityId = result1.getInt("activityId");
            	   
            	   String query3 = "INSERT into Wish(wishID,isUrgent) VALUES (?,?)";
            	   PreparedStatement ps3 = connection.prepareStatement(query3);
            	   ps3.setInt(1, activityId);
                   ps3.setBoolean(2, false);
                   //ps.setDate(7, );
                   //ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                   return ps3.executeUpdate();
            	   }
            	   
            }
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return 0;
	}
	
	public static Wish getWish(String wishId)  throws ClassNotFoundException, SQLException{
		//ArrayList<Wish> wishlist = new ArrayList<Wish>();
		//System.out.println("hello dao " + Integer.parseInt(wishId));
		Wish wish = new Wish();
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Activity WHERE EXISTS "+
        "(Select * from Wish WHERE Activity.activityId=Wish.wishID AND Wish.wishID = ?);"  
        		; 
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(wishId));
            rs = ps.executeQuery();
            //Wish wish = null;
            System.out.println(query);      
            if (rs.next()) {
            	System.out.println(rs.getString("postedAt")); 
            	//wish = new Wish();
            	wish.setWishTitle(rs.getString("title"));
            	wish.setDescription(rs.getString("description"));
            	wish.setPostedAt(rs.getTimestamp("postedAt"));
            	wish.setWishId(rs.getInt("activityId"));
            	wish.setStartDate(rs.getDate("startDate").toString());
            	wish.setEndDate(rs.getDate("endDate").toString());
            	wish.setPostedBy(rs.getString("posteBy"));
            	System.out.println("start " + rs.getDate("startDate").toString()); 
            	//wishlist.add(wish);
            }
            return wish;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
	}

}
