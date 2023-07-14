
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
    <link rel="stylesheet" href="../css/admin.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Ruda|Quattrocento">
    <title>LOGOUT</title>
</head>

<body>

    <!-- checking if the user is logged in or not -->
	<c:if test="${empty obj}">
		<c:redirect url="login.jsp"/>
	</c:if>

    <header>
        <nav class="navbar">

            <div class="logo">
                <img src="../other_images/logo.png" alt="">
                <span><a href="../index.jsp" class="bookbuddy">BOOKBUDDY</a></span>
            </div>

            <div class="center"></div>

            <div class="search-login">
                <div class="login-register">
                    <a href="../settings.jsp"><button><span class="material-icons">account_circle</span></button></a>
                     <a href="logout.jsp"><button><span class="material-icons">logout</span></button></a>
                </div>
            </div>

        </nav>


    </header>



    <main>

        <div class="user-cards">

            <div class="line2"></div>
            <h1 class="logout">Do you want to logout ?</h1>

            <div class="shopping ">

                <div>
                    <a href="../admincontroller/logout" class="continue">
                        <h2 class="continue">Logout</h2>
                    </a>
                </div>

                <div>
                    <a href="../index.jsp" class="continue">
                        <h2 class="continue">Close</h2>
                    </a>
                </div>

            </div>

        </div>


    </main>


</body>

</html>