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
    <link rel="stylesheet" href="./css/all-css.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Ruda|Quattrocento">
    <title>SELL-BOOK</title>
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
                <span><a href="./index.jsp" class="bookbuddy">BOOKBUDDY</a></span>
            </div>

            <div class="center"></div>

            <div class="search-login">
                <div class="login-register">
                    <a href="settings.jsp"><button><span class="material-icons">account_circle</span></button></a>
                     <a href="./admin/logout.jsp"><button><span class="material-icons">logout</span></button></a>
                </div>
            </div>

        </nav>


    </header>

    <main>

        <div>
            <img src="./other_images/left.png" alt="" class="wing">
        </div>

        <form action="./admincontroller/sellBook" method="post">
            <div class="Heading">
                <h2><b>SELL  BOOK</b></h2>
            </div>
            <div class="form-css">
                <label for="N"><b>Book Name*</b></label>
                <input type="text" name='bookName' id="N" placeholder="A day in life of a reader">
            </div>
            <div class="form-css">
                <label for="E"><b>Author Name*</b></label>
                <input type="text" name='authorName' id="E" placeholder="Jhon Doe">
            </div>
            <div class="form-css">
                <label for="PH"><b>Book Price*</b></label>
                <input type="number" name='price' id="PH" placeholder="Enter a positive value">
            </div>
            
            <!--  -->
            <div class="form-css bookprice">
                <label for=""><b>Book Category*</b></label>
                <select name="category">
                <option value="noselect">--No-select--</option>
                    <option value="new">Love|Romance|Drama</option>
                    <option value="old">Suspense|Thriller</option>
                </select>
            </div>
            <!--  -->
            <div class="form-css">
                <label for="BI"><b>Select a book Image* </b></label>
                <input type="file"  name='image' id="BI" value="Choose a file">
            </div>

            <div class="btn  check">
                <input type="submit" value=" Click to Sell">
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