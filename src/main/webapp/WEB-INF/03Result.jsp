<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String email = request.getParameter("email");
    String pwd = request.getParameter("pwd");
    String addr1 = request.getParameter("addr1");
    String addr2 = request.getParameter("addr2");

    PrintWriter pout = response.getWriter();
    pout.println(email + "<br>");
    pout.println(pwd + "<br>");
    pout.println(addr1 + "<br>");
    pout.println(addr2);
%>
</body>
</html>
