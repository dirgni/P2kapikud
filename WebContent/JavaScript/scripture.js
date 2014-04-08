/*$(document).ready(function(){
     $('#uudised_tabelis')
 		.tablesorter({
	    	sortList: [[0,1],[1,1]],
	    	dateFormat : 'uk',
		    headers: {
		    	5: { sorter: false }
		    },
		    sortMultiSortKey: 'ctrlKey' 
	     });
     
     
//		     .tablesorter().tablesorterPager({container: $("#pager")});
});*/

function muudaSisu(target, source) {
    document.getElementById(target).innerHTML = document.getElementById(source).innerHTML;
 }

function showMeldi(){
	$('#meld').css({"display":"table-caption"});
	$('#register').css({"display":"none"});
}
function showRegistreeru(){
	$('#register').css({"display":"table-caption"});
	$('#meld').css({"display":"none"});
}


function makeVisible(Id){
	document.getElementById(Id).style.display="block";
	$("body").css("overflow", "hidden");
}

function makeHidden(Id){
	document.getElementById(Id).style.display="none";
	$("body").css("overflow-y", "scroll");
}




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
			}
		);
				
		
	});
})(jQuery);