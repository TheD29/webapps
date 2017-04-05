function change_value(input, text){
	$(input).attr('value', text).focus(function(){
		if($(this).val() == text){
			$(this).attr('value', '');
		}
	}).blur(function(){
		if($(this).val() == ''){
			$(this).attr('value', text);
		}
	});
}
$(function(){
	change_value('.search', 'пошук...');
	$('.hledat').click(function(){
		var search = $('.search').val();
		if(search){
			$.ajax({
				type: "POST",
				url: "cons.php",
				data: 'search=' + search,
				success: function(response){
					$('#middle').html(response);
				}
			});
		}
		return false;
	});
});
