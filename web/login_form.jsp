<%-- 
    Document   : login_form
    Created on : 04-Mar-2021, 18:01:59
    Author     : chiuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
       <% 
            if(request.getAttribute("success") == null) {
       %>
       <p></p>
       <%}
        else{
                boolean success =(boolean) request.getAttribute("success");
                if(success == false){ %>
       <p>username or password is invalid</p>
       <%}}%>
       
        <form action="LoginServlet" name="f1" method="POST">
            <table>
                <tr>
                    <th>Username</th>
                    <td><input type="text" name="username" value=""/></td>
                </tr>
                 <tr>
                    <th>Password</th>
                    <td><input type="password" name="password" value=""/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="action" value="login"/></td>
                </tr>
            </table>
        </form>
        <p>Don't have an account ? <a href="RegisterServlet">Register</a></p>
    </body>
</html>
