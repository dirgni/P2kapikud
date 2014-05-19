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
    
    var hash = window.location.hash.substring(1);
	if (hash) {
		preview(hash);
	}
});
