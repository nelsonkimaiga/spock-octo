package com.example.jobonics.configuration;

import com.example.jobonics.security.MySimpleUrlAuthenticationSuccessHandler;
import com.example.jobonics.security.SecurityWebApplicationInitializer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import java.util.Locale;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.example.jobonics")
@PropertySource("classpath:application.properties")
public class MvcConfig extends WebMvcConfigurerAdapter {
	// password encoding
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/resources");
		resolver.setSuffix("/.html");
		return resolver;
	}

	// Resource handling for serving static content
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
		"classpath:/META-INF/resources/", "classpath:/resources/",
		"classpath:/static/", "/favicon.png" 
	};
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
            .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");
        registry.addViewController("/registration").setViewName("register");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/Admin").setViewName("recruiter_dashboard");
        registry.addViewController("/invalidSession").setViewName("invalidSession");
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/successRegister").setViewName("successRegister");
        registry.addViewController("/accessDenied").setViewName("accessDenied");
    }

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
	}
	
	
	  @Bean
	  public LocaleResolver localeResolver() {
		  final CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		  cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		  return cookieLocaleResolver;
	  }
  
	  @Bean
	  public MessageSource messageSource() {
		  final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		  messageSource.setBasename("classpath:messages");
		  messageSource.setUseCodeAsDefaultMessage(true);
		  messageSource.setDefaultEncoding("UTF-8");
		  messageSource.setCacheSeconds(0);
		  return messageSource;
	  }

}