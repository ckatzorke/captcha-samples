var loadCaptcha = function(){
	grecaptcha.render('recaptcha', {
		'sitekey': '6LfuXhETAAAAAAFt9_phps2VdbyqZb8WIL4YCUqH',
		'theme': 'light',
		'callback': function(response){
			reCaptchaResponse = response;
			console.log(reCaptchaResponse);
		}
	});
};
var reCaptchaResponse = '';

$('document').ready(function() {
	$('#recaptchaValidate').click(function() {
		$.post("/recaptcha/validate", {
			'reCaptchaResponse' : reCaptchaResponse
		}).done(function(data) {
			if(data.success){
//				$('#gcageform').removeClass('has-error').addClass('has-success');
				$('#recaptchaValidate > span').attr('class', 'glyphicon glyphicon-ok-sign');
			} else {
//				$('#gcageform').removeClass('has-success').addClass('has-error');
				$('#recaptchaValidate > span').attr('class', 'glyphicon glyphicon-remove-sign');
			}
		});
	});
});