<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/all-css.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Ruda|Quattrocento">
<title>REGISTRATION</title>
</head>

<body>

	<header>
		<nav class="navbar">

			<div class="logo">
				<img src="./other_images/logo.png" alt=""> <span><a
					href="./index.jsp" class="bookbuddy">BOOKBUDDY</a></span>
			</div>

			<div class="center">
				<h2>${sessionScope.duplicateMsg}</h2>
				<c:remove var="duplicateMsg" scope="session" />
			</div>

			<div class="search-login">
				<div class="login-register">
					<a href="login.jsp"><button>
							<span class="material-icons">login</span>
						</button></a> <a href="register.jsp"><button>
							<span class="material-icons">how_to_reg</span>
						</button></a>
				</div>
			</div>

		</nav>


	</header>

	<main>

		<div>
			<img src="./other_images/left.png" alt="" class="wing">
		</div>

		<form action="./controller/register" method="post">
			<div class="Heading">
				<h2>
					<b>REGISTER HERE</b>
				</h2>
			</div>
			
			<div class="form-css">
				<label for="N"><b>Name*</b></label> <input type="text" name='name'
					id="N" placeholder="Jhon Doe">
			</div>
			<div class="form-css">
				<label for="E"><b>Email-ID*</b></label> <input type="text"
					name='email' id="E" placeholder="Xyz@gmail.com">
			</div>
			<div class="form-css">
				<label for="PH"><b>Phone Number*</b></label> <input type="number"
					name='phoneNo' id="PH" placeholder="809765xxxx">
			</div>
			<div class="form-css">
				<label for="P"><b>Password*</b></label> <input type="password"
					name='password' id="P"
					placeholder="Keep the length above 8 characters">
			</div>

			<div class="btn  check">
				<input type="submit" value=" Click to Register">
				 <!-- showing success or failure message sybmol -->
				<span class="material-icons">${sessionScope.message}</span>
				<c:remove var="message" scope="session" />
				<!--  -->
			</div>

		</form>

		<div>
			<img src="./other_images/right.png" alt="" class="wing">
		</div>

	</main>

</body>

</html>