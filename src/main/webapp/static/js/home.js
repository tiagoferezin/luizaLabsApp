$(document).ready(function() {

	$('.btn-get').click(function(){
		var url = $('#urlGet').val();
		$.get(url, function(data){
			alert("Result: " + data);
		});
	});
	
	

});