<%-- 
    Document   : email
    Created on : 31/11/2017
    Author     : Nitin
--%>
<%-- Include tag is used to import header and Navigation page --%>
<%@ include file="header.jsp" %>
<%@ include file="navigation.jsp" %>
<link href= "styles/Home.css" rel="stylesheet" >
<link href= "styles/bootstrap-datepicker3.min.css" rel="stylesheet" >
<link href= "styles/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/animate.css@3.5.2/animate.min.css">
<section id="content container">
<br>
<table>
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
<div class="container">
    
        
    <div id="loginbox" class="mainbox col-md-6 col-md-offset-2 col-sm-6 col-sm-offset-3"> 

        
        <div class="panel panel-info animated rollIn" >
            <div class="panel-heading">
                <div class="panel-title text-center">Communication</div>
            </div>     

            <div class="panel-body" >
            
            <form action="EmailSendingServlet" method="post">
            <input type="hidden" name="action" value="sendEmail" />
            <input type="hidden" name="directMail" value="${directMail}" />
            <input type="hidden" name="activityTitle" value="${activityTitle}" />
            <input type="hidden" name="activityDescription" value="${activityDescription}" />
            <input type="hidden" name="activityType" value="${activityType}" />
             
                <table>
                    <tr>
                        <td>
                            <label for="recipient">Recipient&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label>
                        </td>
                        
                        <td>
                            &nbsp; &nbsp;&nbsp; &nbsp;<input type="text" name="recipient" id="recipient" value="${recipient}" size = "30" readonly/>
                        </td>
                    </tr>
                   <tr><td>&nbsp; </td></tr>
                    <tr>
                        <td>
                            <label for="subject">Subject&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label>
                        </td>
                        
                        <td>
                            &nbsp; &nbsp;&nbsp; &nbsp;<input type="text" name="subject" id="subject" size = "30"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <label for="content">Message</label>
                        </td>
                        <td>
                            <textarea rows="5" cols = "20" name="content" id="content" ></textarea>
                        </td>
                    </tr>
                    </table>
                    <br><br>
                    <table>
                    <tr>
                        
                        <td>
                            <input type="submit" id="send" name="send" class="btn btn-info"></button>
                        </td>
                    </tr>
                    <tr></tr>
                </table>
            </form>
            </div>                     
        </div>  
    </div>
</div>
            
</section>
</body>
</html>