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
    <link rel="stylesheet" href="../css/all-css.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Ruda|Quattrocento">
    <title>UPDATE-BOOK</title>
</head>

<body>

    <!-- if admin has not logged in then he will be redirected to login page -->
	<c:if test="${empty obj}">
		<c:redirect url="../login.jsp" />
	</c:if>

    <header>
        <nav class="navbar">

            <div class="logo">
                <img src="../other_images/logo.png" alt="">
                <a href="../index.jsp" class="bookbuddy">BOOKBUDDY</a>
            </div>

            <div class="center"></div>

            <div class="search-login">

                <div class="login-register">
                    <a  href="admin_home.jsp"><button><span class="material-icons">account_circle</span></button></a>
                     <a  href="logout.jsp"><button><span class="material-icons">logout</span></button></a>
                </div>
            </div>

        </nav>


    </header>

    <main>

        <div>
            <img src="../other_images/left.png" alt="" class="wing">
        </div>

        <form action="../admincontroller/updateBook" method="GET">
            <div class="Heading">
                <h2><b>BOOK TO UPDATE</b></h2>
            </div>
            <div class="form-css">
                <label for="B"><b>Book ID</b></label>
                <input type="number" name='id' id="B" placeholder="Enter a positive value">
            </div>
            <div class="btn  check">
                <input type="submit" value="Get me to this book" >
                <!-- showing the failure msg if search operation fails -->
                <span class="material-icons">${sessionScope.message}</span>
				<c:remove var="message" scope="session" />
				<!--  -->
            </div>
        </form>

        <div>
            <img src="../other_images/right.png" alt="" class="wing">
        </div>

    </main>

</body>

</html>