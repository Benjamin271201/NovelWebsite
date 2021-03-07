<%-- 
    Document   : register_form
    Created on : 04-Mar-2021, 17:28:14
    Author     : chiuy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${duplicatedUser != null}">
            <p>This username already exists</p>
        </c:if>
            <form action="RegisterServlet" method="POST" enctype="multipart/form-data" id="form">
            <table>
                <tr>
                    <th>Username</th>
                    <td><input type="text" name="username" value="${username}" id="username"/></td>
                </tr>
                <tr id="usernameMsg" style="display:none">
                    <td>Username can only be of length 4 to 20 characters</td>
                </tr>
                <tr>
                    <th>Full name</th>
                    <td><input type="text" name="name" value="${name}" id="name"/></td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td><input type="email" name="email" value="${email}" id="email"/></td>
                </tr>
                <c:if test="${duplicatedEmail != null}">
                    <tr id="duplicatedEmailMsg">
                        <td>This email address has already been used</td>
                    </tr>
                </c:if>
                <tr id="emailMsg" style="display:none">
                    <td>Invalid Email</td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td><input type="password" name="password" id="password"/></td>
                </tr>
                <tr id="passMsg" style="display:none">
                    <td>Password can only be of length 5 to 32 characters</td>
                </tr>
                <tr>
                    <th>Confirm password</th>
                    <td><input type="password" name="conpass" id="confpassword"/></td>
                </tr>
                <tr id="confpassMsg" style="display:none">
                    <td>Confirm password did not match</td>
                </tr>
                <tr>
                    <th>Avatar</th>
                    <td><input type="file" name="avatar" value="${avatar}" id="avatar"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="action" value="register" id="submitBtn"/></td>
                    <td><button type="button"><a href="NovelServlet">Cancel</a></button></td>
                </tr>
            </table>
        </form>
        <script src="js/script.js" defer></script>
    </body>
</html>
