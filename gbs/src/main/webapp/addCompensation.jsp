<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
			    rel="stylesheet"
			    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
			    crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<meta charset="ISO-8859-1">
		<title>Add compensation</title>
		
		<script>
			$(document).ready(function(){
				$("#typeInput").ready(function(){
					if($('#typeInput').val() == 'Salary'){
						$('#descriptionInput').prop('required',false);
						$("#amountInput").attr({"min" : "none"});
						$("#amountHelp").css("display", "none");
						$("#amountHelp2").css("display", "none");
					}
					else if($('#typeInput').val() == 'Bonus' || $('#typeInput').val() == 'Commission' || $('#typeInput').val() == 'Allowance'){
						$('#descriptionInput').prop('required',true);
						$("#amountInput").attr({"min" : 1});
						$("#amountHelp").css("display", "none");
						var amount = $("#amountInput").val();
						if(amount <= 0){
							$("#amountHelp2").css("display", "block");
						}
						else
							$("#amountHelp2").css("display", "none");
					}
					else{
						$('#descriptionInput').prop('required',true);
						$("#amountInput").attr({"min" : "none"});
						$("#amountHelp2").css("display", "none");
						var amount = $("#amountInput").val();
						if(amount == 0){
							$("#amountHelp").css("display", "block");
						}
						else
							$("#amountHelp").css("display", "none");
					}
				});
				$("#typeInput").change(function(){
					if($('#typeInput').val() == 'Salary'){
						$('#descriptionInput').prop('required',false);
						$("#amountInput").attr({"min" : "none"});
						$("#amountHelp").css("display", "none");
						$("#amountHelp2").css("display", "none");
					}
					else if($('#typeInput').val() == 'Bonus' || $('#typeInput').val() == 'Commission' || $('#typeInput').val() == 'Allowance'){
						$('#descriptionInput').prop('required',true);
						$("#amountInput").attr({"min" : 1});
						$("#amountHelp").css("display", "none");
						var amount = $("#amountInput").val();
						if(amount <= 0){
							$("#amountHelp2").css("display", "block");
						}
						else
							$("#amountHelp2").css("display", "none");
					}
					else{
						$('#descriptionInput').prop('required',true);
						$("#amountInput").attr({"min" : "none"});
						$("#amountHelp2").css("display", "none");
						var amount = $("#amountInput").val();
						if(amount == 0){
							$("#amountHelp").css("display", "block");
						}
						else
							$("#amountHelp").css("display", "none");
					}
				});
				
				$("#amountInput").change(function(){
					var amount = $("#amountInput").val();
					if(amount == 0 && $('#typeInput').val() == 'Adjustment'){
						$("#amountHelp").css("display", "block");
						$("#amountHelp2").css("display", "none");
					}
					else if(amount <= 0 && $('#typeInput').val() != 'Adjustment'){
						if($('#typeInput').val() == 'Bonus' || $('#typeInput').val() == 'Commission' || $('#typeInput').val() == 'Allowance'){
							$("#amountHelp2").css("display", "block");
							$("#amountHelp").css("display", "none");
						}
					}
					else{
						$("#amountHelp").css("display", "none");
						$("#amountHelp2").css("display", "none");
					}
				});
				
				
				$("#add-compensation").change(function(){
					if($('#amountHelp').css('display') == 'block' || $('#amountHelp2').css('display') == 'block')
					{
						$(':input[type="submit"]').prop('disabled', true);
					}
					else{
						$(':input[type="submit"]').prop('disabled', false);
					}
				});
			});
		</script>
		
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
		.form-text{
			color:#dc3545;
		}
		textarea{
			resize:none;
		}
	</style>
	<body>
	
		<nav class="navbar navbar-expand-lg" style="background-color:#a7bee4">
		  <div class="container-fluid">
		  	<img class="img-header" src="https://scontent.fmlm1-1.fna.fbcdn.net/v/t39.30808-6/279466520_5382950738396062_8478591622979059030_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=730e14&_nc_ohc=jngfCEj-eLAAX_Rvo1V&tn=b3RjrRajcpxP3Htu&_nc_ht=scontent.fmlm1-1.fna&oh=00_AT9Kfv3LFp9TURA3RS5IktiSOfuKA8nFjgZS-RZwBg1yhw&oe=62908D0D">
		
		    <div class="collapse navbar-collapse" id="navbarText">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active text-op-header" aria-current="page" href="/gbs/add-employee">Add Employee</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link text-op-header" href="/gbs/search">Search Employees</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link text-op-header" href="/gbs/add-compensation">Add Compensation</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		
		<div class="p-5" style="margin-bottom:225px">
			<p id="title-page">Add Employee Compensation</p>
			
				<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
				  <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
				    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
				  </symbol>
				</svg>			
				
				<%
			        if(request.getAttribute("mssg") != null)  {
			    %>            
			        <div class="alert alert-primary alert-dismissible fade show" role="alert"  id="alert">
					  <div style="display:flex; align-items:center">
					  	<svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Info:"><use xlink:href="#exclamation-triangle-fill"/></svg>
					    ${mssg}
					  </div>
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
			    <%
			        } 
			    %>
			
			<div class="card">
			  <div class="card-body">
			    <form action="addCompensation" id="add-compensation" method="post">
			    	<div class="row">
			    		<div class="col">
			    			<div class="mb-3">
							    <label for="typeInput" class="form-label">Employee *</label>
							    <select class="form-select" id="employeeInput" name="idEmployee" required>
							      <option selected readonly="readonly" hidden value=${employee.id}>${employee.firstName} ${employee.middleName} ${employee.lastName}: ${employee.birthDate}</option>
								  <c:forEach items="${employees}" var="employee">
									  <option value=${employee.id} >${employee.firstName} ${employee.middleName} ${employee.lastName}: ${employee.birthDate}</option>
								  </c:forEach>
								</select>
				  			</div>
			    		</div>
			    	</div>
			    	<div class="row">
			    		<div class="col">
			    			<div class="mb-3">
							    <label for="typeInput" class="form-label">Type *</label>
							    <select class="form-select" id="typeInput" name="type" required>
							    	  <option selected readonly="readonly" hidden>${compensation.type}</option>
									  <option value ="Salary">Salary</option>
									  <option value="Bonus">Bonus</option>
									  <option value="Commission">Commission </option>
									  <option value="Allowance">Allowance</option>
									  <option value="Adjustment">Adjustment</option>
								</select>
				  			</div>
			    		</div>
			    		<div class="col">
			    			<div class="mb-3">
							    <label for="amountInput" class="form-label">Amount *</label>
							    <input type="number" name="amount" class="form-control" id="amountInput" required aria-describedby="amountHelp" step="0.01" value=${compensation.amount}>
							     <div id="amountHelp" class="form-text" style="display:none">Amount can be any value except zero.</div>
							     <div id="amountHelp2" class="form-text" style="display:none">Amount should be greater than zero.</div>
				  			</div>
			    		</div>
			    	</div>
			    	<div class="row">
			    		<div class="col">
			    			<div class="mb-3">
							    <label for="descriptionInput" class="form-label">Description</label>
							    <textarea type="text" name="description" class="form-control" id="descriptionInput">${compensation.description}</textarea>
				  			</div>
			    		</div>
			    		<div class="col">
			    			<div class="mb-3">
							    <label for="dateInput" class="form-label">Date *</label>
							    <input type="date" name="date" class="form-control" id="dateInput" required aria-describedby="dateHelp" value=${compensation.date}>
				  			</div>
			    		</div>
			    	</div>
			    	
				  <a href="#" class="link-dark" style="margin-right:15px; text-decoration:none">Cancel</a>
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