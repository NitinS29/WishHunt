package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Event;
import Model.Wish;
import Utils.ConnectionPool;
import Utils.DBUtil;

public class ManageEventsDao {
	public static ArrayList<Event> getEvents()  throws ClassNotFoundException, SQLException{
		ArrayList<Event> eventlist = new ArrayList<Event>();
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT title,description,postedAt,activityId FROM Activity WHERE EXISTS "+
        "(Select * from Event WHERE Activity.activityId = Event.eventID) " + 
        		"ORDER BY Activity.postedAt DESC";
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Event event = null;
            System.out.println(query);      
            while (rs.next()) {
            	System.out.println(rs.getString("title")); 
            	event = new Event();
            	event.setEventTitle(rs.getString("title"));
            	event.setDescription(rs.getString("description"));
            	event.setPostedAt(rs.getTimestamp("postedAt"));
            	event.setEventId(rs.getInt("activityId"));
            	eventlist.add(event);
            }
            return eventlist;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
	}
	
	public static int addEvent(Event event) throws ClassNotFoundException, SQLException{
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Activity (title, description, location, postedAt, startDate,"
                		+ "endDate, posteBy) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
        	
            ps = connection.prepareStatement(query);
            ps.setString(1, event.getEventTitle());
            ps.setString(2, event.getDescription());
            ps.setString(3, event.getLocation());
            ps.setTimestamp(4, event.getPostedAt());
            ps.setDate(5, Wish.getInsertDate(event.getStartDate()));
            ps.setDate(6, Wish.getInsertDate(event.getEndDate()));
            ps.setString(7, event.getPostedBy());
            //ps.setDate(7, );
            //ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            int result = ps.executeUpdate();
            
            if (result == 1){
            	String query2 = "SELECT activityId FROM Activity WHERE Activity.title = ? AND Activity.description = ?";
            	   PreparedStatement stmt2 = connection.prepareStatement(query2);
            	   stmt2.setString(1, event.getEventTitle());
            	   stmt2.setString(2, event.getDescription());
            	   ResultSet result1 = stmt2.executeQuery();
            	   System.out.println("postedAT: " + event.getPostedAt());
            	   
            	   if(result1.next()){

            	   int  activityId = result1.getInt("activityId");
            	   
            	   String query3 = "INSERT into Event(eventID,capacity) VALUES (?,?)";
            	   PreparedStatement ps3 = connection.prepareStatement(query3);
            	   ps3.setInt(1, activityId);
                   ps3.setInt(2, event.getCapacity());
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
	
	public static Event getEvent(String eventId)  throws ClassNotFoundException, SQLException{
		//ArrayList<Wish> wishlist = new ArrayList<Wish>();
		//System.out.println("hello dao " + Integer.parseInt(wishId));
		Event event = new Event();
		ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        /*String query = "SELECT * FROM Activity WHERE EXISTS "+
        "(Select * from Event WHERE Activity.activityId=event.eventId AND event.eventId = ?);"  
        		; */
        String query = "SELECT e.capacity, a.* FROM Activity a, Event e WHERE " +
        		"a.activityId=e.eventID AND e.eventID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(eventId));
            rs = ps.executeQuery();
            //Wish wish = null;
            System.out.println(query);      
            if (rs.next()) {
            	//System.out.println(rs.getString("postedAt")); 
            	//wish = new Wish();
            	event.setEventTitle(rs.getString("title"));
            	event.setDescription(rs.getString("description"));
            	event.setPostedAt(rs.getTimestamp("postedAt"));
            	event.setEventId(rs.getInt("activityId"));
            	event.setStartDate(rs.getDate("startDate").toString());
            	event.setEndDate(rs.getDate("endDate").toString());
            	event.setPostedBy(rs.getString("posteBy"));
            	event.setCapacity(rs.getInt("capacity"));
            	System.out.println("start " + rs.getDate("startDate").toString()); 
            	//wishlist.add(wish);
            }
            return event;
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
