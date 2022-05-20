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
		.font-10{
			font-size:10px !important;
		}
		.form-search{
			display:flex;
			align-items:center;
			justify-content:flex-end;
		}
	</style>
	<body>
	
		<nav class="navbar navbar-expand-lg" style="background-color:#a7bee4">
		  <div class="container-fluid">
		  	<img class="img-header" src="https://scontent.fmlm1-1.fna.fbcdn.net/v/t39.30808-6/279466520_5382950738396062_8478591622979059030_n.jpg?_nc_cat=102&ccb=1-5&_nc_sid=730e14&_nc_ohc=k9ilTwYh0-wAX9wm8SP&_nc_ht=scontent.fmlm1-1.fna&oh=00_AT8K_HwcAXCx4PIUa8aycMFin75ECwKXngunv_I55b-DGg&oe=6270E90D">
		
		    <div class="collapse navbar-collapse" id="navbarText">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active text-op-header" aria-current="page" href="add-employee">Add Employee</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link text-op-header" href="search">Search Employees</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link text-op-header" href="add-compensation">Add Compensation</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		
		<div class="p-5" style="margin-bottom:313px">
			<div style="display:flex; align-items:center">
				<a href="#">
					<svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16" style="margin:0px 10px 24px 0px; color:#1a2841">
					  <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
					</svg>
				</a>
				<p id="title-page">Compensation History : Jonh Smith : <%= request.getAttribute("result") %>
					  ${result}</p>
			</div>
			
			<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
			   <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
			    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
			  </symbol>
			</svg>				
			
			<%
		        if(request.getAttribute("mssg") != null)  {
		    %>            
		        <div class="alert alert-success alert-dismissible fade show" role="alert"  id="alert">
				  <div style="display:flex; align-items:center">
				  	 <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
				    ${mssg}
				  </div>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
		    <%
		        } 
		    %>
			
			<div class="card">
			  <div class="card-body">
			    
			    <form>
				    <div class="row mb-4 form-search">
				    	
				    	<div class="col-2">
				    		<div class="form-floating">
							  <input type="date" class="form-control" id="floatingInput1" name="start-date">
							  <label for="floatingInput1">Start date</label>
							</div>
				    	</div>
				    	<div class="col-2">
				    		<div class="form-floating">
							  <input type="date" class="form-control" id="floatingInput2" name="end-date">
							  <label for="floatingInput2">End date</label>
							</div>
				    	</div>
				    	<div class="col-1">
				    		<button type="submit" class="btn btn-primary btn-form">Submit</button>
				    	</div>
				    </div>
			    </form>
			    
			    
			    <table class="table">
				  <thead>
				    <tr>
				      <th scope="col"></th>
				      <th scope="col">Month / Year</th>
				      <th scope="col">Total</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td scope="row">
				      	<a>
					      	<button type="button" class="btn btn-primary btn-form font-10">VIEW</button>
						</a>
				      </td>
				      <td>January / 2022</td>
				      <td>$ 10023.00</td>
				    </tr>
				    <tr>
				      <td scope="row">
				      	<a>
					      	<button type="button" class="btn btn-primary btn-form font-10">VIEW</button>
						</a>
				      </td>
				      <td>January / 2022</td>
				      <td>$ 10023.00</td>
				    </tr>
				    <tr>
				      <td scope="row">
				      	<a>
					      	<button type="button" class="btn btn-primary btn-form font-10">VIEW</button>
						</a>
				      </td>
				      <td>January / 2022</td>
				      <td>$ 10023.00</td>
				    </tr>
				  </tbody>
				</table>
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