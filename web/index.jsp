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
                            <li><a id="Logout" href="LoginServlet?action=logout">Logout</a></li>
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
        <c:set var="user" value="${sessionScope.user}"></c:set>
            <div class="n-container">
            <c:if test="${tag != null}">
                <h1>Category: ${tag.tagName}</h1>
            </c:if>
            <c:if test="${novelListObj != null}">
                <ul class="n-list">
                    <c:forEach items="${novelListObj}" var="novel">
                        <li class="n-listitem">
                            <a href="NovelServlet?a=novel_info&n=${novel.novelID}"><img class="cover" src="${pageContext.request.contextPath}/images/covers/${novel.coverURL}"/></a>
                            <a class="n-title" href="NovelServlet?a=novel_info&n=${novel.novelID}">${novel.novelName}</a> 
                            <p>${novel.author.getUsername()}</p>
                            <c:if test="${addFlag != null}">
                                <a href="ChapterServlet?a=addchapform&nid=${novel.novelID}">Add a new Chapter</a>
                            </c:if>
                            <c:if test="${user.isAdmin == true || user.username.equals(novel.author.username)}">
                                <p><a href="NovelServlet?a=del&nid=${novel.novelID}" onclick="return confirm('This action will remove all chapters in this novel.\nAre you sure ?')">Delete</a></p>
                            </c:if>
                        </li>    
                    </c:forEach>
                </ul>
            </c:if>
            <%--if your novel list is empty--%>
            <c:if test="${NONOVELERROR != null}">
                <h2 style="color:red">${NONOVELERROR}</h2>
                <c:if test="${flag != null}">
                    <h1 style="text-align: center"><a href="NovelServlet?a=n_form" style="font-size: 250%; border: dashed 7px; line-height: 5; padding: 10%;">Add novel here</a></h1>
                </c:if>
            </c:if>
            <%--if bookmark list is empty--%>
            <c:if test="${EMPTYBOOKMARK != null}">
                <h2 style="color:red">${EMPTYBOOKMARK}</h2>
            </c:if>
        </div>
        <c:choose>
            <c:when test="${user != null}">
                <div class="side-box">
                    <a href="NovelServlet?a=n_form">Add a novel</a><br>
                    <a href="NovelServlet?a=display&u=${user.username}">Your novels</a><br>
                    <a href="BookmarkServlet?a=bookmark_list">Bookmark</a><br>
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
    </body>
</html>
