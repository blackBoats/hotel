package com.fk.hotel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@Import({SecurityConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/");
		resolver.setSuffix(".html");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	 @Bean
	    public MultipartResolver multipartResolver() {
	        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	        resolver.setMaxUploadSize(1024*1024*1024);
	        return resolver;
	    }
	@Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/control/**").addResourceLocations("classpath:/control/");
	        registry.addResourceHandler("/images/**").addResourceLocations("file:G:/images/");
	        super.addResourceHandlers(registry);
	  }
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configure){
		configure.enable();
	}
}
