$(document).ready( function () {
	
	$('#tblHolidayList').DataTable(
	);
	
	$('#tblEmployeeList').DataTable(
	);
	
	$('#tblRoleList').DataTable(
	);
	
	
	
	 $('#myForexTableHme').DataTable({
		 "lengthMenu": [ 5, 10 ]
	 });
	 
	 var table = $('#forexPendingApproval').DataTable({
				"sAjaxSource": "forexEntriesForApproval",
				"sAjaxDataProp": "",
				"lengthMenu": [ 5, 15, 50, 100 ], 
				"order": [[ 0, "desc" ]],
				"columns": [
					{
						mRender: function ( data, type, row ) {
							return '<a class ="hyper" href=./approve/approve-forex?id='+row[0]+'>'+row[0]+'</a></td>';
						}
					},
					{ "mData": 1 },
					{ "mData": 2 },
					{ "mData": 3 }
			]
	 });
	 
	 var table = $('#forexReport').DataTable({
				"sAjaxSource": "forexApprovedList",
				"sAjaxDataProp": "",
				"lengthMenu": [ 5, 15, 50, 100 ], 
				"order": [[ 0, "desc" ]],
				"columns": [
					{ "mData": 0 },
					{ "mData": 1 },
					{ "mData": 2 },
					{ "mData": 3 },
					{ "mData": 4},
					{
						mRender: function ( data, type, row ) {
							return '<a href="./download-report?id='+row[0]+'" class="btn btn-primary btn-md" data-title="Download"><span class="glyphicon glyphicon-arrow-down"></span></a></td>';
						}
					}
				]
		 });
	 
	 var table = $('#forexCentrumUpload').DataTable({
			"sAjaxSource": "forexReportForUpload",
			"sAjaxDataProp": "",
			"lengthMenu": [ 5, 15, 50, 100 ], 
			"order": [[ 0, "desc" ]],
			"columns": [
				{
					mRender: function ( data, type, row ) {
						return '<a class ="hyper" href=./upload-centrum-bill?id='+row[0]+'>'+row[0]+'</a></td>';
					}
				},
				{ "mData": 1 },
				{ "mData": 2 },
				{ "mData": 3 }
			]
	 });
	 
	 var table = $('#forexApprovalTableHme').DataTable({
			"sAjaxSource": "home/forexEntriesForApproval",
			"sAjaxDataProp": "",
			"lengthMenu": [ 5, 10 ], 
			"order": [[ 0, "desc" ]],
			"columns": [
				{ "mData": 0},
				{ "mData": 1},
				{ "mData": 2 },
				{ "mData": 3 },
				{
					mRender: function ( data, type, row ) {
						/*return '<a href="./home/view-forex?id='+row[0]+'" class="btn btn-primary btn-md" data-title="Edit"><span class="glyphicon glyphicon-search"></span></a></td>';*/
						return '<a href="home/approve/approve-forex?id='+row[0]+'" class="btn btn-primary btn-md" data-title="Approve"><span class="glyphicon glyphicon-question-sign"></span></a></td>';
					}
				}
			]
	 });

	 
	 var infoModal = $('#myModal');
	 var json;
	 
	 $(document).on('click', '.modal-add-holiday-toggle', function(){	     	 
		 $.get( "./view-add-holiday", function(data) {
			 var r = data;
			 $("#holidayAddModalPopup").html(data);
		 });
	    });
	 
	 $(document).on('click', '.modal-holiday-delete-toggle', function(){	     	 
		 $.get( "./view-delete-holiday?id=" + $(this).data('id'), function( data ) {
			 var r = data;
			 $("#holidayDeleteModalPopup").html(data);
		 });
	    });
	 
	 $(document).on('click', '.modal-holiday-toggle', function(){	     	 
		 $.get( "./view-holiday?id=" + $(this).data('id'), function( data ) {
			 var r = data;
			 $("#holidayModalPopup").html(data);
		 });
	    });
	 
	  $(document).on('focus', '.mydatepickers', function() {
		     	 $(this).datepicker({
		 				format: 'dd-M-yyyy',
		 				todayHighlight: true,
		 				autoclose: true,
		 			});			
		     }); 

	 
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
		 
		 $.get( "./home/view-forex?id=" + $(this).data('id') +"&operation=view", function( data ) {
			 var r = data;
			 $("#modal-body-popup").html(data);
		 });
	    });
	 
	 $(document).on('click', '.modal-toggle-approve', function(){		 
		 $.get( "./home/view-forex?id=" + $(this).data('id') +"&operation=approve", function( data ) {
			 var r = data;
			 $("#modal-body-popup").html(data);
		 });
	    });
});