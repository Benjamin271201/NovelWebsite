<%-- 
    Document   : bookinfo
    Created on : Mar 4, 2021, 5:00:22 PM
    Author     : ASUS GAMING
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${novel.novelName}</title>
        <link rel="stylesheet" type="text/css" href="styles/index.css"> 
        <link rel="stylesheet" type="text/css" href="styles/novel_info.css">
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
                        <button class="login-btn"><a href="LoginServlet">Login</a></button>
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
                <form action="search" method="post">
                    <input type="hidden" name="a" value="searchname"/>
                    <input type="text" placeholder="Search.." id="search-bar">
                    <button id="search-btn" type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
        </div>

        <%-- bookmark button
            if visitor -> Bookmark(grey)
            if user hasn't bookmarked ? Bookmark(grey) : Bookmarked(green) --%>
        <div class="container">
            <h2 class="header">
                <span class="fas fa-book fa-fw"></span>
                <span>Name: ${novel.novelName}</span>
            </h2> 
            <div class="left-side">
                <img class="cover" src="${pageContext.request.contextPath}/images/covers/${novel.coverURL}" alt="Cover" id="cover"/>
            </div>
            <div class="right-side">
                <div class="content-row" id="author">
                    <b>Author:</b> ${novel.author.name}
                </div>
                <div class="content-row" id="tags">
                    <b>Tags:</b> 
                    <c:forEach items="${taglist}" var="tag">
                        <a class="tag-item"  href="NovelServlet?a=searchtag&id=${tag.tagID}">${tag.tagName}</a>
                    </c:forEach>
                </div>
                <div class="content-row" id="bookmark">
                    <c:choose>
                        <c:when test="${sessionScope.user == null}"><a href='LoginServlet'><button>Bookmark</button></a><br></c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${!requestScope.bookmark}">
                                    <a href='BookmarkServlet?id=${novel.novelID}'><button>Bookmark</button></a><br>
                                </c:when>
                                <c:otherwise>
                                    <a href='BookmarkServlet?id=${novel.novelID}'><button style="background-color: #90DFAA">Bookmarked</button></a><br>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>            
                    </c:choose>
                </div>
                <div id="chap-list">
                    <div><h3>List of chapters: </h3></div>
                    <c:forEach items="${chapterlist}" var="chapter">
                        <div class="chapter-item">
                            <a class="chapName" href="NovelServlet?a=read&n=${chapter.novel.novelID}&c=${chapter.chapterID}">${chapter.chapterName}</a>
                            <c:if test="${sessionScope.user.username.equals(novel.author.username) || sessionScope.user.isAdmin==true}">
                                <a class="action" href="ChapterServlet?a=del&cid=${chapter.chapterID}&nid=${chapter.novel.novelID}" onclick="return confirm('Are you sure ?')">Delete</a>
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
