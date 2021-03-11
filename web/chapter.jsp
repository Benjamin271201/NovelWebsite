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
            <a href="NovelServlet?a=read&n=${prevChap.novel.novelID}&c=${prevChap.chapterID}" class="changeChapter">Previous Chapter</a>
        </c:if>
        <c:if test="${nextChap != null}">
            <a href="NovelServlet?a=read&n=${nextChap.novel.novelID}&c=${nextChap.chapterID}" class="changeChapter">Next Chapter</a>
        </c:if>
            <div class="chapterList">
                <a href="NovelServlet?a=novel_info&n=${currNovel.novelID}">Back to chapters list</a>
            </div>
            <div id="commentSection">
                <h3>Comments</h3>
                <c:if test="${sessionScope.user != null}">
                    <div id="commentInput">
                    <form action="CommentServlet" method="POST">
                        Comment <textarea name="context"></textarea> <br>
                        <input type="hidden" name="chapterID" value="${currChap.chapterID}"/>
                        <input type="hidden" name="novelID" value="${currNovel.novelID}"/>
                        <input type="submit" value="Submit"/>
                    </form>
                </div>
                </c:if>
                <c:choose>
                    <c:when test="${comments.size() eq 0}">
                        <p>No comments</p>
                    </c:when>
                    <c:otherwise>
                        <table>
                            <thead>
                                <tr>
                                    <th>User</th>
                                    <th>Comment</th>
                                    <th>Upload date</th>
                                    <c:if test="${sessionScope.user.isAdmin == true}"><th>Action</th></c:if>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${comments}" var="comment">
                                    <tr>
                                        <td>${comment.user.username}</td>
                                        <td>${comment.context}</td>
                                        <td>${comment.commentDate}</td>
                                        <c:if test="${sessionScope.user.isAdmin == true}">
                                            <td><a href="CommentServlet?a=delete&cmid=${comment.commentID}&nid=${currNovel.novelID}&cid=${currChap.chapterID}">delete</a></td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:otherwise>
                </c:choose>
            </div>
    </body>
</html>
