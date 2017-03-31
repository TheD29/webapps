<%@ page import="db.DbConnector" %><%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 30.03.2017
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/list.css">

  </head>
  <body>

  <div id="container">

    <form id="userForm" method="POST" action="/userController">

      <%--@declare id="name"--%>
        <%--@declare id="username"--%>
        <label for="name">Username:</label>

      <input type="name" name="username">

      <label for="username">Password:</label>


      <input type="password" name="password" >


      <div id="lower">


        <input type="submit" value="Ввійти" name="submit2">

        </input>



      </div>


    </form>

  </div>



  </body>

</html>
