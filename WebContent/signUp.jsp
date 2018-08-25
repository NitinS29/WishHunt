<%-- 
    Document   : signUp
    Created on : 31/10/2017
    Author     : Nitin
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<link href= "styles/Home.css" rel="stylesheet" >
<link href= "styles/bootstrap-datepicker3.min.css" rel="stylesheet" >
<link href= "styles/bootstrap.min.css" rel="stylesheet" >
<section id="content">
<br>
<div class="container">    
        <table>
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
    <div id="loginbox" class="mainbox col-md-6 col-md-offset-4 col-sm-6 col-sm-offset-3"> 

        
        <div class="panel panel-info" >
            <div class="panel-heading">
                <div class="panel-title text-center">SIGN UP</div>
            </div>     

            <div class="panel-body" >
            <form action="signUp" method="post">
            <input type="hidden" name="action" value="signUp" />
                <table>
                    <tr>
                        <td>
                            <label for="username" >User Name</label>
                        </td>
                        <td colspan=3 >
                            <input type="text" name="username" id="username" size = "30"/>
                        </td>
                        
                    </tr>
                    <tr>
	                    <td>
	                    	<label for="gender" >Gender</label>
	                    </td>
	                    <td colspan=3><input type="radio" name="gender" value="male" checked> Male
	  						<input type="radio" name="gender" value="female"> Female
	  					<input type="radio" name="gender" value="other"> Other  </td>
  					</tr>
                    <tr>
                        <td>
                            <label for="password" >Password</label>
                        </td>
                        <td colspan=3>
                            <input type="password" name="password" id="password" size = "30"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="password" >Confirm Password</label>
                        </td>
                        <td colspan=3>
                            <input type="password" name="password" id="password" size = "30"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="firstname">First Name</label>
                        </td>
                        <td colspan=3>
                            <input type="text" name="firstname" id="firstname" size = "30"/>
                        </td>
                    </tr>
                    <tr>
                    <tr>
                        <td>
                            <label for="lastname">Last Name</label>
                        </td>
                        <td colspan=3>
                            <input type="text" name="lastname" id="lastname" size = "30"/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="email">Email</label>
                        </td>
                        <td colspan=3> 
                            <input type="text" name="email" id="email" size = "30"/>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                            <label for="address">Address</label>
                        </td>
                        <td colspan=3>
                            <input type="text" name="address" id="address" size = "30"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="phone">Phone</label>
                        </td>
                        <td colspan=3>
                            <input type="text" name="phone" id="phone" size = "30"/>
                        </td>
                    </tr>
                    <tr>
                    	<td><label for="userType">Are you an expert ? </label></td>
                    	<td colspan=3><input type="radio" name="userType" value="1"> Yes
                    	<input type="radio" name="userType" value="0" checked> No </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="expertArea">Expert Area</label>
                        </td>
                        <td colspan=3>
                            <textarea name="expertArea" id="expertArea"></textarea>
                        </td>
                    </tr>
                    <tr></tr>
                    </table>
                    <br><br>
                    <table>
                    <tr>
                        <td></td>
                        <td>
                            <button id="register" name="register" class="btn btn-info">Sign Up</button>
                        </td>
                    </tr>
                    <tr><td>  </td></tr><tr></tr><tr></tr><tr></tr><tr></tr>
                    
                </table>
            </form>
            </div>                     
        </div>  
    </div>
</div>
            </section>
</body>
</html>