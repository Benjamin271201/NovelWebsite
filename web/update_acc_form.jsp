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
        <link rel ="stylesheet" href="styles/register.css"/>
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
            <c:set var="user" value="${sessionScope.user}"/>
            <form action="ManageAccountServlet" method="POST" enctype="multipart/form-data" id="form">
                <input type="hidden" name="a" value="update"/>
                <fieldset>
                    <legend><h1>Update Info</h1></legend>
                <div>
                    <label>Username</label><br>
                    <input type="text" name="username" value="${user.username}" id="username" readonly/>
                </div>
                 <br>
                <div>
                    <label>Full name</label><br>
                    <input type="text" name="name" value="${user.name}" id="name"/>
                </div>
                <div id="nameMsg" style="visibility:hidden" class="error">
                        Full name can not be empty
                </div>
                <div>
                    <label>Email</label><br>
                    <input type="text" name="email" value="${user.email}" id="email" readonly/>
                </div>
                     <br>
                <div>
                    <label>Password</label><br>
                    <input type="password" name="password" id="password" value="${user.password}"/>
                </div>
                <div id="passMsg" style="visibility:hidden" class="error">
                    Password can only be of length 5 to 32 characters
                </div>
                <div>
                    <label>Confirm password</label><br>
                    <input type="password" name="conpass" id="confpassword" value=""/>
                </div>
                <div id="confpassMsg" style="visibility:hidden" class="error">
                    Confirm password did not match
                </div>
                <div>
                    <label>Avatar</label>
                    <img src="${pageContext.request.contextPath}/images/avatars/${user.avatarURL}" id="avatar" style="margin:0"/>
                    <input type="file" name="avatar"/>
                </div>
                <div>
                    <input type="submit" value="Update" id="submitBtn"/>
                    <button type="button"><a href="NovelServlet">Cancel</a></button>
                </div>
            </fieldset>
            </form>
        </section>
        <script src="js/script.js" defer></script>
    </body>
</html>
