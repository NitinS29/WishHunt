<%-- 
    Document   : addEvent
    Created on : 31/10/2017
    Author     : Nitin
--%>
<%-- Include tag is used to import header and Navigation page --%>
<%@ include file="header.jsp" %>
<%@ include file="navigation.jsp" %>
<link href= "styles/Home.css" rel="stylesheet" >
<link href= "styles/bootstrap-datepicker3.min.css" rel="stylesheet" >
<link href= "styles/bootstrap.min.css" rel="stylesheet" >
<script src="js/jquery-2.1.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/moment-with-locales.js"></script>
<script src="js/bootstrap-datetimepicker.js"></script>
<div class="col-lg-8">
	<section id="content" class="addWish">
		<p class="text-success message-show"><i>${msg}</i></p>
		<p class="text-danger message-show"><i>${errormsg}</i></p>
		<form class="form-horizontal" action="addEvent" method="POST">
		<input type="hidden" name="action" value="addEvent" />
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="eventTitle">Event Title:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" required name="eventTitle" id="eventTitle" placeholder="Enter title">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="eventDescription">Event Description:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" required name="eventDescription" id="eventDescription" placeholder="Enter description">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="area">Area:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" required name="area" id="area" placeholder="Area">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="capacity">Capacity:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" required name="capacity" id="capacity" placeholder="Capacity">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="startDate">Starts on:</label>
		   	<div class="col-sm-10">
		    <div class='input-group date' id='datetimepicker1'>
                    <input type='text' name="startDate" required class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
		  </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="endDate">End on:</label>
		   	<div class="col-sm-10">
		    <div class='input-group date' id='datetimepicker2'>
                    <input type='text' name="endDate" required class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
		  </div>
		  </div>
		  
		  <div class="form-group"> 
		    <div class="col-sm-offset-2 col-sm-10">
		      <input type="submit" value="Submit" class="btn btn-default btn-info">
		    </div>
		  </div>
		</form>
	</section>
	</div>
	<script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
                $('#datetimepicker2').datetimepicker();
            });
        </script>