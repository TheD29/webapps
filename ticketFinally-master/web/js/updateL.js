/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function orderL() {
        var msg   = $('#formCanceled').serialize();
    $.ajax({
        type: 'POST',
        url: '../SaleController',
        data: msg,
    success: function(data) {
        $('#results').html(data);
        $('#ModalL').hide();
        $( ".modal-backdrop" ).removeClass( "modal-backdrop" );
    },
    error:  function(xhr, str){
        alert('Помилка запису даних: ' + xhr.responseCode);
    }
  });
}