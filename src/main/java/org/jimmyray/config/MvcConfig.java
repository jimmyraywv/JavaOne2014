package org.jimmyray.config;

import org.jimmyray.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.jimmyray.mvc.contoller",
		"org.jimmyray.util.spring", "org.jimmyray.services" })
// @EnableCaching
public class MvcConfig extends WebMvcConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MvcConfig.class);

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/rest/**").addResourceLocations("/rest/");
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/*
	 * @Bean public SimpleMappingExceptionResolver exceptionResolver() {
	 * SimpleMappingExceptionResolver exceptionResolver = new
	 * SimpleMappingExceptionResolver();
	 * 
	 * Properties exceptionMappings = new Properties();
	 * 
	 * exceptionMappings.put(Constants.EXCEPTION, Constants.VIEW_500);
	 * exceptionMappings.put(Constants.RUNTIME_EXCEPTION, Constants.VIEW_500);
	 * 
	 * exceptionResolver.setExceptionMappings(exceptionMappings);
	 * 
	 * Properties statusCodes = new Properties();
	 * 
	 * statusCodes.put(Constants.VIEW_404, Constants.ERROR_404);
	 * statusCodes.put(Constants.VIEW_500, Constants.ERROR_500);
	 * 
	 * exceptionResolver.setStatusCodes(statusCodes);
	 * 
	 * return exceptionResolver; }
	 */

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix(Constants.VIEW_RESOLVER_PREFIX);
		viewResolver.setSuffix(Constants.VIEW_RESOLVER_SUFFIX);
		viewResolver.setViewClass(JstlView.class);

		return viewResolver;
	}

	/*
	 * @Bean(name=Constants.RESPONDER_SERVICE_BEAN) public ResponderService
	 * responderService() {
	 * 
	 * ResponderService responderService = new ResponderServiceImpl();
	 * 
	 * return responderService; }
	 */

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(StringUtils
				.parseLocaleString("en"));
		return cookieLocaleResolver;
	}

	/*
	 * @Bean public MessageSource messageSource() {
	 * ReloadableResourceBundleMessageSource messageSource = new
	 * ReloadableResourceBundleMessageSource();
	 * messageSource.setBasenames("classpath:messages"); // if true, the key of
	 * the message will be displayed if the key is not // found, instead of
	 * throwing a NoSuchMessageException
	 * messageSource.setUseCodeAsDefaultMessage(true);
	 * messageSource.setDefaultEncoding("UTF-8"); // # -1 : never reload, 0
	 * always reload messageSource.setCacheSeconds(0);
	 * 
	 * LOGGER.debug("Message Bundle INIT:  " +
	 * messageSource.getMessage("applicationBuilder", null, "NOT_FOUND", new
	 * Locale("en")));
	 * 
	 * return messageSource; }
	 */

}
