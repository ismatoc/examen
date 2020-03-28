package com.viking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class VehiculoSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
		.antMatchers("/getVehiculos").hasAnyRole("ADMIN")
		.antMatchers("/acercade").hasAnyRole("USER", "ADMIN")
		.antMatchers("/addNewVehiculo").hasAnyRole("USER").anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().permitAll();

		http.csrf().disable();
	}


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser("perfil1").password("perfil1").authorities("ROLE_USER").and()
				.withUser("perfil2").password("perfil2").authorities("ROLE_USER", "ROLE_ADMIN").and()
				.withUser("admin").password("admin").authorities("ROLE_USER","ROLE_ADMIN");
	}

}