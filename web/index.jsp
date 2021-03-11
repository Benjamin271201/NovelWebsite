<%-- 
    Document   : newjsp
    Created on : 04-Mar-2021, 13:25:13
    Author     : chiuy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novel List</title>
        <link rel="stylesheet" type="text/css" href="styles/index.css"> 
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    </head>
    <body>
            <ul class="container" id="nav-bar">
            <li>
                <a href="NovelServlet " class="avatar"><img src="images/avatar.svg" alt="Click here to go back to main page" width="75px" height="40px" title="Novel List"></a>
            </li>
            <li>
                <small class="avatar">Novel List</small>
            </li>
            <li>
                <small class="dropdown-toggle">Category</small>
            </li>
            <li>
                <small>
                        <form id="form-search" action="search" method="post">
                            <input type="search" placeholder="Quick search" id="search-bar">
                            <button type="submit" id="submit-srch" name="submit-srch"><i class="fas fa-search"></i></button>    
                        </form>
                </small>
            </li>
            <c:choose>
                <c:when test="${sessionScope.user == null}">
                    <li style="float:right">
                        <button><a href="login_form.jsp" id="login-btn">Login</a></button>
                    </li>
                </c:when>
                <c:otherwise>
                    <li style="float:right">
                        <button><a href="#" id="login-btn">Logged in!</a></button>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>   
        <c:set var="user" value="${sessionScope.user}"></c:set>
        <c:if test="${user != null}">
            <h1>Hello ${user.name}</h1>
            <a href="NovelServlet?a=addNovelForm">Add a novel</a><br>
        </c:if>
        <c:forEach items="${novelListObj}" var="novel">
            <a href="NovelServlet?a=novel_info&n=${novel.novelID}">${novel.novelName}</a><p>${novel.author.getUsername()}</p>
        </c:forEach>
    </body>
</html>
