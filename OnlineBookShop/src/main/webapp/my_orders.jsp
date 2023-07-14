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
<link rel="stylesheet" href="./css/myorder.css">
<title>MY ORDERS</title>
</head>

<body>

	<!-- if user has not logged in then he will be redirected to login page -->
	<c:if test="${empty obj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<c:import url="/admincontroller/" />

	<header>
		<nav class="navbar">

			<div class="logo">
				<img src="./other_images/logo.png" alt=""> <a
					href="./index.jsp" class="bookbuddy">BOOKBUDDY</a>
			</div>

			<div class="center">

				<h3>My Orders</h3>


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

		<div class="orders">

			<div class="line2"></div>
			<div class="orders-table">

				<table>
					<tr>
						<th>Order Id</th>
						<th>Book name</th>
						<th>Book Author</th>
						<th>Book Price</th>
						<th>Payment Type</th>
					</tr>

					<c:if test="${!empty sessionScope.arrayList_orders }">
						<c:forEach items="${sessionScope.arrayList_orders}"
							var="list_orders">
							<tr>
								<td>Booking ID #${list_orders.getOrder_id()}</td>
								<td>${list_orders.getBook_name()}</td>
								<td>${list_orders.getBook_author()}</td>
								<td>${list_orders.getBook_price()}</td>
								<td>${list_orders.getPayment_type()}</td>
							</tr>
						</c:forEach>

					</c:if>

					<c:if test="${empty sessionScope.arrayList_orders }">
						<tr>
							<td>N/A</td>
							<td>N/A</td>
							<td>N/A</td>
							<td>N/A</td>
							<td>N/A</td>
						</tr>

					</c:if>
					

				</table>
			</div>

		</div>


	</main>