<%-- 
    Document   : insertNovelForm
    Created on : 11-Mar-2021, 13:44:47
    Author     : chiuy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Novel</title>
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
                <form action="search" method="post">
                    <input type="hidden" name="a" value="searchname"/>
                    <input type="text" placeholder="Search.." id="search-bar">
                    <button id="search-btn" type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
        </div>
        <section id="body-text" style="margin-top: 6%">
         
            <form action="NovelServlet" enctype="multipart/form-data" method="POST" id='form'>
                <input type="hidden" value="n_add" name="a">
                <fieldset>
                    <legend><h1>Add a novel</h1></legend>
                    <div>
                        <p>Novel name</p>
                        <p><input type="text" name="novelName" id='novelName'/> <label style="visibility: hidden; color: red" id='msg'>Novel name can't be empty</label></p>
                    </div>
                    <div>
                        <p>Cover</p>
                        <p><input type="file" name="coverURL" id="coverURL"/></p>
                    </div>
                    <div>
                        <p><input type="submit" value="Add"/> <button><a href="NovelServlet" style="text-decoration: none; color: black"/>Cancel</a></button></p>
                    </div>
                </fieldset>
            </form>
        </section>
                    <script defer>
                        const form = document.getElementById("form");
                        const novelName = document.getElementById("novelName");
                        const msg = document.getElementById("msg");
                        form.addEventListener('submit', event=>{
                            if(novelName.value === ""){
                                event.preventDefault();
                                msg.style.visibility = "visible";
                            }
                        });
                    </script>
    </body>
</html>
