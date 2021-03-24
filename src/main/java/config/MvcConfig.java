package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import interceptor.AdminCheckInterceptor;
import interceptor.AuthCheckInterceptor;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home/main");
		registry.addViewController("/profile/message").setViewName("profile/message");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckInterceptor()).addPathPatterns("/edit/**", "/profile/**", "/admin/**");
		registry.addInterceptor(adminCheckInterceptor()).addPathPatterns("/admin/**");
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasenames("message.label");
		ms.addBasenames("message.error");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}
	
	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
	
	@Bean
	public AdminCheckInterceptor adminCheckInterceptor() {
		return new AdminCheckInterceptor();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
