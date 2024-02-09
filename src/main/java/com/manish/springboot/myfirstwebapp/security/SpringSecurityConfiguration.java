package com.manish.springboot.myfirstwebapp.security;
import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails...details )

	@Bean
	public InMemoryUserDetailsManager createClassDetailsManager() {
		UserDetails classDetails1 = createNewClass("Class", "classA");
		UserDetails classDetails2 = createNewClass("Class2", "classB");

//		UserDetails userDetails = createNewUser();

		return new InMemoryUserDetailsManager(classDetails1, classDetails2);
	}

	private UserDetails createNewClass(String classname, String password) {
		Function<String, String> passwordEncoder = input -> 
				passwordEncoder().encode(input);

		UserDetails classDetails = User.builder()
				.passwordEncoder(passwordEncoder)
				.username(classname).password(password)
				.roles("USER", "ADMIN").build();
		return classDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}

}
