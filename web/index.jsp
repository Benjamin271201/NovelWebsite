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
                                                        <c:forEach items="${tagListObj}" var="tag" begin="${begin}" end="${end}">
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
                                                <button><a href="login_form.jsp" class="login-btn">Login</a></button>
                                        </div>
                                </c:when>
                                <c:otherwise>
                                        <div class="user-mng">
                                                <img src="${pageContext.request.contextPath}/images/avatars/${sessionScope.user.avatarURL}" alt="user" id="avatar">
                                                <ul class="user-dropdown">
                                                        <li><a id="Manage" href="ManageAccountServlet">Manage Account</a></li>
                                                        <li><a id="Logout" href="LoginServlet?action=logout">Logout</a></li>
                                                </ul>
                                        </div>
                                </c:otherwise>
                        </c:choose>
                        <div class="search-container">
                                <form action="search" method="post">
                                        <input type="text" placeholder="Search.." id="search-bar">
                                        <button id="search-btn"><i class="fa fa-search"></i></button>
                                </form>
                        </div>
                </div>
                <section class="body-text">
                        <c:set var="user" value="${sessionScope.user}"></c:set>
                        <c:choose>
                                <c:when test="${user != null}">
                                        <div class="side-box">
                                                <a href="NovelServlet?a=n_form">Add a novel</a><br>
                                                <a href="NovelServlet?a=display&u=${user.username}">Your novels</a><br>
                                                <a href="NovelServlet?a=bookmarked">Bookmark</a><br>
                                        </div>
                                </c:when>
                                <c:otherwise>
                                        <div class="side-box">
                                                <a href="LoginServlet">Add a novel</a><br>
                                                <a href="LoginServlet">Your novels</a><br>
                                                <a href="LoginServlet">Bookmark</a><br>
                                        </div>
                                </c:otherwise> 
                        </c:choose>
                        <div class="n-container">
                                <ul class="n-list">
                                        <c:forEach items="${novelListObj}" var="novel">
                                                <li class="n-listitem">
                                                        <a class="n-title" href="NovelServlet?a=novel_info&n=${novel.novelID}">${novel.novelName}</a>
                                                        <p>${novel.author.getUsername()}</p>
                                                </li>    
                                        </c:forEach>
                                </ul>
                        </div>
                </section>
        </body>
</html>
