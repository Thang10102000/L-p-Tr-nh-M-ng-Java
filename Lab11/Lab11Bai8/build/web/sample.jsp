<%-- 
    Document   : sample
    Created on : Nov 17, 2021, 9:37:31 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <%
           String us=request.getParameter("user");
           String psw=request.getParameter("password");
           if(us.equals(psw))
           out.println("Welcome "+us);
           else
           out.println("Something wrong with your username & password");
        %>
    </body>
</html>
