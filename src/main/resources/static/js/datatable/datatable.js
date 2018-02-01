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
	 })
});