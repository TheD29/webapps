<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 3/19/2017
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <meta charset="UTF-8">

  <title>Login</title>

  <link rel="stylesheet" href="/css/list.css">
  <link rel="stylesheet" href="/css/style.css">

</head>
<body>
<div id="container">

  <form id="userForm" method="POST" action="/Servlet">

    <label class="username">Username:</label>

    <input type="name" name="username">

    <label class="username">Password:</label>

    <input type="password" name="password">

    <div id="lower">

      <input type="submit" value="Ввійти" name="submit">

      </input>


    </div>


  </form>

</div>

</body>
</html>
