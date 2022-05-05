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
		  	<img class="img-header" src="https://scontent.fmlm1-1.fna.fbcdn.net/v/t39.30808-6/279466520_5382950738396062_8478591622979059030_n.jpg?_nc_cat=102&ccb=1-5&_nc_sid=730e14&_nc_eui2=AeE5AAe_o9m4hJBZ76PXhVDA4cw4AuNRBo_hzDgC41EGjzMp18wi6OVMgi0SHAcmOvgBRRevgCljuQ7cSuNU9y0Y&_nc_ohc=GymDisod7FwAX_k6Z6g&_nc_ht=scontent.fmlm1-1.fna&oh=00_AT_QnMOLlhogqG83WuR9ZDH96OFXwWWhH4bZWQkJwK79_A&oe=6278D20D">
		
		    <div class="collapse navbar-collapse" id="navbarText">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active text-op-header" aria-current="page" href="#">Add Employee</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link text-op-header" href="#">Search Employees</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		
		<div class="p-5" style="margin-bottom:313px">
			<p id="title-page">Compensation History : Jonh Smith : <%= request.getAttribute("result") %>
				  ${result}</p>
			
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