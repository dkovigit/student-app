package com.app;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.app.model.Role;
import com.app.model.User;
import com.app.security.LocalUserDetailService;
import com.app.service.UserService;

import springfox.documentation.swagger2.mappers.ModelMapper;

//import springfox.documentation.swagger2.mappers.ModelMapper;

@SpringBootApplication
public class StudentAppApplication implements org.springframework.boot.CommandLineRunner {

	@Autowired
	UserService userService;
	
	SolrClient solrClient;
	
	@Value("${solr.server.url}")
	private String solrUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
	}
	
	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean public WebMvcConfigurer corsConfigurer() { return new
	 * WebMvcConfigurerAdapter() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**").allowedOrigins("*"); } }; }
	 */

	
	/*
	 * @Bean public ModelMapper modelMapper() { return new ModelMapper() { }; }
	 */
	 

	@Override
	public void run(String... params) throws Exception {
		/*
		 * User admin = new User(); admin.setUsername("admin");
		 * admin.setPassword("admin"); admin.setEmail("test1@email.com");
		 * admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));
		 * 
		 * userService.signup(admin);
		 * 
		 * User client = new User(); client.setUsername("client");
		 * client.setPassword("client"); client.setEmail("test2@email.com");
		 * client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));
		 * 
		 * userService.signup(client);
		 */
	}
	
	  @Bean
	  public SolrClient getSolrClient() {
		solrClient = new HttpSolrClient.Builder(solrUrl)
				.build();
		
     	return solrClient;
	  }

}
