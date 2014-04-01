$(document).ready(function(){
     $('#uudised_tabelis')
     		.tablesorter({
		    	sortList: [[0,1],[1,1]],
		    	dateFormat : 'uk',
			    headers: {
			    	5: { sorter: false }
			    },
			    sortMultiSortKey: 'ctrlKey' 
		     })
//		     .tablesorter().tablesorterPager({container: $("#pager")});
});

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