<%-- 
    Document   : addSub
    Created on : 3 серп. 2016, 15:46:20
    Author     : us9546
--%>

<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>addSub</title>
    </head>
    <body>
        <jsp:useBean id="subscriptionList" class="ua.ticket.web.controllers.SubscriptionController"/>
            <div class="add_sub">
                
                <form action="../SubscriptionController" method="POST">
                    <div class="form-group">
                        <div class ="col-xs-2">
                        <input class="form-control" type="text" id="PIP" name="PIP" value="" placeholder="ПІП"/> 
                        </div>
                        <div class ="col-xs-2">
                        <select class="form-control" name="season">
                            <option id="season">2015-2016</option>
                            <option id="season">2016-2017</option>
                            <option id="season">2017-2018</option>
                            <option id="season">2018-2019</option>
                        </select>
                        </div>
                        <div class="col-xs-2">
                            <select class="form-control" name="sectors">
                            <%
                                Iterator<String>iterSector = subscriptionList.getNameSectorsInGame().iterator();
                                while(iterSector.hasNext()){
                                    String nameSector = iterSector.next();
                            %>
                                <option id="season"><%=nameSector%></option>
                            
                            <%}%>
                            </select>
                        </div>
                        <div class="col-xs-2">
                            <select class="form-control" name="rows">
                            <%
                                Iterator<Integer>iterRows = subscriptionList.getRowsInGame().iterator();
                                while(iterRows.hasNext()){
                                    
                            %>
                                <option id="season"><%=iterRows.next()%></option>
                            
                            <%}%>
                            </select>
                        </div>
                        <div class ="col-xs-2">
                        <input class="form-control" type="text" id="number" name="number" value="" placeholder="місце" />
                        <input class="form-control" type="hidden" id="subscription" name="subscription" value="" />
                        <input class="form-control" type="hidden" id="subscriptionSec" name="subscriptionSec" value="" />
                        </div>
                        <button id="btn_add" value="delete" type="submit" class="btn btn-success">Зберегти</button> 
                    </div> 
                </form>
                
            </div>
    </body>
</html>
