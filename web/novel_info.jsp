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
    </head>
    <body>
        Name: ${novel.novelName}<br>
        Author: ${novel.author.getName()}<br>
        Tags: 
            <c:forEach items="${taglist}" var="tag">
                ${tag.tagName}
            </c:forEach> <br>
        Views: ${novel.viewCount}<br>        
        List of chapters: 
            <c:forEach items="${chapterlist}" var="chapter">
                <a href="NovelServlet?a=read&n=${chapter.novelID}&c=${chapter.chapterID}">${chapter.chapterName}</a>
            </c:forEach>
        <br>
    </body>
</html>
