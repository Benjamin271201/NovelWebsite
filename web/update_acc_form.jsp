<%-- 
    Document   : update_acc_form
    Created on : 14-Mar-2021, 15:27:27
    Author     : chiuy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Update</title>
                <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
                <link rel="stylesheet" href="styles/index.css"/>
                <link rel ="stylesheet" href="styles/update_acc_form.css"/>
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
                                        <button class="login"><a href="LoginServlet" class="login-btn"><span>Login</span></a></button>
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
                <c:set var="user" value="${sessionScope.user}"/>
                <form action="ManageAccountServlet" method="POST" enctype="multipart/form-data" id="form">
                        <input type="hidden" name="a" value="update"/>
                        <fieldset>
                                <legend><h1>Update Info</h1></legend>
                                <div>
                                        <label>Username</label><br>
                                        <input type="text" name="username" value="${user.username}" id="username" class="input" readonly/>
                                </div>
                                <br>
                                <div>
                                        <label>Full name</label><br>
                                        <input type="text" name="name" value="${user.name}" class="input"  id="name"/>
                                </div>
                                <div id="nameMsg" style="visibility:hidden" class="error">
                                        Full name can not be empty
                                </div>
                                <div>
                                        <label>Email</label><br>
                                        <input type="text" name="email" value="${user.email}" class="input"  id="email" readonly/>
                                </div>
                                <br>
                                <div>
                                        <label>Password</label><br>
                                        <input type="password" name="password" class="input"  id="password" value="${user.password}"/>
                                </div>
                                <div id="passMsg" style="visibility:hidden" class="error">
                                        Password can only be of length 5 to 32 characters
                                </div>
                                <div>
                                        <label>Confirm password</label><br>
                                        <input type="password" name="conpass" class="input" id="confpassword" value=""/>
                                </div>
                                <div id="confpassMsg" style="visibility:hidden" class="error">
                                        Confirm password did not match
                                </div>
                                <div>
                                        <label>Avatar</label><br>
                                        <img src="${pageContext.request.contextPath}/images/avatars/${user.avatarURL}" id="avatar"/><br>
                                        <input type="file" name="avatar"/>
                                </div>
                                <div>
                                        <input type="submit" value="Update" id="submitBtn"/>
                                        <button type="button" id="cancel"><a href="NovelServlet">Cancel</a></button>
                                </div>
                        </fieldset>
                </form>
                <script src="js/script.js" defer></script>
        </body>
</html>
