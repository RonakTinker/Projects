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
<title>BOOKBUDDY</title>
</head>

<body>

	<c:import url="/admincontroller/" />
	
	<header>
		<nav class="navbar">

			<div class="logo">
				<img src="./other_images/logo.png" alt=""> <a
					href="./index.jsp" class="bookbuddy">BOOKBUDDY</a>
			</div>

			<div class="center">

				<h3>
				
				<c:if test="${!empty sessionScope.arrayList_all }">
					<c:if test="${!empty sessionScope.message2 }">
						<c:remove var="message2" scope="session" />
					</c:if>
					ALL BOOKS
				</c:if>
				
				<c:if test="${empty sessionScope.arrayList_all }">
					${sessionScope.message2}
				</c:if>
			
				</h3>

			</div>

			<div class="search-login">


				<!--  -->
				<!-- setting the dynamic navigation bar -->

				<c:if test="${!empty sessionScope.obj}">
					<div class="login-register">

						<c:if test="${sessionScope.name eq 'admin'}">
							<a href="./admin/admin_home.jsp"><button>
									<span class="material-icons">account_circle</span>
								</button></a>
							<a href="admin/logout.jsp"><button>
									<span class="material-icons">logout</span>
								</button></a>
						</c:if>
						<c:if test="${sessionScope.name eq 'user'}">
							<a href="cart.jsp"><button>
									<span class="material-icons">shopping_cart</span>
								</button></a>
							<a href="settings.jsp"><button>
									<span class="material-icons">account_circle</span>
								</button></a>
							<a href="admin/logout.jsp"><button>
									<span class="material-icons">logout</span>
								</button></a>
						</c:if>

					</div>
				</c:if>

				<c:if test="${empty sessionScope.obj}">
					<div class="login-register">
						<a href="login.jsp"><button>
								<span class="material-icons">login</span>
							</button></a> <a href="register.jsp"><button>
								<span class="material-icons">how_to_reg</span>
							</button></a>
					</div>
				</c:if>
				<!--  -->
			</div>

		</nav>


	</header>

	

	<main>

		<div class="featured-books" id="recentbooks">
			<div class="line2"></div>


			<div class="card-container">


				<!-- if books are there	 -->
				<c:if test="${!empty sessionScope.arrayList_all }">
					<c:forEach items="${sessionScope.arrayList_all}" var="list_all">

						<div class="book-card">
							<img src="./book_images/${list_all.getBook_image()}" class="waff">
							<h3>${list_all.getBook_name()}</h3>

							<div class="description">
								<p>
									<b> 
										<c:if test="${list_all.getBook_category() eq 'new'}">
											 Love, Romance, Drama
											</c:if> 
											<c:if test="${list_all.getBook_category() eq 'old'}">
												Suspense , Thriller
										</c:if> 
										<!-- Love, Romance, Drama -->
									</b>
								</p>
							</div>
							<div class="price">
								<b>RS ${list_all.getBook_price()}</b>
							</div>

							<c:if test="${!empty sessionScope.obj}">
								<c:if test="${sessionScope.name eq 'user'}">
									<a href="./admincontroller/cart?bid=${list_all.getBook_id()}"><Button
											class="btn">Add to Cart</Button></a>
								</c:if>

							</c:if>

							<c:if test="${empty sessionScope.obj}">
								<a href="login.jsp"><Button class="btn">Add to Cart</Button></a>
							</c:if>

						</div>

					</c:forEach>
				</c:if>

			</div>

		</div>




	</main>



</body>

</html>