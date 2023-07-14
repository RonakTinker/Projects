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
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Ruda|Quattrocento">
    <link rel="stylesheet" href="../css/myorder.css">
    <title>BOOK DETAILS</title>
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

            <div class="center">
                
                <h3>BOOK DETAILS</h3>

                
            </div>

            <div class="search-login">
                <div class="search">
                    
                </div>
                <div class="login-register">
                    <a href="admin_home.jsp"><button><span class="material-icons" >account_circle</span></button></a>
                    <a href="logout.jsp"><button><span class="material-icons">logout</span></button></a>
                </div>
            </div>

        </nav>


    </header>

    <main>

        <div class="orders">

            <div class="line2"></div>
            <div class="orders-details">

                <div class="orders-left">
                    <img src="../book_images/${admin_obj.getBook_image()}" alt="">
                    </div>
                <div class="orders-right">
                    <div>
                        <h2>Book Name </h2>
                        <span>${admin_obj.getBook_name()}</span>
                    </div>
                    <div>
                        <h2>Book ID </h2>
                        <span>#${admin_obj.getBook_id()}</span>
                    </div>
                    <div>
                        <h2>Book Author </h2>
                        <span>${admin_obj.getBook_author()}</span>
                    </div>
                    <div>
                        <h2>Book Price </h2>
                        <span>Rs ${admin_obj.getBook_price()}</span>
                    </div>
                    <div>
                        <h2>Book Category</h2>
                        <span>
                        <c:if test="${admin_obj.getBook_category() eq 'new'}">
                        	Love|Romance|Drama
                        </c:if>
                        <c:if test="${admin_obj.getBook_category() eq 'old'}">
                        	SUSPENSE|THRILLER
                        </c:if>
                        </span>
                    </div>

                </div>

           
            </div>

        </div>


    </main>