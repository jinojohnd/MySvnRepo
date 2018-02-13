$(document).ready(function(){

		var d = $('[name="fid"]').val();
		$.get( "./view-forex?id=" +d+"&operation=view", function( data ) {
			 var r = data;
			 $("#forex-data").html(data);
		 });
		
		var forexCrd = $('[name="forex_card"]').val();
});