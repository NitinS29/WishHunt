package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ManageUsersDao;
import Model.User;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet({"/login","/signUp","/logout","/experts","/profile","/expertProfile","/editProfile"})
public class UsersServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		
		String url = "/home.jsp";
		
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
        
        if(action.equals("login")){
        	String userName = req.getParameter("username");
        	String password = req.getParameter("password");
        	User user = null;
        	try {
				user = ManageUsersDao.validateUser(userName, password);
        	}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				if(user != null){
					url = "/home.jsp";
					session.setAttribute("user", user);
				}
				else{
					url = "/login.jsp";
					req.setAttribute("message", "Invalid credentials!!");
				}
			     	
        }else if(action.equals("signUp")){
        	String userName = req.getParameter("username");
        	String firstName = req.getParameter("firstname");
        	String lastName = req.getParameter("lastname");
        	String email = req.getParameter("email");
        	String address = req.getParameter("address");
        	String password  = req.getParameter("password");
        	String expertArea = req.getParameter("expertArea");
        	int phone = Integer.parseInt(req.getParameter("phone"));
        	int userType = Integer.parseInt(req.getParameter("userType"));
        	
        	User user = new User();
        	user.setUserName(userName);
        	user.setLastName(lastName);
        	user.setFirstName(firstName);
        	user.setAddress(address);
        	user.setEmail(email);
        	user.setExpertArea(expertArea);
        	user.setPhone(phone);
        	user.setPassword(password);
        	user.setUserType(userType);
        	int result = 0;
        	try {
				 result = ManageUsersDao.addUser(user);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	if (result == 1){
        		url = "/home.jsp";
        		session.setAttribute("user", user);
        		req.setAttribute("message", "Sign up successful !!");
        	}
        	else{
        		url = "/signUp.jsp";
        		req.setAttribute("message", "Sign up unsuccessful !!");
        	}
        	
        }else if(action.equals("logout")){
        	if(req.getSession().getAttribute("user")!=null){
        		req.getSession().invalidate();
        	}
        	url = "/login.jsp";
        }else if (action.equals("getExperts")){
        	User sessionUser = (User) req.getSession().getAttribute("user");
    		
    		if (sessionUser != null){
        	ArrayList<User> experts = null;
			try {
				experts = ManageUsersDao.getExperts();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	req.setAttribute("experts", experts);
        	url = "/experts.jsp";
    		}else{
    			req.setAttribute("message", "Please login to view this page");
    			url= "/login.jsp";
    		}
        }else if(action.equals("userProfile")){
        	User sessionUser = (User) req.getSession().getAttribute("user");
    		
    		if (sessionUser != null){
        	url="/profile.jsp";
        }else{
			req.setAttribute("message", "Please login to view this page");
			url= "/login.jsp";
		}
        }else if(action.equals("expertProfile")){
        	User sessionUser = (User) req.getSession().getAttribute("user");
    		
    		if (sessionUser != null){
        	url="/expertProfile.jsp";
        	User expert = new User();
			try {
				expert = ManageUsersDao.getUser(req.getParameter("userName"));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	req.setAttribute("expert", expert);
    		}else{
    			req.setAttribute("message", "Please login to view this page");
    			url= "/login.jsp";
    		}
        }else if(action.equals("edit")){
        	User sessionUser = (User) req.getSession().getAttribute("user");
    		
    		if (sessionUser != null){
        	url = "/profile?action=userProfile";
        	String userName = req.getParameter("username");
        	String firstName = req.getParameter("firstname");
        	String lastName = req.getParameter("lastname");
        	String email = req.getParameter("email");
        	String address = req.getParameter("address");
        	String password  = req.getParameter("password");
        	String expertArea = req.getParameter("expertArea");
        	int phone = Integer.parseInt(req.getParameter("phone"));
        	System.out.println("user type "+req.getParameter("userType"));
        	int userType = Integer.parseInt(req.getParameter("userType"));
        	
        	User user = new User();
        	user.setUserName(userName);
        	user.setLastName(lastName);
        	user.setFirstName(firstName);
        	user.setAddress(address);
        	user.setEmail(email);
        	user.setExpertArea(expertArea);
        	user.setPhone(phone);
        	user.setPassword(password);
        	user.setUserType(userType);
        	int result = 0;
        	try {
				 result = ManageUsersDao.editUser(user);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	if (result == 1){
        		url = "/profile?action=userProfile";
        		session.setAttribute("user", user);
        		req.setAttribute("message", "Profile edited successfully !!");
        	}
        	else{
        		url = "/editprofile.jsp";
        		req.setAttribute("message", "Profilecould not be edited !!");
        	}	
        }else{
			req.setAttribute("message", "Please login to view this page");
			url= "/login.jsp";
		}
            }
        
        getServletContext()
        .getRequestDispatcher(url)
        .forward(req, resp);
		
	}
	
	

}
