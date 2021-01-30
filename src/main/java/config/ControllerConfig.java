package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import controller.ProfileEditController;
import controller.LoginController;
import controller.LogoutController;
import controller.MemberRegisterController;
import controller.MessageController;
import controller.admin.MemberListController;
import controller.admin.MessageSendController;

@Configuration
@EnableWebSecurity
public class ControllerConfig {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public LoginController loginController() {
		return new LoginController();
	}

	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}

	@Bean
	public MemberRegisterController memberRegisterController() {
		return new MemberRegisterController();
	}

	@Bean
	public ProfileEditController profileEditController() {
		return new ProfileEditController();
	}
	
	@Bean
	public MemberListController memberListController() {
		return new MemberListController();
	}
	
	@Bean
	public MessageSendController messageSendController() {
		return new MessageSendController();
	}
	
	@Bean
	public MessageController messageListController() {
		return new MessageController();
	}
	
}
