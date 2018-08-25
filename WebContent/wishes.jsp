<%-- 
    Document   : wishes
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
<br>
<table>

  <tr><th class="listname w3-card">WISHES LIST</th>
  <th>
  <a href = "addWish.jsp" id="menuItem" class="btn btn-info">Add a Wish</a></th></tr>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:forEach var="wish" items="${wishes}">
  <tr class="details w3-card animated slideInUp">
    <td class="detail">
    <div class= "title">${wish.wishTitle}</div>
   
   
    <div>${wish.description}</div></td>
    <td>${wish.postedAt}</td>
    <td><form action="wishDetail" method="POST">
		<input type="hidden" name="action" value="wishDetail" />
		<input type="hidden" name="wishId" value="${wish.wishId}" />
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