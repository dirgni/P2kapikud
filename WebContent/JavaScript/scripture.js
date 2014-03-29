$(document).ready(function(){
     $('#uudised_tabelis')
     		.tablesorter({
		    	 sortList: [[0,1],[1,1]],
			     headers: {
			    	 5: { sorter: false }
			     },
			     sortMultiSortKey: 'ctrlKey' 
		     })
//		     .tablesorter().tablesorterPager({container: $("#pager")});
});

function makeVisible(Id){
	document.getElementById(Id).style.display="block";
	$("body").css("overflow", "hidden");
}

function makeHidden(Id){
	document.getElementById(Id).style.display="none";
	$("body").css("overflow-y", "scroll");
}