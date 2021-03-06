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
        <form action="RegisterServlet" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <th>Username</th>
                    <td><input type="text" name="username" value="${username}"/></td>
                </tr>
                <tr>
                    <th>Full name</th>
                    <td><input type="text" name="name" value="${name}"/></td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td><input type="email" name="email" value="${email}"/></td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td><input type="password" name="password" value=""/></td>
                </tr>
                <tr>
                    <th>Confirm password</th>
                    <td><input type="password" name="conpass" value=""/></td>
                </tr>
                <tr>
                    <th>Avatar</th>
                    <td><input type="file" name="avatar" value="${avatar}"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="action" value="register"/></td>
                    <td><button type="button"><a href="NovelServlet">Cancel</a></button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
