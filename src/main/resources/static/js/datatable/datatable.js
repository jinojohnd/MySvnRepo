$(document).ready( function () {
	 $('#forexTable').DataTable();
	 
	 var table = $('#forexTablefromexisting').DataTable({
			"sAjaxSource": "forexEntries",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"columns": [
				{
					mRender: function ( data, type, row ) {
						return '<a class ="hyper" href=./create-forex?id='+row[0]+'>'+row[1]+'</a></td>';
					}
				},
				{ "mData": 2 },
				{ "mData": 3 },
				{ "mData": 4 }
			]
	 });

	 
	 var infoModal = $('#myModal');
	 var json;
	 $(document).on('click', '.modal-toggle', function(){
	       /* $.ajax({
	            type: "GET",
	            url: './home/view-forex?id='+$(this).data('id'),
	            dataType: 'json',
	            success: function(data){
	            	json=data;
	            	alert( "done" );
	            },
	            error:function(data){
	            	json=data;
	            }
	        });*/
		 
		 $.get( "./home/view-forex?id=" + $(this).data('id'), function( data ) {
			 var r = data;
			 $("#modal-body-popup").html(data);
		 });
	    });
});