<%-- 
    Document   : editprofile
    Created on : 31/10/2017
    Author     : Nitin
--%>
<%-- Include tag is used to import header and Navigation page --%>
<%@ include file="header.jsp" %>
<%@ include file="navigation.jsp" %>

<link href= "styles/bootstrap-datepicker3.min.css" rel="stylesheet" >
<link href= "styles/bootstrap.min.css" rel="stylesheet" >
<link href= "styles/Home.css" rel="stylesheet" >
<section id="content">
<br>
  <div>
        <table>
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
              <div class="container">
    <div id="loginbox" class="mainbox col-md-6 col-md-offset-4 col-sm-6 col-sm-offset-3"> 

        
        <div class="panel panel-info" >
            <div class="panel-heading">
                <div class="panel-title text-center">Edit Profile</div>
            </div>     

            <div class="panel-body" >
            <form action="editProfile" method="post">
            <input type="hidden" name="action" value="edit" />
                <table>
                    <tr>
                        <td colspan=2>
                            <label for="username" >User Name</label>
                        </td>
                        <td colspan=3>
                            <input type="text" name="username" id="username" value="${user.userName}" readonly size = "30"/>
                        </td>
                        
                    </tr>
                    
                    <tr>
                        <td colspan=2>
                            <label for="password" >Password</label>
                        </td>
                        <td colspan=3>
                            <input type="password" name="password" id="password" value="${user.password}" size = "30"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan=2>
                            <label for="firstname">First Name</label>
                        </td>
                        <td colspan=3>
                            <input type="text" name="firstname" id="firstname" value="${user.firstName}" size = "30"/>
                        </td>
                    </tr>
                    <tr>
                    <tr>
                        <td>
                            <label for="lastname">Last Name</label>
                        </td>
                        <td colspan=3>
                            <input type="text" name="lastname" id="lastname" value="${user.lastName}" size = "30"/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="email">Email</label>
                        </td>
                        <td colspan=3>
                            <input type="text" name="email" id="email" value="${user.email}" size = "30"/>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                            <label for="address">Address</label>
                        </td>
                        <td colspan=3>
                            <input type="text" name="address" id="address" value="${user.address}" size = "30"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="phone">Phone</label>
                        </td>
                        <td colspan=3>
                            <input type="text" name="phone" id="phone" value="${user.phone}" size = "30"/>
                        </td>
                    </tr>
                    <tr>
                    	<td><label for="userType">Are you an expert ? </label></td>
                    	<td colspan=3>
                    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                    	<c:choose>
    	<c:when test="${user.userType == '1'}">
    	<input type="radio" name="userType" value="1" checked> Yes
                    	<input type="radio" name="userType" value="0"> No
    	</c:when>
    	<c:when test="${user.userType == '0'}">
    	<input type="radio" name="userType" value="1"> Yes
        <input type="radio" name="userType" value="0" checked> No
    	</c:when>
    	</c:choose>
                    	
                     </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="expertArea">Expert Area</label>
                        </td>
                        <td colspan=3>
                            <input type="textarea" name="expertArea" id="expertArea" value="${user.expertArea}"/>
                        </td>
                    </tr>
                    <tr></tr>
                    </table>
                    <br><br>
                    <table>
                    <tr>
                        <td></td>
                        <td>
                            <button id="save" name="save" class="btn btn-info">Save Changes</button>
                        </td>
                    </tr>
                    <tr><td>  </td></tr><tr></tr><tr></tr><tr></tr><tr></tr>
                    
                </table>
            </form>
            </div>    
            </div>                 
        </div>
    </div>
</div>
            </section>
</body>
</html>