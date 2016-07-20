# captcha-samples

collection of catcha examples. Just a playground, not valid code.
Start as boot app

	mvn spring-boot:run -Dgrecaptcha.secretKey=<yoursecretkeyfromgoogle>
	
and visit http://localhost:8080/captcha.html


# Google reCaptcha

Get your own keyset from https://www.google.com/recaptcha/admin#list
If you do not want to use reCaptcha, you still have to provide a secret, but just use anystring

# Cage

Infos: https://akiraly.github.io/cage/
