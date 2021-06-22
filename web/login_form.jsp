<%-- 
    Document   : login_form
    Created on : 04-Mar-2021, 18:01:59
    Author     : chiuy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
        <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Login Form</title>
                <link rel="stylesheet" type="text/css" href="styles/login.css"> 
        </head>
        <body>
                <div id="container" class="modal">      
                        <form class="modal-content animate" action="LoginServlet" method="post">
                                <input type="hidden" name="action" value="login">
                                <c:choose>
                                        <c:when test="${success == null}">
                                                <p></p>
                                        </c:when>
                                        <c:otherwise>
                                                <c:if test="${success == false}">
                                                        <p class="alert">Username or password is incorrect</p>
                                                </c:if>
                                        </c:otherwise>
                                </c:choose>
                                <h1 class="modal-title">Login Form</h1>
                                <div class="container">
                                        <label for="username"><b>Username</b></label>
                                        <input type="text" placeholder="Username" name="username" <c:if test="${username != null}">value="${username}" </c:if> required>

                                        <label for="password"><b>Password</b></label>
                                        <input type="password" placeholder="Password" name="password" required>

                                        <button type="submit">Login</button>
                                </div>
                                <div class="footer">
                                        <span class="psw">Not registered? <a href="RegisterServlet">Create an account</a></span>
                                        <a class="goback" style="display: block;" href="NovelServlet"><b>&laquo; Click here to go back</b></a>
                                </div>
                        </form>
                </div>
        </body>
</html>
