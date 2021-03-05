<%-- 
    Document   : newjsp
    Created on : 04-Mar-2021, 13:25:13
    Author     : chiuy
--%>
<%@page import="dtos.Account"%>
<%@page import="daos.NovelDAO"%>
<%@page import="dtos.Novel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        String activeUser = (String) session.getAttribute("username");
    %>
    <body>
        <%
            if(activeUser != null){
        %>
        <h1>Hello <%=activeUser%></h1>
        <%}%>
        <%
            ArrayList<Novel> novelList = new ArrayList<>();
            novelList = (ArrayList<Novel>) request.getAttribute("novelListObj");
            for (Novel elem : novelList) {%>
                <a href="NovelServlet?a=novel_info&n=<%= elem.getNovelID() %>"><%= elem.getNovelName() %></a><p><%=elem.getAuthor().getUsername()%></p>
                <%}
            %>
            <a href="LoginServlet">Log in</a>
    </body>
</html>
