package org.katzorke;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/captcha.html").setViewName("captcha");
        registry.addViewController("/cage.html").setViewName("cage");
        registry.addViewController("/recaptcha.html").setViewName("recaptcha");
    }

}
