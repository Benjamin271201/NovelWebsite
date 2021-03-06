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
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="user" value="${sessionScope.user}"></c:set>
        <c:if test="${user != null}">
            <h1>Hello ${user.name}</h1>
        </c:if>
        <c:forEach items="${novelListObj}" var="novel">
        <a href="NovelServlet?a=novel_info&n=${novel.novelID}">${novel.novelName}</a><p>${novel.author.getUsername()}</p>
        </c:forEach>
            <c:choose>
                <c:when test="${user!=null}">
                <a href="LoginServlet?action=logout">Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="LoginServlet">Login</a>
                </c:otherwise>
            </c:choose>
    </body>
</html>
