<%-- 
    Document   : event
    Created on : 31/10/2017
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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<section id="content w3-container" >
<br>
<table>

  <tr><th class="listName w3-card">EVENTS LIST</th>
  <th>
  <a href = "addEvent.jsp" id="menuItem" class="btn btn-info">Add an Event</a></th></tr>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:forEach var="event" items="${events}">
  <tr class="details w3-card animated slideInUp">
    <td class="detail">
    <div class= "title">${event.eventTitle}</div>
   
    <div>${event.description}</div></td>
    <td>${event.postedAt}</td>
    <td><form action="eventDetail" method="POST">
		<input type="hidden" name="action" value="eventDetail" />
		<input type="hidden" name="eventId" value="${event.eventId}" />
		<button type="submit" class="btn btn-default btn-link">More
		<span class="glyphicon glyphicon-chevron-right"></span>
		</button>
		</form>
    </td>
  </tr>
  </c:forEach>

</table>
</section>
</body>
</html>