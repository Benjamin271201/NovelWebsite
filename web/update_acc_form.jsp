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
        <link rel="stylesheet" href="styles/index.css"/>
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
                <table>
                    <tr>
                        <th>Username</th>
                        <td><input type='text' value='${user.username}' name='username' readonly id="username"/></td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <td><input type='text' value='${user.name}' name='name' id="name"/></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><input type='text' value='${user.email}' name='email' readonly id="email"</td>
                    </tr>
                    <tr>
                        <th>Password</th>
                        <td><input type='password' value='${user.password}' name='password' id="password"/></td>
                    </tr>
                    <tr id="passMsg" style="display:none">
                        <td>Password can only be of length 5 to 32 characters</td>
                    </tr>
                    <tr>
                        <th>Confirm password</th>
                        <td><input type="password" name="conpass" id="confpassword" value="${user.password}"/></td>
                    </tr>
                    <tr id="confpassMsg" style="display:none">
                        <td>Confirm password did not match</td>
                    </tr>
                    <tr>
                        <th>Profile Picture</th>
                        <td><img src="${pageContext.request.contextPath}/images/avatars/${user.avatarURL}" style="height: 50px; width: 50px;  border-radius: 50%; margin-top: 5px;"/><input type="file" name="avatar"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Update"/></td>
                    </tr>
                </table>
            </form>
        </section>
        <script src="js/script.js" defer></script>
    </body>
</html>
