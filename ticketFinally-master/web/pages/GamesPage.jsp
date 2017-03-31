<%-- 
    Document   : GamesPage
    Created on : 7 лип. 2016, 9:33:00
    Author     : us9546
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ua.ticket.web.controllers.GamesController"%>
<%@page import="ua.ticket.web.beans.GameOfTeam"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        
        <script src="../js/jquery.min.js"></script>
        <link href="../css/bootstrap.min.css" rel="stylesheet"> 
        <link href="../css/gamePage.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <script src= "../js/manipulGame.js" type="text/javascript"></script>
        <title>Перегляд матчів</title>

    </head>

    <body>
        <jsp:useBean id="gamesList" class="ua.ticket.web.controllers.GamesController"/>
        <jsp:useBean id="gamesInfo" class="ua.ticket.web.controllers.GamesController"/>
        <jsp:useBean id="gamesTeam" class="ua.ticket.web.beans.GameOfTeam"/>
        <jsp:useBean id="reportGame" class="ua.ticket.web.controllers.ReportController"/>

    <div class = "form-group">    
        <form  name="sortForm" action="../GamesController" method="POST" >
         <div id = "listMathes" class="col-sm-2">
            <select id = 'selectGameTime' class="form-control" name = "sortGames">
                <option selected ><%=gamesInfo.showDefoultSort() %></option>
                <option class="special" value = "showAllGame"> всі матчі</option>
                <option style="background: #5cb85c; color: #fff;" value = "showCurrentGame"> поточний матч</option>
                <option value = "showFutureGame"> майбутні матчі</option>
            </select>
         </div>    
        </form><br>
    </div>
        <button id ="addG" class="btn btn-warning" type = "button" onclick = "addGame();">добавити матч</button> 
          <input id="editGames" type="hidden" name="editGames" value="editGames" />
        <button id="editG" class="btn btn-warning" type = "submit" onclick = "edit();">редагувати матчі</button>  
          
        <form  action="../SubscriptionController" method="POST">
             <button id = 'button_AddGame' type="submit" class="btn btn-primary"> Добавити абоненмент </button>
             <input type="hidden" name="perSub" value="perSub"/>
        </form>
        
        <form  action="../SaleController" method="POST">
             <button id = 'button_SaleTickets' type="submit" class="btn btn-primary"> Замовити квиток </button> 
        </form> 
        
        <form  action="../SectorController" method="POST">
             <button id = 'button_Sectors' type="submit" class="btn btn-primary btn_sectors"> Довідник секторів </button>
             <input type="hidden" name="perSectors" value="perSectors"/>
        </form>
        
        <br><br>
        <div id = 'addGameJS'></div>
        
        <table id ='tableGame' class="table">
            <thead>
                <tr>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 15%">Сезон</th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 8%">Час</th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 13%">Дата</th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 20%">Господарі</th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 20%">Гості</th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 25%">Місце проведення</th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 0%"></th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 0%"></th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 0%"></th>
                </tr>
            </thead>
            <tbody> 
                <div id = "form-game">
                    
        <%
            for (GameOfTeam game : gamesList.getListGame()){
                
                
        %>
                <tr id="<%=game.getId()%>">
                <form id ="form1"  action="../GamesController" method="POST" >
                    
                <input id ="input  <%=game.getId()%> " type="hidden" name="id" value="<%=game.getId()%>" /> 
                <td id = 'columnTableGame'><input class="col-xs-12" type="text" name="season" value="<%=game.getSeason() %>" size="3" disabled/></td>
                <td id = 'columnTableGame'><input class="col-xs-12" type="text" name="time" value="<%=game.getTimeGame() %>" size="3" disabled/></td>
                <td id = 'columnTableGame'><input id ="datepicker" class="col-xs-12" type="text" name="date" value="<%=game.getDateGame()%>" size="20" disabled /></td>
                <td id = 'columnTableGame'><input class="col-xs-12" type="text" name= "owner" value="<%=game.getNameTeam1()%>" size="20" disabled/></td>
                <td id = 'columnTableGame'><input class="col-xs-12" type="text" name="guest" value="<%=game.getNameTeam2() %>" size="20" disabled /></td>
                <td id = 'columnTableGame'><input class="col-xs-12" type="text" name="place" value="<%=game.getPlaceGame()%>" size="20" disabled/></td>


                                           
                <td id = 'columnTableGame'>
                    
                    <button id="btn_update<%=game.getId()%>" class="btn btn-info btn-xs btn_zv" type="button" data-toggle="modal" data-target="#<%=game.getId()%><%=game.getId()%>">ЗВІТ</button>

                </td>
                    <div id="<%=game.getId()%><%=game.getId()%>" class="modal fade">
                        <div class="modal-dialog">
                        <div class="modal-content">
                        <div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
                            <p id = "nameTeamIn"><%=game.getNameTeam1()%> - <%=game.getNameTeam2() %></p>
                        <h4 class="modal-title">Дата гри: <%=game.getDateGame()%></h4>
                        </div>
                        <div>
                                <%
                                    Iterator<Integer> iterSector = reportGame.getSectorsForReport(game.getId()).iterator();
                                    int idSector = 0;
                                    int allSumm = 0;
                                    while(iterSector.hasNext()){
                                        idSector = (Integer)iterSector.next();
                                %>
                                <div class="modal-body"><%=reportGame.getNameSectorForReport(idSector)%></div>
                                <% 
                                    reportGame.getSizePlaceForReport(idSector, game.getId());
                                %>
                                <% 
                                    int countPlace  = reportGame.arrPlace.size();
                                    int priceSector = reportGame.getPriceSectorForReport(idSector);
                                    int sum = countPlace*priceSector;
                                    allSumm = allSumm + sum;
                                %>
                                
                            <div class="alert alert-info">
                                <div class="modal-body">Назва сектора: <%=reportGame.getNameSectorForReport(idSector)%></div>
                                <div class="modal-body">Продано квитків:   <%=countPlace %></div>
                                <div class="modal-body">Ціна квитка в секторі: <%=priceSector %> грн.</div>
                                <div class="modal-body">Сума: <%=sum %> грн.</div>
                                <br>
                            </div>
                                <%}%>
                                <br>
                                
                                <div class="modal-body alert-success">Загальна сума: <%=allSumm%> грн.</div>
                                

                            <div class="modal-footer"><button class="btn btn-default" type="button" data-dismiss="modal">Закрити</button></div>
                        </div>
                        </div>
                        </div>
                    </div> 
                        
                        <input id="updateGame" type="hidden" name="updateGame" value="updateGame" />
                        <td id = 'columnTableGame'><input id ="s1" class="btn btn-mini btn-warning" type="submit" value = "обновити" style = "display: none"/></td>
                </form>
                <form action="javascript:void(null);" class="cancel_of_order" id="formDeleted<%=game.getId()%>" onsubmit="deleteGameAjax(<%=game.getId()%>)">
                     <input type="hidden" name="id" value="<%=game.getId()%>" />   
                     <input id="deleteGame" type="hidden" name="deleteGame" value="deleteGame"/>
                     <td id = 'columnTableGame'><input id ="s2" class="btn btn-mini btn-warning" type="submit" value = "видалити" style = "display:none"/></td>      
                </form>
               </tr>        
            </div>
          
        <%}%>
            </tbody>
         </table> 
    </body>
</html>