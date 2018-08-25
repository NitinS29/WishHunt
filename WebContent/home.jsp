<%-- 
    Document   : home
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
<section id="content container">


<div>
    <div>
        <div class="col-md-3 animated slideInUp">
            <div class="card">
                <div class="card-image">
                    <img class="img-responsive" src="images/singing.jpg">
                    <span class="card-title">Wish</span>
                </div>
                
                <div class="card-content">
                    <p>Have a wish? Fulfill it.</p>
                </div>
                
                <div class="card-action">
                    <a href="wishes?action=wishes" target="new_blank">Wishes List</a>
                    <a href="addWish.jsp" target="new_blank">Make a Wish</a>
                    
                </div>
            </div>
        </div>
    </div>
    
    
    
        <div class="col-md-3 animated slideInUp">
            <div class="card">
                <div class="card-image">
                    <img class="img-responsive" src="images/hike.jpg">
                    <span class="card-title">Events</span>
                </div>
                
                <div class="card-content">
                    <p>Organising an Event ? Let intersted people.</p>
                </div>
                
                <div class="card-action">
                    <a href="events?action=events" target="new_blank">Events List</a>
                    <a href="addEvent.jsp" target="new_blank">Add an Event</a>
                    
                </div>
            </div>
        </div>
    </div>
    
    <div class="col-md-3 animated slideInUp">
            <div class="card">
                <div class="card-image">
                    <img class="img-responsive" src="images/expert.jpg">
                    <span class="card-title">Experts</span>
                </div>
                
                <div class="card-content">
                    <p>Learn from the best !!</p>
                </div>
                
                <div class="card-action">
                    <a href="experts?action=getExperts" target="new_blank">Experts</a>
                </div>
            </div>
        </div>
    

</section>