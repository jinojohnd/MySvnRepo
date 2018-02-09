var  itineraryIndex = 0;
$(document).ready(function(){
	
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
	}); 
	
	$('input[name="return_dt"]').datepicker({
		format: 'dd-M-yyyy',
		todayHighlight: true,
		autoclose: true,
	});			*/

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
        .find('[name="food_per_day"]').attr('name', 'itineraryLst[' + itineraryIndex + '].food_per_day').prop('required',true).end()
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
   	
	// Remove button click handler
	$(document).on('click', '.removeButton', function() {
			var $row = $(this).closest('.form-group');
			$row.remove();
			
			 //Re-initialize the fields in the validator plugin
		     $(document).validator('update');
		});
    
    $(document).on('change', '.itrDt', function() {
    	var elemnt = this.name;
    	var index = (elemnt.substr(elemnt.indexOf('[')+1)).charAt(0);
    	updateNoofDays(index, elemnt);  
    });
    
    $(document).on('blur', '.itrFTAmt', function() {
    	var elemnt = this.name;
    	var index = (elemnt.substr(elemnt.indexOf('[')+1)).charAt(0);
    	var amt = this.value;
    	var numDays = $('[name="itineraryLst['+index+'].food_days"]').val();
    	$('[name="itineraryLst['+index+'].food_total_amt"]').val(numDays * amt);
    	updateForexTotalAmt();
    });
    
    $(document).on('blur', '.itrLcTAmt', function() {
    	var elemnt = this.name;
    	var index = (elemnt.substr(elemnt.indexOf('[')+1)).charAt(0);
    	var amt = this.value;
    	var numDays = $('[name="itineraryLst['+index+'].local_conveyance_days"]').val();
    	$('[name="itineraryLst['+index+'].local_conveyance_total_amt"]').val(numDays * amt);
    	updateForexTotalAmt();
    });
    
    $(document).on('blur', '.itrHcTAmt', function() {
    	var elemnt = this.name;
    	var index = (elemnt.substr(elemnt.indexOf('[')+1)).charAt(0);
    	var amt = this.value;
    	var numDays = $('[name="itineraryLst['+index+'].hotel_days"]').val();
    	$('[name="itineraryLst['+index+'].hotel_total_amt"]').val(numDays * amt);
    	updateForexTotalAmt();
    });
    
    $(document).on('blur', '.itrOmTAmt', function() {
    	var elemnt = this.name;
    	var index = (elemnt.substr(elemnt.indexOf('[')+1)).charAt(0);
    	var amt = this.value;
    	var numDays = $('[name="itineraryLst['+index+'].othr_days"]').val();
    	$('[name="itineraryLst['+index+'].othr_total_amt"]').val(numDays * amt);
    	updateForexTotalAmt();
    });
    
    $(document).on('change', '.itrNumDays', function() {
    	var elemnt = this.name;
    	var index = (elemnt.substr(elemnt.indexOf('[')+1)).charAt(0);
    	var numDays = this.value;
    	var fieldCompleteName = elemnt.substr(elemnt.indexOf('.')+1);
    	var typeNm = fieldCompleteName.substr(0, fieldCompleteName.indexOf('_'));
    	var amt = $('[name="itineraryLst['+index+'].'+typeNm+'_days"]').val();
    	$('[name="itineraryLst['+index+'].'+typeNm+'_total_amt"]').val(numDays * amt);
    	updateForexTotalAmt();    	
    });
    
    $(document).on('blur', "#forex_card", function() {
    	$('[name="forex_card_num"]').val($('[name="forex_card"]').val());    	
    });
    
    $(document).on('change', ".itrCntry", function() {
    	var country = this.value;
    	var elemnt = this.name;
    	var index = (elemnt.substr(elemnt.indexOf('[')+1)).charAt(0);
    	
    	var cur = countryCurMap[country];
    	$('[name="itineraryLst['+index+'].food_cur"]').val(cur);
    	$('[name="itineraryLst['+index+'].local_conveyance_cur"]').val(cur);
    	$('[name="itineraryLst['+index+'].hotel_cur"]').val(cur);
    	$('[name="itineraryLst['+index+'].othr_cur"]').val(cur);
    });
    
    function updateNoofDays(index, elemnt)
    {
    	var date_1 = $('[name="'+elemnt+'"]').val();
    	var date_2;
    	var dateDiff = 0;
    	
    	if(elemnt.indexOf('return_dt') > -1) 
		{
    		date_2 = $('[name="itineraryLst['+index+'].departure_dt"]').val();
    		dateDiff = getDtDiff(date_1, date_2);
		}
    	else
		{
    		date_2 = $('[name="itineraryLst['+index+'].return_dt"]').val();
    		dateDiff = getDtDiff(date_2, date_1);
		}
    	
    	$('[name="itineraryLst['+index+'].food_days"]').val(dateDiff);
    	$('[name="itineraryLst['+index+'].local_conveyance_days"]').val(dateDiff);
    	$('[name="itineraryLst['+index+'].hotel_days"]').val(dateDiff);
    	$('[name="itineraryLst['+index+'].othr_days"]').val(dateDiff);
    	
    	updateTotalAmt(index,'food_days');
    	updateTotalAmt(index,'local_conveyance_days');
    	updateTotalAmt(index,'hotel_days');
    	updateTotalAmt(index,'othr_days');
    	updateForexTotalAmt();
    }
    
    function getDtDiff(returnDt, deptDt)
    {
    	if(returnDt !== "" && deptDt != "")
		{
    		var rDt = new Date(returnDt);
    		var dDt = new Date(deptDt);    		
    		var millisecondsPerDay = 1000 * 60 * 60 * 24;
    		
    		var millisBetween = rDt.getTime() - dDt.getTime();
    		return Math.floor(millisBetween / millisecondsPerDay) +1;    		
		}
    }
    
    function updateTotalAmt(index, fieldNm)
    {
    	var typeNm = fieldNm.substr(0, fieldNm.indexOf('_d'));
    	var numDays = $('[name="itineraryLst['+index+'].'+fieldNm+'"]').val();
    	var amt = $('[name="itineraryLst['+index+'].'+typeNm+'_per_day"]').val();
    	$('[name="itineraryLst['+index+'].'+typeNm+'_total_amt"]').val(numDays * amt);
    }
    
    function updateForexTotalAmt()
    {
    	var itrTotalAmt = 0;
    	var foodTotlAmt = 0;
    	var hotelTotlAmt = 0;
    	var localConvTotlAmt = 0;
    	var othrTotlAmt = 0;
    	
    	for(var i=0; i<=itineraryIndex; i++)
		{
    		foodTotlAmt = $('[name="itineraryLst['+i+'].food_total_amt"]').val() != "" ? parseFloat($('[name="itineraryLst['+i+'].food_total_amt"]').val()) : 0;
    		hotelTotlAmt = $('[name="itineraryLst['+i+'].hotel_total_amt"]').val() !="" ? parseFloat( $('[name="itineraryLst['+i+'].hotel_total_amt"]').val()) : 0;
    		localConvTotlAmt = $('[name="itineraryLst['+i+'].local_conveyance_total_amt"]').val() !="" ? parseFloat($('[name="itineraryLst['+i+'].local_conveyance_total_amt"]').val()) : 0;
    		othrTotlAmt = $('[name="itineraryLst['+i+'].othr_total_amt"]').val() != "" ? parseFloat($('[name="itineraryLst['+i+'].othr_total_amt"]').val()) : 0;
  
    		itrTotalAmt = itrTotalAmt + foodTotlAmt + hotelTotlAmt + localConvTotlAmt + othrTotlAmt;    	
		}
    	
    	$('[name="amt_on_card"]').val(itrTotalAmt);
    	$('[name="amt_in_cash"]').val(0);
    	var amtOnCash = $('[name="amt_in_cash"]').val() != "" ? parseFloat($('[name="amt_in_cash"]').val()) : 0;
    	$('[name="total_amt"]').val(itrTotalAmt + amtOnCash);
    }
    
});