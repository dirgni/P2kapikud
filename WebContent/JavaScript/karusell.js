$(document).ready(function(){
	$('.karusell_button_left').css({"display":"block"});
	$('#liner').css({"display":"block"});
	$('.karusell_button_right').css({"display":"block"});
});


var carousel_settings ={
		target : 0,
		id_name : "#karusell",
		class_left_button : "'.karusell_button_left'",
		class_right_button : "'.karusell_button_right'",
		size : 2
	};


(function($) {

	$(function() {
		var carousel = $(carousel_settings.id_name)[0].getElementsByTagName("li");
		
		var el3 = ($(".active").children().eq(1).html()+"").replace('"',"");
		$("#esi-uudis-wrapper").css({'background-image' : 'url("'+el3+'")'});
		
		carousel_settings.size=carousel.length;
		
		function targetIncrease(){
			if (carousel_settings.target+1>carousel_settings.size-1){
				carousel_settings.target = 0;
			}else{
				carousel_settings.target++;
			}
		};
		
		function targetDecrease(){
			if (carousel_settings.target-1<0){
				carousel_settings.target = carousel_settings.size-1;
			}else{
				carousel_settings.target--;
			}
		};
		
		$('.karusell_button_left').on('click',function(){
				var current = carousel_settings.target;
				var el1 = $(carousel[current]);
				
				targetDecrease();
				var next = carousel_settings.target;
				var el2 = $(carousel[next]);
				
				el1.removeClass('active');
				el1.addClass('inactive');
				
				el2.removeClass('inactive');
				el2.addClass('active');
				
				var el3 = ($(".active").children().eq(1).html()+"").replace('"',"");
				$("#esi-uudis-wrapper").css({'background-image' : 'url("'+el3+'")'});  				
			}
		);
		
		$('.karusell_button_right').on('click',function(){
				var current = carousel_settings.target;
				var el1 = $(carousel[current]);
				
				targetIncrease();
				var next = carousel_settings.target;
				var el2 = $(carousel[next]);
				
				el1.removeClass('active');
				el1.addClass('inactive');
				
				el2.removeClass('inactive');
				el2.addClass('active');
				
				var el3 = ($(".active").children().eq(1).html()+"").replace('"',"");
				$("#esi-uudis-wrapper").css({'background-image' : 'url("'+el3+'")'});  
			}
		);		
		
	});
})(jQuery);
