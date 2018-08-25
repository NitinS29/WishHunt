<%-- 
    Document   : login
    Created on : 31/10/2017
    Author     : Nitin
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<link href= "styles/Home.css" rel="stylesheet" >
<section id="content">
<br>
<div class="container">    
        
    <div id="loginbox" class="mainbox col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3"> 

        
        <div class="panel panel-info" >
            <div class="panel-heading">
                <div class="panel-title text-center">SIGN IN</div>
            </div>     

            <div class="panel-body" >
            
            <form id="loginForm" action="login" method="post">
            <input type="hidden" name="action" value="login" />
                <table>
                    <tr>
                        <td>
                            <label for="username">User Name:&nbsp;&nbsp;&nbsp;</label>
                        </td>
                        
                        <td>
                            &nbsp;&nbsp;<input type="text" name="username" id="username" />
                        </td>
                    </tr>
                    <tr><td>&nbsp; </td></tr>
                    
                    <tr>
                        <td>
                            <label for="password">Password:&nbsp;&nbsp;&nbsp;</label>
                        </td>
                        <td>
                            &nbsp;&nbsp;<input type="password" name="password" id="password" />
                        </td>
                    </tr>
                    </table>
                    <br><br>
                    <table>
                    <tr>
                        <td> </td>
                        <td>
                            <button id="login" name="login" class="btn btn-info">Login</button>
                        </td>
                    </tr>
                    <tr></tr>
                </table>
            </form>
            </div>                     
        </div>  
    </div>
</div>
            <table>
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
            </section>
</body>
</html>