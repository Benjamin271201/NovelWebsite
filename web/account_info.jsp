<%-- 
    Document   : account_info
    Created on : 14-Mar-2021, 14:09:18
    Author     : chiuy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Info</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="styles/index.css"> 
    </head>
    <body>
        <div class="navbar">
            <img src="images/logo.svg" alt="Logo-unclickable" id="logo">
            <a class="home" href="NovelServlet">Home</a>
            <div class="dropdown">
                <a class="drop-btn" href="#">Category <i class="fa fa-caret-down"></i></a>
                    <c:set var="begin" value="0"/>
                    <c:set var="end" value="5"/>
                <ul class="dropdown-content">
                    <c:out value="${tagList}" />
                    <c:forEach begin="0" end="4">
                        <div class=column>
                            <c:forEach items="${applicationScope.tagListObj}" var="tag" begin="${begin}" end="${end}">
                                <li><a class="tag" href="NovelServlet?a=searchtag&id=${tag.tagID}"><c:out value="${tag.getTagName()}"/></a></li>
                                </c:forEach>
                        </div>
                        <c:set var="begin" value="${begin+7}"/>
                        <c:set var="end" value="${end+7}"/>
                    </c:forEach>
                </ul>
            </div>
            <c:choose>
                <c:when test="${sessionScope.user == null}">
                    <div class="login">
                        <button><a href="LoginServlet" class="login-btn">Login</a></button>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="user-mng">
                        <img src="${pageContext.request.contextPath}/images/avatars/${sessionScope.user.avatarURL}" alt="user" id="avatar">
                        <ul class="user-dropdown">
                            <li><a id="Manage" href="ManageAccountServlet">Manage Account</a></li>
                            <li><a id="Logout" href="LoginServlet?action=logout" onclick="return confirm('Do you want to logout ?')">Logout</a></li>
                        </ul>
                    </div>
                </c:otherwise>
            </c:choose>
            <div class="search-container">
                <form action="NovelServlet" method="post">
                    <input type="hidden" name="a" value="searchname"/>
                    <input type="text" placeholder="Search.." id="search-bar" name="nameSearch">
                    <button id="search-btn" type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
        </div>
        <section class="body-text">
            <c:set var="user" value="${sessionScope.user}"/>
            <h1>Account Information</h1>
            <table>
                <tr>
                    <th>Profile picture: </th>
                    <td><img src="${pageContext.request.contextPath}/images/avatars/${user.avatarURL}" id="avatar"/></td>
                </tr>
                <tr>
                    <th>Username: </th>
                    <td>${user.username}</td>
                </tr>
                <tr>
                    <th>Name: </th>
                    <td>${user.name}</td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td>${user.email}</td>
                </tr>
                <tr>
                    <td>
                        <button><a href="ManageAccountServlet?a=updateaccform">Change account's information</a></button>
                    </td>
                </tr>
            </table>
        </section>
    </body>
</html>
