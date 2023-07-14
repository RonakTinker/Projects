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
<link rel="stylesheet" href="../css/bookstore.css">
<title>BOOKBUDDY</title>
</head>

<body>

	<!-- if admin has not logged in then he will be redirected to login page -->
	<c:if test="${empty obj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<header>
		<nav class="navbar">

			<div class="logo">
				<img src="../other_images/logo.png" alt=""> <a
					href="../index.jsp" class="bookbuddy">BOOKBUDDY</a>
			</div>

			<div class="center">
				<h3>
					<c:if test="${!empty sessionScope.arrayList1 }">
						<c:if test="${!empty sessionScope.dataMessage }">
							<c:remove var="dataMessage" scope="session" />
						</c:if>
						ALL BOOKS
					</c:if>
					<c:if test="${empty sessionScope.arrayList1 }">
						${sessionScope.dataMessage}
					</c:if>
					
				</h3>
			</div>

			<div class="search-login">

				<div class="login-register">
					<a href="admin_home.jsp"><button>
							<span class="material-icons">account_circle</span>
						</button></a> <a href="logout.jsp"><button>
							<span class="material-icons">logout</span>
						</button></a>
				</div>
			</div>

		</nav>


	</header>


	<main>


		<div class="allbooks">

			<!-- <h1>ALL BOOKS</h1> -->
			<div class="line2"></div>

			<div class="card-container">

				<!-- showing suitable message if no books are there -->
				<c:if test="${!empty sessionScope.arrayList1 }">
					<c:forEach items="${sessionScope.arrayList1}" var="list">
						<div class="book-card">
							<img src="../book_images/${list.getBook_image()}" class="waff">
							<h3>${list.getBook_name()}</h3>
							<div class="description">
								<p>By: ${list.getBook_author()}</p>
							</div>
							<div class="description">
								<p>
									<b> <c:if test="${list.getBook_category() eq 'new'}"> Love, Romance,
				Drama </c:if> <c:if test="${list.getBook_category() eq 'old'}">
				Suspense , Thriller </c:if> <!-- Love, Romance, Drama -->
									</b>
								</p>
							</div>

							<div class="description">
								<p>Book ID:${list.getBook_id()}</p>
							</div>
							<div class="price">
								<b>RS ${list.getBook_price()}</b>
							</div>
						</div>
					</c:forEach>

				</c:if>



			</div>
		</div>



	</main>



</body>

</html>