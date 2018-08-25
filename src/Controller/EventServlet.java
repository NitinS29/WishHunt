package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ManageEventsDao;
import Dao.ManageUsersDao;
import Dao.ManageWishesDao;
import Model.Event;
import Model.User;
import Model.Wish;
/**
 * Servlet implementation class EventServlet to handle all the requests related to events
 */
@WebServlet({"/addEvent","/events","/eventDetail"})
public class EventServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String url = "/event.jsp";
		
		String action = req.getParameter("action");	
		User sessionUser = (User) req.getSession().getAttribute("user");
		
		if (sessionUser != null){
			if(action.equals("events")){
        	ArrayList<Event> events = null;
			try {
				events = ManageEventsDao.getEvents();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	req.setAttribute("events", events);
        	url = "/event.jsp";
		}else if(action.equals("addEvent")){
        	Event event = new Event();
        	event.setEventTitle(req.getParameter("eventTitle"));
        	
			/*SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        	Date startDate = null, endDate = null;
			try {
				startDate = sdf.parse(req.getParameter("startDate"));
				endDate = sdf.parse(req.getParameter("endDate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
        	/*long t = System.currentTimeMillis();
        	Timestamp ts = new Timestamp(t*1000);
        	String s = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss").format(ts);
        	Timestamp postedAt = Timestamp.valueOf(s);*/
        	event.setDescription(req.getParameter("eventDescription"));
        	event.setStartDate(req.getParameter("startDate"));
        	event.setEndDate(req.getParameter("endDate"));
        	event.setLocation(req.getParameter("area"));
        	event.setPostedAt(new Timestamp(System.currentTimeMillis()));
        	event.setCapacity(Integer.parseInt(req.getParameter("capacity")));
        	event.setPostedBy(sessionUser.getUserName());
        	try {
				int result = ManageEventsDao.addEvent(event);
				if(result==1){
					req.setAttribute("msg", "Event addded successfully!!");
				} else{
					req.setAttribute("errormsg", "Error adding event.");
	        	}
				url="/addEvent.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else if(action.equals("eventDetail")){
        	System.out.println("hello servlet " + req.getParameter("eventId"));
        	Event event = null;
        	User user = null;
			try {
				event = ManageEventsDao.getEvent(req.getParameter("eventId"));
				user = ManageUsersDao.getUser(event.getPostedBy());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	req.setAttribute("event", event);
        	req.setAttribute("user", user);
        	 url = "/eventDetail.jsp";
        }
		}
			else{
			req.setAttribute("message", "Please login to view this page");
			url= "/login.jsp";
		}
        	
        
        getServletContext()
        .getRequestDispatcher(url)
        .forward(req, resp);
	}

	
}
