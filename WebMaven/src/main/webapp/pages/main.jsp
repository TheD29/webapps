<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 30.03.2017
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %><%--статичне виклик заголовку сторінки--%>

<div class="panel panel-default">
    <div class="panel-body">

        <form method="POST" action="/BuyController">
            <div class="field_wrapper">

                <table class="input-box">
                    <tbody>
                    <tr>
                        <th>Перелік товарів</th>
                        <th>К-сть</th>
                        <th>Закуп.ціна за шт.</th>
                        <th>Ціна за шт.</th>
                        <th>Номер карти</th>
                        <th>Колір</th>
                        <th>Модель</th>
                        <th>№ замовл.</th>
                        <th>Всього</th>

                    </tr>
                    <!-- This is our clonable table line -->
                    <tr class="summ">
                        <td>
                            <select name="device[]" class="option" id="list">
                                <option value="0">-----------</option>

                                <option value="'.$id.'">'.$row['name'].'</option>
                            </select>
                        </td>
                        <td>
                            <input name="quantity[]" class="quantity" type="text">
                        </td>
                        <td>
                            <input name="purchace[]" class="purchace" type="text">
                        </td>
                        <td>
                            <input name="price[]" class="price" type="text">
                        </td>
                        <td>
                            <input name="cardnumber[]" class="price" type="text">
                        </td>
                        <td>
                            <select name="color[]" class="color" id="color">
                                <option value="0">-----------</option>
                            </select>
                        </td>

                        <td>
                            <select name="model[]" class="model" id="model">
                                <option value="0">-----------</option>

                            </select>
                        </td>
                        <td>
                            <input name="ordernum[]" class="price" type="text">
                        </td>
                        <td>
                            <input name="sum[]" class="sum" type="text" readonly="">
                        </td>

                        <td>
                            <div class="table-remove">
                                <a href="javascript:void(0);" class="add_button"
                                   title="Add field">
                                    <img src="/images/down_arrow.png" height="32"
                                         width="32"/>
                                </a></div>
                        </td>

                    </tr>
                    </tbody>
                </table>
            </div>
            <span><label class="lable">Загальна сума:</label>
                <input name="FinalSum" type="text" class="sumsum" readonly="">
            </span>
            <div class="inpsubmit"><input type="submit" name="submit" value="Зберегти"/>
            </div>
        </form>
    </div>
</div>
<script src="js/ajax.js"></script>

</body>
</html>
