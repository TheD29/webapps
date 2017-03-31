<%-- 
    Document   : sectors
    Created on : 12 лип. 2016, 16:01:04
    Author     : us9522
--%>

<%@page import="ua.ticket.web.controllers.SectorController"%>
<%@page import="ua.ticket.web.beans.Sector"%>
<%--<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Довідник секторів</title>

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/sectors.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
    <body>

        <jsp:useBean id="sectorList" class="ua.ticket.web.controllers.SectorController"/>

        <div class="header">
            <div class="">
                <form  action="../SaleController" method="POST">
                    <button id='button_SaleTickets' type="submit" class="btn btn-primary order_ticket"> Замовити квиток </button> 
                </form>
                
                <form  action="../SubscriptionController" method="POST">
                    <button id='button_AddSub' type="submit" class="btn btn-primary add_sub"> Добавити абонемент </button> 
                    <input type="hidden" name="perSub" value="perSub"/>
                </form>
                
                <form  action="../GamesController" method="POST">
                    <button id='button_AddGame' type="submit" class="btn btn-primary"> Показати ігри </button> 
                </form>
            </div>
        </div>

        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="forms">
                        
                        <label class="name">Назва сектора</label>
                        <label class="price">Ціна за місце</label>
                        
                        <%
                            for(Sector sector : sectorList.getSectorAll()){
                        %>
                        <form action="../SectorController" method="POST">
                            <div class="form-group alert alert-info sector_info">
                                <input class="hidden" id="id" type="text" name="id" value="<%=sector.getId()%>" size="20" />
                                <input id="name" type="text" name="name" value="<%=sector.getName()%>" size="20" />
                                <input id="price" type="text" name="price" value="<%=sector.getPrice()%>" size="20" />
                                <input type="hidden" name="UpdateSectors" value="perSectors"/>
                                <button id="btn_update" class="btn btn-sm btn-warning" value="update" type="submit">Оновити</button>
                            </div>
                        </form>
                        <%}%>   
                    </div>
                </div>
            </div>
        </div>
        
                
                
        <script src="../js/jquery.min.js"></script>
    
        <script src="../js/bootstrap.min.js"></script>
        
        
    </body>

</html>