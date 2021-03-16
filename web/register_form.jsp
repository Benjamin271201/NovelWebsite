<%-- 
    Document   : register_form
    Created on : 04-Mar-2021, 17:28:14
    Aulabelor     : chiuy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/register.css"/>
    </head>
    <body>
        <c:if test="${duplicatedUser != null}">
            <p>This username already exists</p>
        </c:if>
            <form action="RegisterServlet" melabelod="POST" enctype="multipart/form-data" id="form">
                <fieldset>
                    <legend><h1>Register</h1></legend>
                <div>
                    <label>Username</label><br>
                    <input type="text" name="username" value="${username}" id="username"/>
                </div>
                <div id="usernameMsg" style="visibility: hidden" class="error">
                    Username can only be of length 4 to 20 characters
                </div>
                <div>
                    <label>Full name</label><br>
                    <input type="text" name="name" value="${name}" id="name"/>
                </div>
                <div id="nameMsg" style="visibility:hidden" class="error">
                        Full name can not be empty
                </div>
                <div>
                    <label>Email</label><br>
                    <input type="text" name="email" value="${email}" id="email"/>
                    <c:if test="${duplicatedEmail != null}">
                        <div id="duplicatedEmailMsg" class="error">This email address has already been used</div>
                    </c:if>
                    <div id="emailMsg" style="visibility:hidden" class="error">
                        Invalid Email
                    </div>
                </div>
                <div>
                    <label>Password</label><br>
                    <input type="password" name="password" id="password"/>
                </div>
                <div id="passMsg" style="visibility:hidden" class="error">
                    Password can only be of length 5 to 32 characters
                </div>
                <div>
                    <label>Confirm password</label><br>
                    <input type="password" name="conpass" id="confpassword"/>
                </div>
                <div id="confpassMsg" style="visibility:hidden" class="error">
                    Confirm password did not match
                </div>
                <div>
                    <label>Avatar</label>
                    <input type="file" name="avatar" value="${avatar}" id="avatar"/>
                </div>
                <div>
                    <input type="submit" value="Register" id="submitBtn"/>
                    <button type="button"><a href="NovelServlet">Cancel</a></button>
                </div>
            </fieldset>
        </form>
        <script src="js/script.js" defer></script>
    </body>
</html>
