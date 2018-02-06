$(document).ready( function () {
	 var table = $('#forexTable').DataTable({
			"sAjaxSource": "home/forexEntries",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"columns": [
				{ "mData": 1},
				{ "mData": 2 },
				{ "mData": 3 },
				{ "mData": 4 },
				{
					mRender: function ( data, type, row ) {
						/*return '<a href="./home/view-forex?id='+row[0]+'" class="btn btn-primary btn-md" data-title="Edit"><span class="glyphicon glyphicon-search"></span></a></td>';*/
						return '<a data-toggle="modal" data-id="'+row[0]+'" data-target="#myModal" class="modal-toggle btn btn-primary btn-md" data-title="Edit"><span class="glyphicon glyphicon-search"></span></a></td>';
					}
				}
			]
	 });
	 
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