package br.com.gustavoantunes.loja;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//Filtro não está funcionando
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/compra")
			.hasRole("USER");
	}
}