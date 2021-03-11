<%-- 
    Document   : bookinfo
    Created on : Mar 4, 2021, 5:00:22 PM
    Author     : ASUS GAMING
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${novel.novelName}</title>
        <link rel="stylesheet" type="text/css" href="styles/index.css"> 
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    </head>
    <body>
        <div class="navbar">
                <img src="images/logo.svg" alt="Logo-unclickable" id="logo">
                <a class="home" href="NovelServlet">Home</a>
                <div class="dropdown">
                    <a class="drop-btn" href="#">Category <i class="fa fa-caret-down"></i></a>
                    <ul class="dropdown-content">
                        <div class=column id="col1">
                            <li><a class="tag" href="#">Tag 1</a></li>
                            <li><a class="tag" href="#">Tag 2</a></li>
                            <li><a class="tag" href="#">Tag 3</a></li>
                        </div>
                        <div class=column id="col2">
                            <li><a class="tag" href="#">Tag 4</a></li>
                            <li><a class="tag" href="#">Tag 5</a></li>
                            <li><a class="tag" href="#">Tag 6</a></li>
                        </div>
                        <div class=column id="col3">
                            <li><a class="tag" href="#">Tag 7</a></li>
                            <li><a class="tag" href="#">Tag 8</a></li>
                            <li><a class="tag" href="#">Tag 9</a></li>
                        </div>
                        <div class=column id="col4">
                            <li><a class="tag" href="#">Tag 10</a></li>
                            <li><a class="tag" href="#">Tag 11</a></li>
                            <li><a class="tag" href="#">Tag 12</a></li>
                        </div>
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
                                        <img src="images/default_avatar.png" alt="user's avatar" id="avatar">
                                        <ul class="user-dropdown">
                                            <li><a id="Manage" href="#">Manage Account</a></li>
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
                    Name: ${novel.novelName}<br>
                <img src="${pageContext.request.contextPath}/Covers/${novel.coverURL}" alt="Cover" id="cover"/><br>
                Author: ${novel.author.getName()}<br>
                Tags: 
                    <c:forEach items="${taglist}" var="tag">
                        ${tag.tagName}
                    </c:forEach> <br>
                Views: ${novel.viewCount}<br>        
                List of chapters: 
                    <c:forEach items="${chapterlist}" var="chapter">
                        <a href="NovelServlet?a=read&n=${chapter.novel.novelID}&c=${chapter.chapterID}">${chapter.chapterName}</a>
                    </c:forEach>
                <br>
            </section>
    </body>
</html>
