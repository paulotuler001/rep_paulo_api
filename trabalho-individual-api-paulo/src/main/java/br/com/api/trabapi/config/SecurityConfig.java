package br.com.api.trabapi.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.api.trabapi.repositories.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UsuarioRepository userRepo;

	@Autowired
	JWTFilter filter;

	@Autowired
	UserDetailsServiceImpl uds;

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
	protected void configure(HttpSecurity http) throws Exception { // Metodo encarregado de configurar a seguranca da
																	// API
		http.cors().and().csrf().disable().httpBasic().disable().authorizeHttpRequests()
				.antMatchers("/usuario/login", "/usuario/registro", "/roles", "/apartamento/listar",
						"/apartamento/count", "/aluguel/count")
				.permitAll()
				.antMatchers("/usuario/{id}", "/usuario/deletarLogico/{id}",  "/endereco/{id}",
						"/endereco/deletarLogico/{id}", "/endereco/listar", "/apartamento/atualizar/{id}",
						"/apartamento/deletarLogico/{id}", "/apartamento/salvar", "/aluguel/listar")
				.permitAll()
				.antMatchers("/usuario/count","/usuario/listar","/usuario/recuperarConta/{id}", "/usuario/recuperarSenha/{id}",
						"/endereco/atualizar/{id}", "/endereco/count", "/endereco/reativacaoDeEndereco/{id}",
						"/endereco/salvar", "/apartamento/{id}", "/apartamento/count", "/aluguel/deletarLogico/{id}",
						"/aluguel/salvar")
				.permitAll()
				.and().userDetailsService(uds).exceptionHandling()
				.authenticationEntryPoint((request, response, authException) -> response
						.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized"))
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}

//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		http.authorizeHttpRequests().anyRequest().permitAll().and().csrf(csrf -> csrf.disable());
//		return http.build();
//	}
}
