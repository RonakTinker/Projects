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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Ruda|Quattrocento">
<link rel="stylesheet" href="./css/bookstore.css">
<title>CART</title>
</head>

<body>

	<!-- checking if the user is logged in or not -->
	<c:if test="${empty obj}">
		<c:redirect url="login.jsp" />
	</c:if>

	<c:import url="/admincontroller/" />

	<header>
		<nav class="navbar">

			<div class="logo">
				<img src="./other_images/logo.png" alt=""> <a
					href="./index.jsp" class="bookbuddy">BOOKBUDDY</a>
			</div>

			<div class="center">

				<div>SHOPPING CART</div>

			</div>

			<div class="search-login">

				<div class="login-register">
					<a href="settings.jsp"><button>
							<span class="material-icons">account_circle</span>
						</button></a> <a href="./admin/logout.jsp"><button>
							<span class="material-icons">logout</span>
						</button></a>
				</div>
			</div>

		</nav>


	</header>


	<main>

		<div class="line2"></div>

		<div class="shop-cart">

			<div class="cart-left">
				<div>

					<table class="tb">
						<tr>
							<th>Book Name</th>
							<th>Book Author</th>
							<th>Book Price</th>
							<th>Action</th>

						</tr>

						<c:if test="${!empty sessionScope.arrayList_cart }">
							<c:forEach items="${sessionScope.arrayList_cart}" var="list_cart">

								<tr>
									<td>${list_cart.getBook_name()}</td>
									<td>${list_cart.getBook_author()}</td>
									<td>${list_cart.getBook_price()}</td>
									<td><a
										href="./admincontroller/removeBook?bid=${list_cart.getBook_id()}&&cid=${list_cart.getCart_id()}"
										class="shop-remove">Remove</a></td>
								</tr>

							</c:forEach>
						</c:if>

						<c:if test="${empty sessionScope.arrayList_cart }">
							<tr>
								<td>N/A</td>
								<td>N/A</td>
								<td>N/A</td>
								<td><a href="#" class="shop-remove">Remove</a></td>
							</tr>
						</c:if>

					</table>
				
					<!-- loop to get the total price. -->
					<c:forEach items="${sessionScope.arrayList_cart}" var="list_cart">
						<c:set var="total_price" value="${list_cart.getTotal_price()}" />
					</c:forEach>
				</div>

				<div class="shop-price">
					Total Price : Rs <span> 
					<c:if test="${!empty sessionScope.arrayList_cart }">
							${total_price}
					</c:if> 
					<c:if test="${empty sessionScope.arrayList_cart }">
							0.0
					</c:if> 	
						
					</span>
				</div>


			</div>



			<div class="cart-right">

				<form action="./admincontroller/order" method="post">
					<input type="hidden" value="${sessionScope.obj.getId()}" name="id" />
					<div class="Heading">
						<h2>
							<b>Details For Your Order</b>
						</h2>
					</div>
					<div class="form-css">
						<label for="N"><b>Name*</b></label> <input type="text" name='name'
							value="${sessionScope.obj.getName()}" id="N">
					</div>
					<div class="form-css">
						<label for="E"><b>Email-ID*</b></label> <input type="text"
							name='email' value="${sessionScope.obj.getEmail()}" id="E">
					</div>
					<div class="form-css">
						<label for="PH"><b>Phone Number*</b></label> <input type="text"
							name='phoneNo' value="${sessionScope.obj.getPhoneNo()}" id="PH">
					</div>

					<div class="form-css">
						<label for="P"><b>Street Address*</b></label> <input type="text"
							name='address' value="${sessionScope.obj.getAddress()}" id="P"
							placeholder="132 My Street">
					</div>
					<div class="form-css">
						<label for="P"><b>City*</b></label> <input type="text" name='city'
							value="${sessionScope.obj.getCity()}" id="P"
							placeholder="Kingston">
					</div>
					<div class="form-css">
						<label for="P"><b>State*</b></label> <input type="text"
							name='state' value="${sessionScope.obj.getState()}" id="P"
							placeholder="New York">
					</div>
					<div class="form-css">
						<label for="P"><b>Pin-code*</b></label> <input type="number"
							name='pin' value="${sessionScope.obj.getPin()}" id="P"
							placeholder="124013">
					</div>

					<div class="form-css bookprice">
						<label for="P"><b>Payment Type*</b></label> <select
							name='paymentType'>
							<option value="noselect">--No-select--</option>
							<option value="cod">Cash On Delivery</option>
						</select>
					</div>

					<div class="btn2 check">
						<input type="submit" value="Order Now ">
						<!-- showing failure message  if it comes -->
						<span class="material-icons">${sessionScope.message}</span>
						<c:remove var="message" scope="session" />
						<!--  --> 
					</div>

				</form>


			</div>




		</div>
	</main>



</body>

</html>