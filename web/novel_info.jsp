<%-- 
    Document   : bookinfo
    Created on : Mar 4, 2021, 5:00:22 PM
    Author     : ASUS GAMING
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dtos.Tag"%>
<%@page import="dtos.Novel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% 
            Novel novel = (Novel) request.getAttribute("novel");
            ArrayList<Tag> tagList = (ArrayList<Tag>) request.getAttribute("taglist");
            System.out.println(tagList);
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= novel.getNovelName() %></title>
    </head>
    <body>
        Name: <%= novel.getNovelName() %><br>
        Author: <%= novel.getAuthor().getName()%><br>
        Tags: 
        <% for (Tag tag:tagList) {%>
            <%= tag.getTagName()%>  
        <%}%><br>
        Views: <%= novel.getViewCount()%><br>
        Upload date: <%= novel.getUploadDate()%><br>
    </body>
</html>
