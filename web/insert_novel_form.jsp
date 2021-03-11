<%-- 
    Document   : insertNovelForm
    Created on : 11-Mar-2021, 13:44:47
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
        <h1>Add a novel</h1>
        <form action="NovelServlet" enctype="multipart/form-data" method="POST">
            <table>
                <tr>
                    <th>Novel name</th>
                    <td><input type="text" name="novelName"/></td>
                </tr>
                <tr>
                    <th>Cover</th>
                    <td><input type="file" name="coverURL" id="coverURL"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add" name="a"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
