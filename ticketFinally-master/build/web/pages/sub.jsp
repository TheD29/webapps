<%@page import="java.util.Iterator"%>
<%@page import="ua.ticket.web.controllers.SubscriptionController"%>
<%--<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>--%>
<%-- 
    Document   : main
    Created on : 6 лип. 2016, 10:24:49
    Author     : us9522
--%>
<%@page import="ua.ticket.web.beans.Subscription"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Абонементи</title>
        <script src= "../js/manipulSub.js" type="text/javascript"></script>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/sub.css" rel="stylesheet">
        
    </head>
    <body> 
        <jsp:useBean id="subscriptionList" class="ua.ticket.web.controllers.SubscriptionController"/>
        
        <button id ="addS" class="btn btn-warning" type = "button" onclick = "addSub();">добавити абонемент</button> 
        
        <input id="editGames" type="hidden" name="editGames" value="editGames" />
        <button id="editS" class="btn btn-warning" type = "submit" onclick = "editS();">редагувати абонементи</button> 
        
        <form  action="../GamesController" method="POST">
             <button id = 'button_InfoGame' type="submit" class="btn btn-primary"> Інформація про матчі </button> 
        </form>
        
        <form  action="../SaleController" method="POST">
             <button id = 'button_SaleTickets' type="submit" class="btn btn-primary"> Замовити квиток </button>
             <br>
        </form>
        <form  action="../SectorController" method="POST">
             <button id = 'button_Sectors' type="submit" class="btn btn-primary btn_sectors"> Довідник секторів </button>
             <input type="hidden" name="perSectors" value="perSectors"/>
        </form>
        <br>
        <div id = 'addSub'></div>
        <br>
        
        <table id ="tableSub" class="table">
            <thead>
                <tr>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 60%">ПІП</th>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 25%">сезон</th>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 7%">сектор</th>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 5%">ряд</th>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 5%" >місце</th>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 0%" ></th>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 0%" ></th>
                </tr>     
            </thead>
            <tbody>
            <div>
                 <%
                    for (Subscription subscription : subscriptionList.getSubscriptionAll()) {
                %>
                    <form  action="../SubscriptionController" method="POST">
                        <div class="form-group">
                            <tr id="<%=subscription.getId()%>">
                            <input id="id" type="hidden" name="id" value="<%=subscription.getId()%>" size="20" />
                            <td class = 'columnTableSub'><input id="PIP"   class="col-xs-12"  type="text" name="PIP" value="<%=subscription.getPIP()%>" size="20" disabled /></td>
                            <td class = 'columnTableSub'><input id="season"class="col-xs-12"  type="text" name="season" value="<%=subscription.getSeason()%>" size="20" disabled  /></td>
                            <td class = 'columnTableSub'><input id="sector"class="col-xs-12"  type="text" name="sector" value="<%=subscription.getSector()%>" size="20" disabled /></td>
                            <td class = 'columnTableSub'><input id="row"   class="col-xs-12"  type="text" name="row" value="<%=subscription.getRow()%>" size="20" disabled  /></td>
                            <td class = 'columnTableSub'><input id="number" class="col-xs-12" type="text" name="number" value="<%=subscription.getNumber()%>" size="20" disabled  /></td>
                        </div>
                        <td class = 'columnTableSub'><button id="btn_update" value="update" type="submit" class="btn btn-mini btn-warning" style = "display: none">Оновити</button></td>  
                    </form>
                    <form action="javascript:void(null);" class="cancel_of_order" id="formDeletedSUB<%=subscription.getId()%>" onsubmit="deleteSubAjax(<%=subscription.getId()%>)">
                        <input class="delete_sub" id="id" type="text" name="id" value="<%=subscription.getId()%>" size="20" />
                        <input id="del_sub" type="hidden" name="del_sub"  />
                        <td class = 'columnTableSub'><button id="btn_delete" value="delete" type="submit" class="btn btn-mini btn-warning" style = "display: none" >Видалити</button></td> 
                    </form>
                    </tr>
                 </div>       
                <%}%>
                </tbody>
                </table>

          <div class="footer"></div>
          <script src="../js/jquery.min.js"></script>
    
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
