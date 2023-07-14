<%@ page language="java"%>

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


	<header id="home">
		<nav class="navbar" id="home">

			<div class="logo">
				<img src="./other_images/logo.png" alt=""> <a href="index.jsp"
					class="bookbuddy">BOOKBUDDY</a>
			</div>

			<div class="center">

				<a href="#recentbooks" class="hover1">Recent books</a> <a
					href="#newbooks" class="hover2">Love|Romance|Drama</a> <a
					href="#oldbooks" class="hover3">Suspense|Thriller</a>
			</div>

			<div class="search-login">
				<div class="search">
					<input type="text" placeholder="Search your book here"
						class="searchbar"> <span class="material-icons">search</span>
				</div>

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

			</div>

		</nav>


	</header>

	<!-- including the logic of showing the books dynamically -->
	<c:import url="/admincontroller/" />

	<main>

		<div class="quote">
			<img src="./other_images/about.png" alt="">
			<div class="quote-content">
				<h1 class="craving">
					<b>"The more that you read, the more things you will know. The
						more that you learn, the more places you'll go."</b>
				</h1>
			</div>
		</div>

		<!-- featured books section -->
		<div class="featured-books" id="recentbooks">

			<h1>RECENT BOOKS</h1>
			<div class="line1"></div>
			<div class="card-container">
				<!--  -->
				<!-- if no books are there -->
				<c:if test="${empty sessionScope.arrayList_recent}">
					<h2 style="color: wheat;">${sessionScope.message1}</h2>
				</c:if>

				<!-- if books are there	 -->
				<c:if test="${!empty sessionScope.arrayList_recent }">
					<c:forEach items="${sessionScope.arrayList_recent}"
						var="list_recent">
						<div class="book-card">
							<img src="./book_images/${list_recent.getBook_image()}"
								class="waff">
							<h3>${list_recent.getBook_name()}</h3>
							<div class="description">
								<p>
									<b> <c:if test="${list_recent.getBook_category() eq 'new'}">
											 Love, Romance, Drama
										</c:if> <c:if test="${list_recent.getBook_category() eq 'old'}">
												Suspense , Thriller
										</c:if> <!-- Love, Romance, Drama -->
									</b>
								</p>
							</div>
							<div class="price">
								<b>RS ${list_recent.getBook_price()}</b>
							</div>

							<c:if test="${!empty sessionScope.obj}">
								<c:if test="${sessionScope.name eq 'user'}">
									<a
										href="./admincontroller/cart?bid=${list_recent.getBook_id()}"><Button
											class="btn">Add to Cart</Button></a>
								</c:if>

							</c:if>

							<c:if test="${empty sessionScope.obj}">
								<a href="login.jsp"><Button class="btn">Add to Cart</Button></a>
							</c:if>
						</div>

					</c:forEach>
				</c:if>
				
		<!--  -->

		</div>
			<c:if test="${!empty sessionScope.arrayList_recent }">
				<a href="./all_books.jsp" class="clicktoviewallbooks"><h4>Click to view all books</h4></a>
			</c:if>
			
		</div> 


		<!-- LOVE | ROMANCE | DRAMA books section -->
		<div class="featured-books" id="newbooks">

			<h1>LOVE | ROMANCE | DRAMA</h1>
			<div class="line1"></div>
			<div class="card-container">

				<c:if test="${empty sessionScope.arrayList}">
					<h2 style="color: wheat;">${sessionScope.message1}</h2>
				</c:if>

				<!--  -->
				<c:if test="${!empty sessionScope.arrayList }">
					<c:forEach items="${sessionScope.arrayList}" var="list_new">
						<div class="book-card">
							<img src="./book_images/${list_new.getBook_image()}" class="waff">
							<h3>${list_new.getBook_name()}</h3>
							<div class="description">
								<p>
									<b>Love, Romance, Drama</b>
								</p>
							</div>
							<div class="price">
								<b>RS ${list_new.getBook_price()}</b>
							</div>

							<c:if test="${!empty sessionScope.obj}">
								<c:if test="${sessionScope.name eq 'user'}">
									<a href="./admincontroller/cart?bid=${list_new.getBook_id()}"><Button
											class="btn">Add to Cart</Button></a>
								</c:if>

							</c:if>

							<c:if test="${empty sessionScope.obj}">
								<a href="login.jsp"><Button class="btn">Add to Cart</Button></a>
							</c:if>

						</div>
					</c:forEach>
				</c:if>
				<!--  -->
			</div>
		</div>


		<!-- SUSPENSE | THRILLER books section -->
		<div class="featured-books" id="oldbooks">

			<h1>SUSPENSE | THRILLER</h1>
			<div class="line1"></div>
			<div class="card-container">

				<c:if test="${empty sessionScope.arrayList_old}">
					<h2 style="color: wheat;">${sessionScope.message1}</h2>
				</c:if>

				<!--  -->
				<c:if test="${!empty sessionScope.arrayList_old }">
					<c:forEach items="${sessionScope.arrayList_old}" var="list_old">
						<div class="book-card">
							<img src="./book_images/${list_old.getBook_image()}" class="waff">
							<h3>${list_old.getBook_name()}</h3>
							<div class="description">
								<p>
									<b>Suspense , Thriller</b>
								</p>
							</div>
							<div class="price">
								<b>RS ${list_old.getBook_price()}</b>

							</div>

							<c:if test="${!empty sessionScope.obj}">
								<c:if test="${sessionScope.name eq 'user'}">
									<a href="./admincontroller/cart?bid=${list_old.getBook_id()}"><Button
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

	<footer>

		<div class="footer-left">
			<button>About Us</button>
			<button>Careers</button>
			<button>Blogs</button>
			<button>Publishers</button>
			<button>Connect With Us</button>
		</div>

		<div class="footer-right">
			<img src="./other_images/google.PNG" alt=""> <img
				src="./other_images/apple.PNG" alt="">
		</div>

	</footer>

</body>

</html>