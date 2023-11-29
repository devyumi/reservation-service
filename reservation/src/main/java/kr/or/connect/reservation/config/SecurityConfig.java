package kr.or.connect.reservation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.or.connect.reservation.service.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/api/v2/**", "/v2/api-docs", "/webjars/**", "/swagger/**", "/swagger-resources/**", "swagger-ui.html");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/", "/users/loginerror", "api/v1/categories", "api/v1/displayinfos/**", "api/v1/promotions").permitAll()
			.antMatchers("/users/**", "api/v1/comments", "api/v1/reservationinfos").hasRole("USER")
			.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/users/loginform")
				.usernameParameter("userId")
				.passwordParameter("password")
                .loginProcessingUrl("/authenticate")
                .failureForwardUrl("/users/loginerror?login_error=1")
                .defaultSuccessUrl("/",true)
				.permitAll()
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/");
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}