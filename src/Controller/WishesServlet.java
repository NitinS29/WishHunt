package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ManageUsersDao;
import Dao.ManageWishesDao;
import Model.User;
import Model.Wish;
/**
 * Servlet implementation class WishesServlet to handle all the requests related to wishes
 */
@WebServlet({"/addWish","/wishes","/wishDetail"})
public class WishesServlet extends HttpServlet{

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
		String url = "/wishes.jsp";
		
		String action = req.getParameter("action");
		
		User sessionUser = (User) req.getSession().getAttribute("user");
		
		if (sessionUser != null){
        
        if(action.equals("wishes")){
        	ArrayList<Wish> wishes = null;
			try {
				wishes = ManageWishesDao.getWishes();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	req.setAttribute("wishes", wishes);
        	url = "/wishes.jsp";
        }
        else if(action.equals("addWish")){
        	Wish wish = new Wish();
        	wish.setWishTitle(req.getParameter("wishTitle"));
        	
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
        	wish.setDescription(req.getParameter("wishDescription"));
        	wish.setStartDate(req.getParameter("startDate"));
        	wish.setEndDate(req.getParameter("endDate"));
        	wish.setLocation(req.getParameter("area"));
        	wish.setPostedAt(new Timestamp(System.currentTimeMillis()));
        	wish.setPostedBy(sessionUser.getUserName());
        	try {
				int result = ManageWishesDao.addWish(wish);
				if(result==1){
					req.setAttribute("msg", "Wish addded successfully!!");
				} else{
					req.setAttribute("errormsg", "Error adding wish.");
	        	}
				url="/addWish.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else if(action.equals("wishDetail")){
        	System.out.println("hello servlet " + req.getParameter("wishId"));
        	Wish wish = null;
        	User user = null;
			try {
				wish = ManageWishesDao.getWish(req.getParameter("wishId"));
				user = ManageUsersDao.getUser(wish.getPostedBy());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	req.setAttribute("wish", wish);
        	req.setAttribute("user", user);
        	url = "/wishDetail.jsp";
        }
		}else{
			req.setAttribute("message", "Please login to view this page");
			url= "/login.jsp";
		}
        
        getServletContext()
        .getRequestDispatcher(url)
        .forward(req, resp);
	}

	
}
