/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$( function() {

     $( "#datepicker" ).datepicker({
         
        monthNames: ['Січень', 'Лютий', 'Березень', 'Квітень',
                     'Травень', 'Червень', 'Липень', 'Серпень', 'Вересень',
                     'Жовтень', 'Листопад', 'Грудень'],
        dayNamesMin: ['Нд','Пн','Вт','Ср','Чт','Пт','Сб'],
        firstDay: 1,
        autoSize: true,
        
      minDate: "-0",
     dateFormat:"yy-mm-dd",
     
 }); 
});
