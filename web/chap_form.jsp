<%-- 
    Document   : chap_form
    Created on : 16-Mar-2021, 16:07:16
    Author     : chiuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Chapter</title>
    </head>
    <body>
        <form action="ChapterServlet" method="POST" id='form'>
            <input type="hidden" name="a" value="add"/>
            <input type="hidden" name="nid" value="${requestScope.novelObj.novelID}"/>
            <fieldset>
                <legend><h1>Add a new Chapter</h1></legend>
                <div>
                    <label>Novel Name</label> <br>
                    <input type="text" value="${requestScope.novelObj.novelName}" readonly/>
                </div>
                <div>
                    <label>Chapter Name</label> <br>
                    <input type="text" name="chapname" id="chapname"/>
                    <p id="chapNameMsg" style="visibility: hidden; color: red">Chapter name can't be empty</p>
                </div>
                <div>
                    <label style='font-weight: bold; font-size: 150%'>Content</label> <br>
                    <textarea rows="10" cols="112" name='content' id='content' style='font-size: 150%'></textarea>
                    <p id='contentMsg' style='visibility: hidden; color: red'>Content can't be empty</p>
                </div>
                <div>
                    <input type='submit' value='Add'/>
                    <button><a href='NovelServlet?a=display' style='text-decoration: none; color:#000000'>Cancel</a></button>
                </div>
            </fieldset>
        </form>
                <script defer>
                    const form = document.getElementById("form");
                    const chapName = document.getElementById("chapname");
                    const content = document.getElementById("content");
                    const chapNameMsg = document.getElementById("chapNameMsg");
                    const contentMsg = document.getElementById("contentMsg");
                    form.addEventListener("submit", event =>{
                        if(chapName.value === ""){
                            event.preventDefault();
                            chapNameMsg.style.visibility = "visible";
                        }
                        if(content.value === "") {
                            event.preventDefault();
                            contentMsg.style.visibility = "visible";
                        }
                    });
                </script>
    </body>
</html>
