package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.EditController;
import controller.LoginController;
import controller.LogoutController;
import controller.MemberRegisterController;
import controller.ProfileController;

@Configuration
public class ControllerConfig {
	
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
	public EditController editController() {
		return new EditController();
	}
	
	@Bean
	public ProfileController profileController() {
		return new ProfileController();
	}
}
