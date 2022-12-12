<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<%
    if (request.getSession().getAttribute("user") != null) {
        response.sendRedirect("views/LoginPage.jsp");
    }
%>

<%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<div>
    <h1>Welcome to my Website!</h1>
    <%
    if (request.getAttribute("errorMessage") != null) {
        String error = (String) request.getAttribute("errorMessage");
        out.print("<div style=\"display: flex; justify-content: center;\"><p style=\"color: red;\">" + error + "</p></div>");
    }
    %>
</div>

<div class="loginbox">
    <form action="<%=request.getContextPath()%>/FirstServlet" method="POST">

        <label for="userName">Username:</label>
        <input id="userName" type="text" name="username"/>
        <label for="passWord">Password:</label>
        <input id="passWord" type="password" name="password"/><br>
        <input type="submit" value="Login" />
    </form>
</div>
</body>
</html>