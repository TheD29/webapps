<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 29.03.2017
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String uName = (String) request.getAttribute("username");
    %>
    <%=uName%>
</body>
</html>
