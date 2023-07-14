<%@ page language="java"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/admin.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Ruda|Quattrocento">
    <title>Thank You</title>
</head>

<body>

	 <!-- checking if the user is logged in or not -->
	<c:if test="${empty obj}">
		<c:redirect url="login.jsp"/>
	</c:if>

    <header>
        <nav class="navbar">

            <div class="logo">
                <img src="./other_images/logo.png" alt="">
                <a href="./index.jsp" class="bookbuddy">BOOKBUDDY</a>
            </div>

            <div class="center">
                <a href="index.jsp" class="hover">Home</a>
                <a href="my_orders.jsp" class="hover1">All orders</a>
                <a href="cart.jsp" class="hover2">Shopping cart</a>
                <a href="all_books.jsp" class="hover3">All books</a>
            </div>

            <div class="search-login">

                <div class="login-register">
                    <a href="settings.jsp"><button><span class="material-icons">account_circle</span></button></a>
                    <a href="./admin/logout.jsp"><button><span class="material-icons">logout</span></button></a>
                </div>
            </div>

        </nav>


    </header>



    <main>

        <div class="user-cards">

            <div class="line2"></div>
            <h1 class="logout">Thanks for Ordering..</h1>
            <img src="./gif/emoji-celebration.gif" class="emoji">

            

        </div>


    </main>


</body>

</html>