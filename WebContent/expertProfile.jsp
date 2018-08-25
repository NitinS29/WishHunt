<%-- 
    Document   : expertProfile
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
  <link href= "styles/Home.css" rel="stylesheet" >
<section id="content" >
<h2>Profile</h2>
	<dl class="dl-horizontal animated bounceInRight">
    	<dt>Name</dt>
    	<dd>${expert.firstName} ${expert.lastName}</dd>
    	<dt>Email</dt>
    	<dd>${expert.email}
    	<form action="email" method="POST">
    	<input type="hidden" name="action" value="email" />
    	<input type="hidden" name="directMail" value="directMail" />
    	<input type="hidden" name="emailId" value="${expert.email}" />
    	<input type="hidden" name="activityTitle" value="" />
    	<input type="hidden" name="activityDescription" value="" />
    	<input type="hidden" name="activityType" value="Event" />
    	<button type="submit" class="btn btn-default btn-info">
          <span class="glyphicon glyphicon-envelope">
          </span> Email 
         </button>
        </form></dd>
    	<dt>Address</dt>
    	<dd>${expert.address}</dd>  
    	<dt>Expert</dt>
    	<dd>${expert.userType}</dd>   
    	<dt>Expert Area</dt>
    	<dd>${expert.expertArea}</dd>   
    	   
</dl>
</section>