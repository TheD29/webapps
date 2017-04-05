$(document).ready(function () {
    $('#userForm').submit(function () {

        $('#city').html("<b>Триває поновлення...</b>");


        $.post('InsertUsProd.php', $(this).serialize(), function (data) {

            $('#city').html(data);

        }).fail(function () {

            alert("Дублювання записів");


        });

        // to prevent refreshing the whole page page
        return false;

    });
});


//Sum

$(this).on('keyup', '.quantity,.price', function () {
    var quantity = $(this).closest('tr').find('.quantity').val();
    var price = $(this).closest('tr').find('.price').val();
    var sum = $(this).closest('tr').find('.sum');
    quantity = parseFloat(quantity);
    price = parseFloat(price);
    var result = quantity * price;
    if (!isNaN(result)) {
        sum.val(result.toFixed(2));
    }


//AllSum
    var total = 0;
    $('.sum').each(function () {
        if ($(this).val() !== "") {
            total += parseFloat($(this).val());
        }
    });
    $('.SumSum').val(total);

    //
});

$('.check').each(function () {

    var quantity = $(this).closest('tr').find('.check').val();
    var checkGETday = $(this).closest('tr').find('.checkGETday').val();
    var price = $(this).closest('tr').find('.used').val();
    var sum = $(this).closest('tr').find('.result');
    quantity = parseFloat(quantity);
    price = parseFloat(price);
    checkGETday = parseFloat(checkGETday);
    var result = quantity + checkGETday - price;
    if (!isNaN(result)) {
        sum.val(result.toFixed(2));
    }

});

$('.checkGETday').each(function () {

    var quantity = $(this).closest('tr').find('.check').val();
    var checkGETday = $(this).closest('tr').find('.checkGETday').val();
    var price = $(this).closest('tr').find('.used').val();
    var sum = $(this).closest('tr').find('.result');
    quantity = parseFloat(quantity);
    price = parseFloat(price);
    checkGETday = parseFloat(checkGETday);
    var result = quantity + checkGETday - price;
    if (!isNaN(result)) {
        sum.val(result.toFixed(2));
    }
});


$(this).on('keyup', '.check,.used,.checkGETday', function () {
    var quantity = $(this).closest('tr').find('.check').val();
    var checkGETday = $(this).closest('tr').find('.checkGETday').val();
    var price = $(this).closest('tr').find('.used').val();
    var sum = $(this).closest('tr').find('.result');
    quantity = parseFloat(quantity);
    price = parseFloat(price);
    checkGETday = parseFloat(checkGETday);
    var result = quantity + checkGETday - price;
    if (!isNaN(result)) {
        sum.val(result.toFixed(2));
    }
});

/*Cross Browser Search*/

$('.option').bind('keyup', function () {
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


$('.option').each(function () {

    $(this).html($(this).find('option').sort(function (a, b) {

        return a.text == b.text ? 0 : a.text < b.text ? -1 : 1

    }));

});






