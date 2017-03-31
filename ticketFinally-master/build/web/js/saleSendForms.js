/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function call(id) {
        var msg   = $('#mainFormToSale' + id).serialize();
    $.ajax({
        type: 'POST',
        url: '../SaleController',
        data: msg,
    success: function(data) {
        $('#results').html(data);
        document.getElementById(id).style.display = "none";
        $( ".modal-backdrop" ).removeClass( "modal-backdrop" );
        $('#btn_update' + id).addClass("btn_busy");
    },
    error:  function(xhr, str){
        alert('Помилка запису даних: ' + xhr.responseCode);
    }
  });
}
