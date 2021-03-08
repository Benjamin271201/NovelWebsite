<%-- 
    Document   : chapter
    Created on : 07-Mar-2021, 15:04:40
    Author     : chiuy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${currNovel.novelName} - ${currChap.chapterName}</title>
        <link rel="stylesheet" type="text/css" href="styles/index.css"> 
    </head>
    <body>
        <div id="content">
            <c:forEach items="${chapLines}" var="line">
                ${line} <br>
            </c:forEach>
        </div>
        <c:if test="${prevChap != null}">
            <a href="NovelServlet?a=read&n=${prevChap.novelID}&c=${prevChap.chapterID}" class="changeChapter">Previous Chapter</a>
        </c:if>
        <c:if test="${nextChap != null}">
            <a href="NovelServlet?a=read&n=${nextChap.novelID}&c=${nextChap.chapterID}" class="changeChapter">Next Chapter</a>
        </c:if>
            <div class="chapterList">
                <a href="NovelServlet?a=novel_info&n=${currNovel.novelID}">Back to chapters list</a>
            </div>
    </body>
</html>
