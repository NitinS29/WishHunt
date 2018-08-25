package Controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;
import Utils.EmailUtility;
/**
 * Servlet implementation class CommunicationServlet for email requests.
 */
@WebServlet({"/EmailSendingServlet","/email"})
public class CommunicationServlet extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
    	
    	String action = request.getParameter("action");
    	String url = "/email.jsp";
    	
    	String recipient = request.getParameter("recipient");
    	//String recipient = request.getAttribute("recipient").toString();
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        User sender = (User) request.getSession().getAttribute("user");
        System.out.println("rec " + recipient + "sub " + subject + "con " + content);
 
        String resultMessage = "";
    	
    	if(action.equals("sendEmail")){
        try {
        	StringBuilder emailBody = new StringBuilder();
        	if(!request.getParameter("directMail").equals("directMail")){
        	emailBody.append("Title: " + request.getParameter("activityTitle") +"\n");
        	emailBody.append("Description: " + request.getParameter("activityDescription") + "\n");
        	emailBody.append("Type: " + request.getParameter("activityType") + "\n\n");
        	}
        	emailBody.append("Sender" + "\n");
        	emailBody.append("Name: " +sender.getFirstName() + " " + sender.getLastName()+ "\n");
        	emailBody.append("Email: " + sender.getEmail() + "\n\n");
        	
        	emailBody.append("Message " + content);
        	
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    emailBody.toString());
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            
        }
    	}else if(action.equals("email")){
    		request.setAttribute("recipient", request.getParameter("emailId"));
    		request.setAttribute("directMail", request.getParameter("directMail"));
    		request.setAttribute("activityTitle", request.getParameter("activityTitle"));
    		request.setAttribute("activityDescription", request.getParameter("activityDescription"));
    		request.setAttribute("activityType", request.getParameter("activityType"));
    	}
    	
    	request.setAttribute("message", resultMessage);
        getServletContext().getRequestDispatcher(url).forward(
                request, response);
    }
}