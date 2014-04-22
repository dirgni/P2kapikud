//$(document).ready(function(){
//     $('#uudised_tabelis')
// 		.tablesorter({
//	    	sortList: [[0,1],[1,1]],
//	    	dateFormat : 'uk',
//		    headers: {
//		    	4: { sorter: false }
//		    },
//		    sortMultiSortKey: 'ctrlKey' 
//	     });
//
////		     .tablesorter().tablesorterPager({container: $("#pager")});
//});

$(document).ready(function(){
    $('#uudised_tabelis')
	.tablesorter({
	sortList: [[0,1],[1,1]],
	dateFormat : 'uk',
	headers: {
		4: { sorter: false }
	},
	sortMultiSortKey: 'ctrlKey' 
	});
//		     .tablesorter().tablesorterPager({container: $("#pager")});
});