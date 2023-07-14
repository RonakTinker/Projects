<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"  %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/admin.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Ruda|Quattrocento">
    <title>USER-SETTINGS</title>
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

            <div class="center"> </div>

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
            <h1 class="welcome">
				Welcome, ${sessionScope.obj.getName()}
            </h1>
            <div class="line1"></div>

            <div class="cards-container-2">
                <div class="cards">
                    <img src="./other_images/bookimage.jpg" alt="">
                    <button><a href="sell_old_book.jsp" class="cards-anchor">SELL A BOOK</a></button>
                </div>
                <div class="cards">
                    <img src="./other_images/editprofile.jpg" alt="">
                    <button><a href="edit_profile.jsp" class="cards-anchor">EDIT PROFILE</a></button>
                </div>
                <div class="cards">
                    <img src="./other_images/orders.jpeg" alt="">
                    <button><a href="my_orders.jsp" class="cards-anchor">MY ORDERS</a></button>
                </div>

            </div>
        </div>


    </main>


</body>

</html>