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
    <title>EDIT-PROFILE</title>
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

       <form action="./admincontroller/edit" method="post">
            <div class="Heading">
                <h2><b>EDIT PROFILE</b></h2>
            </div>
            <div class="form-css">
                <label for="N"><b>Name*</b></label>
                <input type="text" name='name' value='${sessionScope.obj.getName()}' id="N" >
            </div>
            <div class="form-css">
                <label for="E"><b>Email-ID*</b></label>
                <input type="text" name='email' value='${sessionScope.obj.getEmail()}' id="E" >
            </div>
            <div class="form-css">
                <label for="PH"><b>Phone Number*</b></label>
                <input type="text" name='phoneNo' value='${sessionScope.obj.getPhoneNo()}' id="PH">
            </div>
            <div class="form-css">
                <label for="P"><b>Password*</b></label>
                <input type="password" name='password' value='${sessionScope.obj.getPassword()}' id="P">
            </div>
            <div class="form-css">
                <label for="P"><b>Street Address</b></label>
                <input type="text" name='address' value='${sessionScope.obj.getAddress()}' id="P" placeholder="132 My Street">
            </div>
            <div class="form-css">
                <label for="P"><b>City</b></label>
                <input type="text" name='city' value='${sessionScope.obj.getCity()}' id="P" placeholder="Kingston">
            </div>
            <div class="form-css">
                <label for="P"><b>State</b></label>
                <input type="text" name='state' value='${sessionScope.obj.getState()}' id="P" placeholder="New York">
            </div>
            <div class="form-css">
                <label for="P"><b>Pin-code</b></label>
                <input type="number" name='pin' value='${sessionScope.obj.getPin()}' id="P" placeholder="Enter a 6 digit pin">
            </div>

            <div class="btn  check">
                <input type="submit" value=" Save Changes">
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