<%-- 
    Document   : eventDetail
    Created on : 28/11/2017
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
<h2>Event By</h2>
	<table class="w3-card animated bounceInRight">
    	<tr class="details"><td>Name</td>
    	<td>&nbsp;&nbsp;&nbsp;${user.firstName}</td><td>
    	<form action="profile" method="POST">
    	<input type="hidden" name="action" value="expertProfile"/>
    	<input type="hidden" name="userName" value="${user.userName}"/>
    	<button type="submit" class="btn btn-default">
          <span class="glyphicon glyphicon-info-sign"></span>
         </button>
        </form>
    	</td></tr>
    	<tr class="details"><td>Email</td>
    	<td>&nbsp;&nbsp;&nbsp;${user.email}</td><td>
    	<form class= "formInline" action="email" method="POST">
    	<input type="hidden" name="action" value="email" />
    	<input type="hidden" name="directMail" value="activtyMail" />
    	<input type="hidden" name="emailId" value="${user.email}" />
    	<input type="hidden" name="activityTitle" value="${event.eventTitle}" />
    	<input type="hidden" name="activityDescription" value="${event.description}" />
    	<input type="hidden" name="activityType" value="Event" />
    	<button type="submit" class="btn btn-default">
          <span class="glyphicon glyphicon-envelope"></span>
         </button>
        </form></td></tr>
    	<tr class="details"><td>Phone No</td>
    	<td>&nbsp;&nbsp;&nbsp;${user.phone}</td></tr>
   	</table>
   	<hr>
  <h2>Detail</h2>
  
  <table class="contentTable w3-card animated bounceInRight">
    <tr>
    <td>Title</td>
    <td>&nbsp;&nbsp;&nbsp;${event.eventTitle}</td></tr>
    <tr><td>Description</td>
    <td>&nbsp;&nbsp;&nbsp;${event.description}</td></tr>
    <tr><td>Posted At</td>
    <td>&nbsp;&nbsp;&nbsp;${event.postedAt}</td></tr>
    <tr><td>Start Date</td>
    <td>&nbsp;&nbsp;&nbsp;${event.startDate}</td></tr>
    <tr><td>End Date</td>
    <td>&nbsp;&nbsp;&nbsp;${event.endDate}</td></tr>
    <tr><td>Capacity</td>
    <td>&nbsp;&nbsp;&nbsp;${event.capacity}</td></tr>
</table>
</section>