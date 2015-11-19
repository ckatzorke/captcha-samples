$('document').ready(function() {
	$('#gcagebtn').click(function() {
		$.post("/cage/gvalidate", {
			token : $('#gcage').val()
		}).done(function(data) {
			if(data){
				$('#gcageform').removeClass('has-error').addClass('has-success');
				$('#gcagebtn > span').attr('class', 'glyphicon glyphicon-ok-sign');
			} else {
				$('#gcageform').removeClass('has-success').addClass('has-error');
				$('#gcagebtn > span').attr('class', 'glyphicon glyphicon-remove-sign');
			}
		});
	});
	$('#ycagebtn').click(function() {
		$.post("/cage/yvalidate", {
			token : $('#ycage').val()
		}).done(function(data) {
			if(data){
				$('#ycageform').removeClass('has-error').addClass('has-success');
				$('#ycagebtn > span').attr('class', 'glyphicon glyphicon-ok-sign');
			} else {
				$('#ycageform').removeClass('has-success').addClass('has-error');
				$('#ycagebtn > span').attr('class', 'glyphicon glyphicon-remove-sign');
			}
		});
	});
});