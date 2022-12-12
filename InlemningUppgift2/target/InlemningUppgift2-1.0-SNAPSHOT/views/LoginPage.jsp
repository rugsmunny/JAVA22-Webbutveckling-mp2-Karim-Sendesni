<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.UserBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome</title>
</head>
<body>

<%
    PrintWriter printer = response.getWriter();
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    response.setHeader("Pragma", "no-cache");

    if (request.getSession().getAttribute("user") == null) {
        response.sendRedirect("../index.jsp");

    } else {

        printer.print("<h1>Welcome " + ((UserBean) request.getSession().getAttribute("user")).getUserName() + "</h1>");
        printer.print("<form action=\"" + request.getContextPath() + "/SnackServlet\" method=\"GET\">");
        printer.print("<label for=\"snack\"/>What snack do you like?</label>");
        printer.print("<input type=\"text\" name=\"SnackChoice\" />");
        printer.print("<input type=\"submit\"/>");
        printer.print("</form>");
        if (request.getParameter("SnackChoice") != null) {
            printer.print("<p>So you like " + request.getParameter("SnackChoice") + ". Well.... not my first choice, I'll tell you that.</p>");
        }
        printer.print("<form action=\"" + request.getContextPath() + "/RemoveSessionServlet\" method=\"POST\">");
        printer.print("<input type=\"submit\" value=\"Logout\" />");
        printer.print("</form>");

    }
%>

</body>
</html>
