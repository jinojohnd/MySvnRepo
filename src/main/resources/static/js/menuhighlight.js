$(document).ready( function () {	
	
	$(function () {
		setMenuHighlight();
	});
	
	function setMenuHighlight()
	{
		var path=window.location.pathname;
		path=path.replace(/\/$/,"");
		path=decodeURIComponent(path);
		
		$(".nav a").each(function()
		{
			var href=$(this).attr('href');
			if(path.substring(0,href.length) === href){
				$(this).closest('li').addClass('active');
				$(this).closest('a').addClass('active');
			}
		});
	}
});