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
		        <li class="nav-item">
		          <a class="nav-link text-op-header" href="#">Add Compensation</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		
		<div class="p-5" style="margin-bottom:313px">
			<p id="title-page">Compensation Breakdown for : Jonh Smith :  <%= request.getAttribute("result") %>
			${result}
			</p>
			<p>January / 2022</p>
			
			<div class="card">
			  <div class="card-body">			    
			    
			    <table class="table">
				  <thead>
				    <tr>
				      <th scope="col"></th>
				      <th scope="col">Date</th>
				      <th scope="col">Type</th>
				      <th scope="col">Amount</th>
				      <th scope="col">Description</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td scope="row">
				      	<a>
					      	<button type="button" class="btn btn-primary btn-form font-10">EDIT</button>
						</a>
				      </td>
				      <td>25 / January / 2022</td>
				      <td>Salary</td>
				      <td>$ 10023.00</td>
				      <td>
				      	<span class="d-inline-block text-truncate" style="max-width: 800px;">
						  lorem ipsum dolor sit amet consectetur adipiscing elit jhs sajkd ksjd kjdha sdjasdkasjd ksdhksahd kasjd awekuwgkjgd mnmnc jkshkahdf sakjfha akfh 
					      ton Thanks giving this use case. Can you give me little idea about what you are doing.Always I can help you out. Please provide little runnable code or 
					      fiddle. You can have form Submit level validation for in your code. Althoug
					     </span>
					 </td>
				    </tr>
				    <tr>
				      <td scope="row">
				      	<a>
					      	<button type="button" class="btn btn-primary btn-form font-10">EDIT</button>
						</a>
				      </td>
				      <td>25 / January / 2022</td>
				      <td>Salary</td>
				      <td>$ 10023.00</td>
				      <td>lorem ipsum dolor sit amet consectetur adipiscing elit</td>
				    </tr>
				    <tr>
				      <td scope="row">
				      	<a>
					      	<button type="button" class="btn btn-primary btn-form font-10">EDIT</button>
						</a>
				      </td>
				      <td>25 / January / 2022</td>
				      <td>Salary</td>
				      <td>$ 10023.00</td>
				      <td>lorem ipsum dolor sit amet consectetur adipiscing elit</td>
				    </tr>
				    <tr>
				    <td></td>
				    <td></td>
				    <td></td>
				    <td><b>Total: $57654.00</b></td>
				    <td></td>
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