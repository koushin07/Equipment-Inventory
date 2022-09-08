package com.miko.eprris;

import com.miko.eprris.domain.user.AppUser;
import com.miko.eprris.domain.user.UserService;
import com.miko.eprris.domain.user.role.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class EprrisApplication {

	public static void main(String[] args) {
		SpringApplication.run(EprrisApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

/*@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_MUNICIPALITY"));
			userService.saveRole(new Role(null, "ROLE_PROVINCE"));
			userService.saveRole(new Role(null, "ROLE_RDRRMC"));


			userService.saveUser(
					new AppUser(
							null,
							"miko",
							"miko",
							"miko@miko.com",
							"1234",
							new ArrayList<>()));
			userService.saveUser(
					new AppUser(
							null,
							"nikko",
							"nikko",
							"nikko@nikko.com",
							"1234",
							new ArrayList<>()));
			userService.addRoleToUser("miko", "ROLE_MUNICIPALITY");
			userService.addRoleToUser("miko", "ROLE_PROVINCE");
			userService.addRoleToUser("miko", "ROLE_RDRRMC");
			userService.addRoleToUser("nikko", "ROLE_MUNICIPALITY");
		};
	}*/

	@Bean
	public CorsFilter corsFilter(){
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST","PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}


}
