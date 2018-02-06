$(document).ready(function(){
	var  itineraryIndex = 0;
	
	$('input[name="dob_dt"]').datepicker({
		format: 'dd-M-yyyy',
		todayHighlight: true,
		autoclose: true,
	});
	
	$('input[name="passport_iss_dt"]').datepicker({
		format: 'dd-M-yyyy',
		todayHighlight: true,
		autoclose: true,
	});
	
	$('input[name="passport_exp_dt"]').datepicker({
		format: 'dd-M-yyyy',
		todayHighlight: true,
		autoclose: true,
	});
	
	/* $('input[name="departure_dt"]').datepicker({
		format: 'dd-M-yyyy',
		todayHighlight: true,
		autoclose: true,
	}); */
	
	$('input[name="return_dt"]').datepicker({
		format: 'dd-M-yyyy',
		todayHighlight: true,
		autoclose: true,
	});			

    $('#request_type').bootstrapToggle();
    
    $(document).on('focus', '.mydatepickers', function() {
    	 $(this).datepicker({
				format: 'dd-M-yyyy',
				todayHighlight: true,
				autoclose: true,
			});			
    });
    
    
    $('#itinerary').on('click', '.addButton', function() {
    	itineraryIndex++;
    	var $template = $('#itineraryTemplate'),
        $clone    = $template
                        .clone()
                        .removeClass('hide')
                        .removeAttr('id')
                        .attr('data-itinerary-index', itineraryIndex)
                        .insertBefore($template);

    // Update the name attributes
    $clone
        .find('[name="departure_dt"]').attr('name', 'itineraryLst[' + itineraryIndex + '].departure_dt').prop('required',true).end()
        .find('[name="food_days"]').attr('name', 'itineraryLst[' + itineraryIndex + '].food_days').end()
        .find('[name="food_amt_per_day"]').attr('name', 'itineraryLst[' + itineraryIndex + '].food_amt_per_day').prop('required',true).end()
        .find('[name="food_total_amt"]').attr('name', 'itineraryLst[' + itineraryIndex + '].food_total_amt').end()
        .find('[name="food_cur"]').attr('name', 'itineraryLst[' + itineraryIndex + '].food_cur').prop('required',true).end()
        .find('[name="return_dt"]').attr('name', 'itineraryLst[' + itineraryIndex + '].return_dt').prop('required',true).end()
        .find('[name="local_conveyance_days"]').attr('name', 'itineraryLst[' + itineraryIndex + '].local_conveyance_days').end()
        .find('[name="local_conveyance_per_day"]').attr('name', 'itineraryLst[' + itineraryIndex + '].local_conveyance_per_day').prop('required',true).end()
        .find('[name="local_conveyance_total_amt"]').attr('name', 'itineraryLst[' + itineraryIndex + '].local_conveyance_total_amt').end()
        .find('[name="local_conveyance_cur"]').attr('name', 'itineraryLst[' + itineraryIndex + '].local_conveyance_cur').prop('required',true).end()
        .find('[name="dest_city"]').attr('name', 'itineraryLst[' + itineraryIndex + '].dest_city').prop('required',true).end()
        .find('[name="hotel_days"]').attr('name', 'itineraryLst[' + itineraryIndex + '].hotel_days').end()
        .find('[name="hotel_per_day"]').attr('name', 'itineraryLst[' + itineraryIndex + '].hotel_per_day').prop('required',true).end()
        .find('[name="hotel_total_amt"]').attr('name', 'itineraryLst[' + itineraryIndex + '].hotel_total_amt').end()
        .find('[name="hotel_cur"]').attr('name', 'itineraryLst[' + itineraryIndex + '].hotel_cur').prop('required',true).end()
        .find('[name="dest_country"]').attr('name', 'itineraryLst[' + itineraryIndex + '].dest_country').prop('required',true).end()
        .find('[name="othr_days"]').attr('name', 'itineraryLst[' + itineraryIndex + '].othr_days').end()
        .find('[name="othr_per_day"]').attr('name', 'itineraryLst[' + itineraryIndex + '].othr_per_day').prop('required',true).end()
        .find('[name="othr_total_amt"]').attr('name', 'itineraryLst[' + itineraryIndex + '].othr_total_amt').end()
        .find('[name="othr_cur"]').attr('name', 'itineraryLst[' + itineraryIndex + '].othr_cur').prop('required',true).end();
    
    
    //Re-initialize the fields in the validator plugin
    $(document).validator('update');
    
    })
   	 //Re-initialize the fields in the validator plugin
     $(document).validator('update');
	});

	// Remove button click handler
	$(document).on('click', '.removeButton', function() {
			var $row = $(this).closest('.form-group');
			$row.remove();
		

});