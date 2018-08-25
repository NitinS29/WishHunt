<%-- 
    Document   : experts
    Created on : 31/10/2017
    Author     : Nitin
--%>
<%-- Include tag is used to import header and Navigation page --%>
<%@ include file="header.jsp" %>
<link href= "styles/Home.css" rel="stylesheet" >
<link href= "styles/bootstrap-datepicker3.min.css" rel="stylesheet" >
<link href= "styles/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/animate.css@3.5.2/animate.min.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ include file="navigation.jsp" %>
<section id="content w3-container" >
<table>

  <tr><th class="listName w3-card">EXPERTS LIST</th>
  <th>
  

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:forEach var="expert" items="${experts}">
  <tr class="details w3-card animated slideInUp">
    <td class="detail">
    <div class= "title">${expert.expertArea}</div>
   
   
    <div>${expert.firstName} ${expert.lastName}</div></td>
    <td>${expert.userName}</td>
    <td><form action="expertProfile" method="POST">
		<input type="hidden" name="action" value="expertProfile" />
		<input type="hidden" name="userName" value="${expert.userName}" />
		<button type="submit" class="btn btn-default btn-link">
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