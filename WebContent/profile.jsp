<%-- 
    Document   : profile
    Created on : 31/10/2017
    Author     : Nitin
--%>
<%-- Include tag is used to import header and Navigation page --%>
<%@ include file="header.jsp" %>
<%@ include file="navigation.jsp" %>
<link href= "styles/bootstrap-datepicker3.min.css" rel="stylesheet" >
<link href= "styles/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/animate.css@3.5.2/animate.min.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link href= "styles/Home.css" rel="stylesheet" >
<section id="content" >
<h2>Profile <a href = "editprofile.jsp" id="menuItem" class="btn btn-info"><span class="glyphicon glyphicon-pencil">Edit</span></a></h2>

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<dl class="dl-horizontal w3-card animated slideInUp">
    	<dt>Name</dt>
    	<dd>&nbsp;&nbsp;&nbsp;${user.firstName} ${user.lastName}</dd>
    	<dt>Email</dt>
    	<dd>&nbsp;&nbsp;&nbsp;${user.email}
    	</dd>
    	<dt>Phone</dt>
    	<dd>&nbsp;&nbsp;&nbsp;${user.phone}</dd> 
    	<dt>Address</dt>
    	<dd>&nbsp;&nbsp;&nbsp;${user.address}</dd>  
    	<dt>Expert</dt>
    	<dd>&nbsp;&nbsp;&nbsp;<c:choose>
    	<c:when test="${user.userType == '1'}">
    	Yes
    	</c:when>
    	<c:when test="${user.userType == '0'}">
    	No
    	</c:when>
    	</c:choose></dd>   
    	<dt>Expert Area</dt>
    	<dd>&nbsp;&nbsp;&nbsp;${user.expertArea}</dd>   
    	   
</dl>
</section>