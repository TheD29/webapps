<%-- 
    Document   : index
    Created on : 6 лип. 2016, 10:07:43
    Author     : us9522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        
        
    </head>
    <body>
        <jsp:useBean id="masageError" class="ua.ticket.web.controllers.LoginController"/>
        <div class="container">
            <form role="form" action="LoginController" method="POST">
            <div class="row">
              <div class="Absolute-Center is-Responsive">
                <div id="logo-container"></div>
                <div class="col-sm-12 col-md-10 col-md-offset-1">
                  <form action="" id="loginForm">
                    <div class="form-group input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input type="email" class="form-control" id="email" name = login placeholder="введіть Ваш Login">          
                    </div>
                    <div class="form-group input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                      <input type="password" class="form-control" id="pwd"  name = password placeholder="введіть Ваш пароль">    
                    </div>
                    <div class="form-group">
                      <button type="submit" class="btn btn-def btn-block">Ввійти</button>
                      <% if (session != null){
                          if(session.getAttribute("login") != null && session.getAttribute("login").equals("loginFailed")){%>
                          <p id = "error_masage">Введені дані хибні! Перевірте введену інформацію!</p>               
                     <%     
                         session.invalidate();} }%>
                    </div>
                  </form>        
                </div>  
              </div>    
            </div>
           </form>
          </div>
    </body>
</html>
