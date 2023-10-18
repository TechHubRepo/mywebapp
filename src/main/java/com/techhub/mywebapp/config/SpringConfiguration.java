package com.techhub.mywebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
public class SpringConfiguration {

	/**
	 * SpringResourceTemplateResolver bean
	 * 
	 * @return SpringResourceTemplateResolver
	 */
	@Bean
	public SpringResourceTemplateResolver springResourceTemplateResolver() {
		SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
		springResourceTemplateResolver.setPrefix("/");
		springResourceTemplateResolver.setSuffix(".html");
		springResourceTemplateResolver.setTemplateMode("HTML5");
		return springResourceTemplateResolver;
	}

	/**
	 * SpringTemplateEngine bean
	 * 
	 * @return SpringTemplateEngine
	 */
	@Bean
	public SpringTemplateEngine springTemplateEngine(SpringResourceTemplateResolver springResourceTemplateResolver) {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(springResourceTemplateResolver);
		return springTemplateEngine;
	}

	/**
	 * ThymeleafViewResolver bean
	 * 
	 * @return ThymeleafViewResolver
	 */
	@Bean
	public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine springTemplateEngine) {
		ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
		thymeleafViewResolver.setTemplateEngine(springTemplateEngine);
		return thymeleafViewResolver;
	}
}
