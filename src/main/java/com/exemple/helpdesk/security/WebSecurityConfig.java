package com.exemple.helpdesk.security;

import com.exemple.helpdesk.security.jwt.AuthTokenFilter;
import com.exemple.helpdesk.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exemple.helpdesk.security.jwt.AuthEntryPointJwt;

import static com.exemple.helpdesk.models.ERole.ROLE_ADMIN;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	//
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/api/auth/**").permitAll()
			.antMatchers("/api/test/**").permitAll()
				.antMatchers("/addClient").permitAll()
				.antMatchers("/postmateril").permitAll()
				.antMatchers("/demande").permitAll()
				.antMatchers("/users").permitAll()

				.antMatchers("/demander").permitAll()
				.antMatchers("/demanders").permitAll()
				.antMatchers("/listdemande").permitAll()
				.antMatchers("/demanders/{id_demande}").permitAll()
				.antMatchers("/listdemande").permitAll()
				.antMatchers("/changeDemande/{id_demande}").permitAll()
				.antMatchers("/demandeCount").permitAll()

				.antMatchers("/demandeCountWaiting").permitAll()
				.antMatchers("/countClosed").permitAll()
				.antMatchers("/countCours").permitAll()
				.antMatchers("/cherchers").permitAll()
				.antMatchers("/chercherrole").permitAll()


				.antMatchers("/addDemande").permitAll()
				.antMatchers("/chercher").permitAll()
				.antMatchers("/changestatus/{id_demande}").permitAll()
				.antMatchers("/Deletedemande/{id_demande}").permitAll()


				.antMatchers("/swagger-ui/swagger-ui-bundle.js").permitAll()
				.antMatchers("/swagger-ui/swagger-ui-standalone-preset.js").permitAll()

				.antMatchers("/demandes/{id}").permitAll()
				.antMatchers("/user").permitAll()
				.antMatchers("/demane/{id_tiquete}").permitAll()
				.antMatchers("/user/{id}").permitAll()
				.antMatchers("/materiel/{id_materiel}").permitAll()
				.antMatchers("/swagger-ui/index.html").permitAll()
				.antMatchers("/v3/api-docs/swagger-config").permitAll()
				.antMatchers("/v3/api-docs").permitAll()
				.antMatchers("/materiel/{id_demande}").permitAll()
				.antMatchers("/updateTiquete/{id_tiquete}").permitAll()

				.antMatchers("/addDemandeRetour").permitAll()
				.antMatchers("/demaneRetour/{id_tiquete}").permitAll()

				.antMatchers("/demandeTelework").permitAll()
				.antMatchers("/addDemandeTelework").permitAll()
				.antMatchers("/demaneTelework/{id_demandeTelework}").permitAll()
				.antMatchers("/updateDemandeTelework/{id_demandeTelework}").permitAll()


				.antMatchers("/demandeChange").permitAll()
				.antMatchers("/addDemandeChange").permitAll()
				.antMatchers("/demaneChange/{id_tiquete}").permitAll()
				.antMatchers("/updateDemandeChange/{id_demandeChange}").permitAll()
				.antMatchers("/demandeCountRequest/{id}").permitAll()
				.antMatchers("/demandeCountChange/{id}").permitAll()
				.antMatchers("/demandeCountTelework/{id}").permitAll()
				.antMatchers("/demandeCountReturn/{id}").permitAll()
				.antMatchers("/api/email").permitAll()
				.antMatchers("/api/mails").permitAll()

				.antMatchers("/addTiquete").permitAll()
				.antMatchers("/Tiquetes").permitAll()
				.antMatchers("/Tiquete/{id_tiquete}").permitAll()
				.antMatchers("/TiqueteBy/{id}").permitAll()
				.antMatchers("/changeTiquete/{id_tiquete}").permitAll()
				.antMatchers("/changeStatusTiquete/{id_tiquete}").permitAll()
				.antMatchers("/updateTiquete/{id_tiquete}").permitAll()

				.antMatchers("/DeletedemandeTelework/{id_demandeTelework}").permitAll()
				.antMatchers("/materielByUser/{username}").permitAll()


				.antMatchers("/cherchertiquete").permitAll()

				.antMatchers("/DeletedemandDepart/{id_demandeDepart}").permitAll()
				.antMatchers("/demaneDepart/{id_demandeDepart}").permitAll()
				.antMatchers("/demandeDepart").permitAll()
				.antMatchers("/addDemandeDepart").permitAll()
				.antMatchers("/demandesDepart/{id}").permitAll()









				.antMatchers("/changeDemandeTelework/{id_demandeTelework}").permitAll()
				.antMatchers("/changestatusTelework/{id_demandeTelework}").permitAll()
				.antMatchers("/changeDemandeRetour/{id_demandeRetour}").permitAll()
				.antMatchers("/changestatusRetour/{id_demandeRetour}").permitAll()

				.antMatchers("/changeDemandeChange/{id_demandeChange}").permitAll()
				.antMatchers("/changestatusChange/{id_demandeChange}").permitAll()






				.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
