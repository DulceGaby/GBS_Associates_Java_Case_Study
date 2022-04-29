<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
			    rel="stylesheet"
			    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
			    crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		<meta charset="ISO-8859-1">
		<title>Home</title>
	</head>
	<style>
		.img-header{
			width:200px;
			margin-left:25px;
			margin-right:20px;
		}
		.btn-form{
			background-color:#1a2841 !important;
			border-color:#1a2841 !important;
			color:white !important;
		}
		.row-footer{
			background-color:#1a2841;
			color:white;
			font-size:13px;
		}	
		.text-op-header{			
			transition: all 0.25s ease-in-out;
			color:rgb(26, 40, 65);
		}
		.text-op-header:hover, .text-op-header:focus, .text-op-header:active{
			transition: all 0.25s ease-in-out;
			color:rgb(67, 104, 171);
		}
		#title-page{
			font-size:25px;
			color:#1a2841;
			font-weight:500;
			margin-bottom:30px !important;
		}
	</style>
	<body>
	
		<nav class="navbar navbar-expand-lg" style="background-color:#a7bee4">
		  <div class="container-fluid">
		  	<img class="img-header" src="https://scontent.fmlm1-1.fna.fbcdn.net/v/t39.30808-6/279466520_5382950738396062_8478591622979059030_n.jpg?_nc_cat=102&ccb=1-5&_nc_sid=730e14&_nc_ohc=k9ilTwYh0-wAX9wm8SP&_nc_ht=scontent.fmlm1-1.fna&oh=00_AT8K_HwcAXCx4PIUa8aycMFin75ECwKXngunv_I55b-DGg&oe=6270E90D">
		
		    <div class="collapse navbar-collapse" id="navbarText">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active text-op-header" aria-current="page" href="#">Add Employee</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link text-op-header" href="#">Search Employees</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link text-op-header" href="#">Compensation History</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		
		<div class="p-5" style="margin-bottom:211px">
			<p id="title-page">Add Employee Result is : <%= request.getAttribute("result") %>
				Also is : ${result}</p>
			<div class="card">
			  <div class="card-body">
			    <form>
			    	<div class="row">
			    		<div class="col">
			    			<div class="mb-3">
							    <label for="firstNameInput" class="form-label">First Name *</label>
							    <input type="text" name="firstName" class="form-control" id="firstNameInput" required aria-describedby="firstNameHelp">
				    			<div id="firstNameHelp" class="form-text">We'll never share your email with anyone else.</div>
				  			</div>
			    		</div>
			    		<div class="col">
			    			<div class="mb-3">
							    <label for="middleNameInput" class="form-label">Middle Name</label>
							    <input type="text" name="middleName" class="form-control" id="middleNameInput" aria-describedby="middleNameHelp">
				  			</div>
			    		</div>
			    	</div>
			    	
			    	<div class="row">
			    		<div class="col">
			    			<div class="mb-3">
							    <label for="lastNameInput" class="form-label">Last Name *</label>
							    <input type="text" name="lastName" class="form-control" id="lastNameInput" required aria-describedby="lastNameHelp">
				    			<div id="lastNameHelp" class="form-text">We'll never share your email with anyone else.</div>
				  			</div>
			    		</div>
			    		<div class="col">
			    			<div class="mb-3">
							    <label for="birthDateInput" class="form-label">Birth Date *</label>
							    <input type="date" name="birthDate" class="form-control" id="birthDateInput" required aria-describedby="birthDateHelp">
							    <div id="birthDateHelp" class="form-text">We'll never share your email with anyone else.</div>
				  			</div>
			    		</div>
			    	</div>
			    	<div class="row">
			    		<div class="col-6">
			    			<div class="mb-3">
							    <label for="positionInpur" class="form-label">Position *</label>
							    <select class="form-select" id="positionInpur" name="position" required>
								  <option selected>Part-time</option>
								  <option value="1">Full-time</option>
								  <option value="2">Seasonal </option>
								  <option value="3">Admin</option>
								</select>
				  			</div>
			    		</div>
			    	</div>
				  <button type="submit" class="btn btn-primary btn-form mt-3 mb-3">Submit</button>
				</form>
			  </div>
			</div>
		</div>
						
		<div class="row row-footer p-4">
		    <div class="col">
		    	IBM - Blue Journey
		    </div>
		    <div class="col" style="text-align:right">
		    	Dulce.Marin@ibm.com
		    </div>
	    </div>
	</body>
</html>