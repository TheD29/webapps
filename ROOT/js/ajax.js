
$(document).ready(function(){
    $('#userForm').submit(function(){
    
        $('#city').html("<b>Триває поновлення...</b>");
         
     
        $.post('InsertUsProd.php', $(this).serialize(), function(data){
          
            $('#city').html(data);
             
        }).fail(function() {
         
                 alert( "Дублювання записів" );
                 
             
        });
 
        // to prevent refreshing the whole page page
        return false;
 
    });
});


$(document).ready(function(){
    var maxField = 50; //Input fields increment limitation
    var addButton = $('.add_button'); //Add button selector
    var wrapper = $('.field_wrapper'); //Input field wrapper
    var fieldHTML = '<div  class="wrapper"><table class="input-box"><tbody><tr class="summ"><td>'+
    '<select name="device[]" class="option" id="department">'+
                        '<option value="0">---------</option>'+
                        '<option value="1">Шуба</option>'+
                        '<option value="2">Угі</option>'+
                        '<option value="3">Сумочка</option>'+
                        '<option value="4">Плаття</option>'+
                       
    '<input name="quantity[]" class="quantity" type="text"  value="0" size="6">'+
    '<input name="purchace[]" class="purchace" type="text"  value="0" size="6">'+
    '</td><td><input name="price[]" class="price" type="text"  value="0" size="6">'+
    '<select name="color[]" class="option" id="color">'+
                        '<option value="0">---------</option>'+
                        '<option value="1">Сірий</option>'+
                        '<option value="2">Чорний</option>'+
                        '<option value="3">Білий</option>'+
                        '<option value="4">Червоний</option>'+
                        '<option value="5">Зелений</option>'+
    '<td><input name="sum[]" type="text" readonly="" class="sum"></td>'+
    '</tr></tbody></table><a clas="ahef" href="javascript:void(0);" class="remove_button" title="Add field"><img src="images/up_arrow.png"/></a></div>'; //New input field html 
    var x = 1; //Initial field counter is 1
    $(addButton).click(function(){ //Once add button is clicked
        if(x < maxField){ //Check maximum number of input fields
            x++; //Increment field counter
            $(wrapper).append(fieldHTML); // Add field html
        }
    });
    $(wrapper).on('click', '.remove_button', function(e){ //Once remove button is clicked
        e.preventDefault();
        $(this).parent('div').remove(); //Remove field html
        x--; //Decrement field counter
    });



//Sum

 $(this).on('keyup','.quantity,.price',function () {
    var quantity = $(this).closest('tr').find('.quantity').val();
    var price = $(this).closest('tr').find('.price').val();
   var sum = $(this).closest('tr').find('.sum');
     quantity = parseFloat(quantity);
     price = parseFloat(price);
     var result = quantity * price;
   if(!isNaN(result)){
     sum.val(result.toFixed(2));
   }



//AllSum
   var total=0;
        $('.sum').each(function() {
            if ($(this).val() !== ""){ total += parseFloat($(this).val());}
        });
        $('.SumSum').val(total);

        //
  });

$('.check').each(function(){

var quantity = $(this).closest('tr').find('.check').val();
var checkGETday = $(this).closest('tr').find('.checkGETday').val();
    var price = $(this).closest('tr').find('.used').val();
   var sum = $(this).closest('tr').find('.result');
     quantity =  parseFloat(quantity);
     price = parseFloat(price);
     checkGETday =parseFloat(checkGETday);
     var result = quantity + checkGETday - price;
   if(!isNaN(result)){
     sum.val(result.toFixed(2));
   }

});

$('.checkGETday').each(function(){

var quantity = $(this).closest('tr').find('.check').val();
var checkGETday = $(this).closest('tr').find('.checkGETday').val();
    var price = $(this).closest('tr').find('.used').val();
   var sum = $(this).closest('tr').find('.result');
     quantity =  parseFloat(quantity);
     price = parseFloat(price);
     checkGETday =parseFloat(checkGETday);
     var result = quantity + checkGETday - price;
   if(!isNaN(result)){
     sum.val(result.toFixed(2));
   }
});


 $(this).on('keyup','.check,.used,.checkGETday',function () {
   var quantity = $(this).closest('tr').find('.check').val();
var checkGETday = $(this).closest('tr').find('.checkGETday').val();
    var price = $(this).closest('tr').find('.used').val();
   var sum = $(this).closest('tr').find('.result');
     quantity =  parseFloat(quantity);
     price = parseFloat(price);
     checkGETday =parseFloat(checkGETday);
     var result = quantity + checkGETday - price;
   if(!isNaN(result)){
     sum.val(result.toFixed(2));
   }
});

/*Cross Browser Search*/

$('.option').bind('keyup', function() {
    var q = new RegExp($(this).val(), 'ig');
 
    for (var i = 0, l = field.length; i < l; i += 1) {
        var option = $(field[i]),
            parent = option.parent();

        if ($(field[i]).text().match(q)) {
            if (parent.is('span')) {
                option.show();
                parent.replaceWith(option);
            }
        } else {
            if (option.is('option') && (!parent.is('span'))) {
                option.wrap('<span>').hide();
            }
        }
    } 
});


$('.option').each( function(){

    $(this).html($(this).find('option').sort(function(a, b) {

        return a.text == b.text ? 0 : a.text < b.text ? -1 : 1

 }) );

});

    });




