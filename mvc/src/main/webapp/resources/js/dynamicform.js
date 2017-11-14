/* JAVA SCRIPT DYNAMIC FORM - ADD NEW LINE */

$(document).ready(function() {
	
	//maximum input allowed
    var max_fields = 10;
    
    //Fields wrapper
    var wrapper = $(".input_fields_wrap");
    
    //Button ID
    var add_button = $(".add_field_button"); 
    
    var x = 1; 
    
    $(add_button).click(function(e){
        e.preventDefault();
        if(x < max_fields){ 
            $(wrapper).append('<div> <input type="text" name="drop_labels[' + x + '].name"/> <input type="text" name="drop_labels[' + x + '].url"/> <a href="#" class="remove_field"> Remover </a></div>'); 
            x++; 
        }
    });
   
    $(wrapper).on("click",".remove_field", function(e){
        e.preventDefault(); 
        $(this).parent('div').remove(); x--;
        $(".labels").splice(x, 1);
    })
});