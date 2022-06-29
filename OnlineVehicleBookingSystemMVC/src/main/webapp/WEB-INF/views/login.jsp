<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}
h4{
padding:0;
margin:0;
}



.form-popup {
	display: none;
	position: fixed;
	bottom: 20%;
	left: 30%;
	border: 3px solid #f1f1f1;
	z-index: 9;
	background-color: violet;
}

.form-container {
	max-width: 1000px;
	padding: 10px;
	background-color: black;
}

.form-container input[type=text], .form-container input[type=password] {
	width: 100%;
	padding: 0;
	margin:0;
	border: none;
	background: rgba(110, 29, 255, 0.26);
}

.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}
.form-container .cancel {
	background-color: red;
}

.form-container .btn:hover, .open-button:hover {
	opacity: 1;
}
</style>


<meta charset="UTF-8">
<title>Login Page in HTML with CSS Code Example</title>
<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/styles/login.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link rel="stylesheet" href="./style.css">
<script type="text/javascript">
	function openForm() {
		document.getElementById("myForm").style.display = "block";
	}

	function closeForm() {
		document.getElementById("myForm").style.display = "none";
	}
	
	function validate() {
		var pw=document.getElementById("p");
		var pw1=document.getElementById("p1");
		if(pw!=pw1)
			alert("Passwords not matching! try again.");
		var un=document.getElementsByName("email");
		var r=document.getElementsByName("role");
		if(pw!=null && pw1!=null && un!=null && r!=null)
			alert("Successfully registered. Please login.");
		
		
	}
</script>
</head>
<body>
	<div class="box-form">
		<div class="left">
			<div class="overlay">
				<h1>Welcome to Online Vehicle Booking</h1>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Curabitur et est sed felis aliquet sollicitudin</p>
				<span>
					<p>login with social media</p> <a href="#"><i
						class="fa fa-facebook" aria-hidden="true"></i></a> <a href="#"><i
						class="fa fa-twitter" aria-hidden="true"></i> Login with Twitter</a>
				</span>
			</div>
	</div>

		<form action="/login" method="post">
			<div class="right">
				<h5>Login</h5>
				<p>
					Don't have an account? <a href="#" onclick="openForm()">Create
						Your Account</a> it takes less than a minute
				</p>

				

				<div id="dialog" title="Dialog box"></div>
				<div class="inputs">
					<input type="text" placeholder="user name" name="userId">
					<br> <input type="password" placeholder="password"
						name="password">
				</div>
				<br>
				<br>
				<font color="red">${smsg}</font>
				<div class="remember-me--forget-password">
									<label> <input type="checkbox" name="item" checked /> <span
					
						class="text-checkbox">Remember me</span>
					</label>
					<p>forget password?</p>
				</div>
				<br>
				
				<button>Login</button>
			</div>
			</form>
			<div class="form-popup" id="myForm">
					<form action="/doRegister" class="form-container">
						<h1 style="text-align:center;">Register</h1>

						<!-- <label for="email"><b>User Id</b></label> -->
						<h4>UserId</h4>
						<input type="text" placeholder="Enter username" name="userId"
							required>

						<h4>password</h4>
						<input type="password" placeholder="Enter Password" name="password" id="p"
							required>

					<!-- 	<h4>password</h4>
						<input type="password" placeholder="Re-Enter Password" name="psw" id="p1"
							required> -->
						<h4>Role</h4>
						<input type="text" placeholder="Role" name="role" required>
						<input type="hidden" name="status" value="Pending">

						<button type="submit" class="btn" >Register</button>
						<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
					</form>
				</div>
	</div>
	<!-- partial -->

</body>
</html>
