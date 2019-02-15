package com.example.jobonics.Spring;

import java.util.Locale;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.jobonics.security.MySimpleUrlAuthenticationSuccessHandler;
import com.example.jobonics.security.SecurityWebApplicationInitializer;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.github.tutorial")
@PropertySource("classpath:application.properties")
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/", "/resources/");
        registry.addResourceHandler("/webapp/**").addResourceLocations("/webapp/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }
		
		@Bean
		public ViewResolver getViewResolver() {
			InternalResourceViewResolver resolver = new InternalResourceViewResolver();
			resolver.setPrefix("/resources");
			resolver.setSuffix("/.html");
			return resolver;
		}

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");
        registry.addViewController("/signup_employer").setViewName("recruiter_signup");
        registry.addViewController("/login").setViewName("login_recruiter");
        registry.addViewController("/Admin").setViewName("recruiter_dashboard");
       // registry.addViewController("/new_job").setViewName("new_job");
        
        
        registry.addViewController("/create_profile").setViewName("recruiter_create_profile");
        registry.addViewController("/company_profile").setViewName("company_profile");
        registry.addViewController("/invalidSession").setViewName("invalidSession");
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/successRegister").setViewName("success");
        registry.addViewController("/accessDenied").setViewName("accessDenied");
    }


    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

   /* @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new SessionListenerWithMetrics();
    }*/

    @Bean
    public ServletContextInitializer httpSessionContext() {
        return new SecurityWebApplicationInitializer();
    }

    @Bean
    public AuthenticationSuccessHandler SucessHandler() {
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        final LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }

    // beans

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
