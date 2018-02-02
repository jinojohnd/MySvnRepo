$(document).ready( function () {
	 var table = $('#forexTable').DataTable({
			"sAjaxSource": "home/forexEntries",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"columns": [
				{ "mData": 0},
				{ "mData": 1 },
				{ "mData": 2 },
				{ "mData": 3 }
			]
	 });
	 
	 var table = $('#forexTablefromexisting').DataTable({
			"sAjaxSource": "forexEntries",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"columns": [
				{ "mData": 0},
				{ "mData": 1 },
				{ "mData": 2 },
				{ "mData": 3 },
				{
					mRender: function ( data, type, row ) {
						return '<button class="btn btn-primary btn-md" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></td>';
					}
				}
			]
	 });

});