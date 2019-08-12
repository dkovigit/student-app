package com.app.security;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.server.ServerWebExchange;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private JwtTokenProvider jwtTokenProvider;
  
  @Autowired
  LocalUserDetailService localUserDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // Disable CSRF (cross site request forgery)
    http.csrf().disable();

    // No session will be created or used by spring security
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // Entry points
    http.authorizeRequests()//
        .antMatchers("/users/signin").permitAll()//
        .antMatchers("/users/signup").permitAll()//
        .antMatchers("/h2-console/**/**").permitAll()
        // Disallow everything else..
        .anyRequest().authenticated();

    // If a user try to access a resource without having enough permissions
    http.exceptionHandling().accessDeniedPage("/login");

    // Apply JWT
    http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

    // Optional, if you want to test the API from a browser
    // http.httpBasic();
  }
  
	/*
	 * @Bean CorsConfigurationSource corsConfigurationSource() {
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	 * new CorsConfiguration().applyPermitDefaultValues()); return source; }
	 */
  
	/*
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/greeting-javaconfig").allowedOrigins(
	 * "http://localhost:9000"); }
	 */
  
  
	/*
	 * private static final String ALLOWED_HEADERS =
	 * "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN"
	 * ; private static final String ALLOWED_METHODS =
	 * "GET, PUT, POST, DELETE, OPTIONS"; private static final String ALLOWED_ORIGIN
	 * = "*"; private static final String MAX_AGE = "3600";
	 */

	/*
	 * @Bean public WebFilter corsFilter() { return (ServerWebExchange ctx,
	 * WebFilterChain chain) -> { ServerHttpRequest request = ctx.getRequest(); if
	 * (CorsUtils.isCorsRequest(request)) { ServerHttpResponse response =
	 * ctx.getResponse(); HttpHeaders headers = response.getHeaders();
	 * headers.add("Access-Control-Allow-Origin", ALLOWED_ORIGIN);
	 * headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);
	 * headers.add("Access-Control-Max-Age", MAX_AGE);
	 * headers.add("Access-Control-Allow-Headers",ALLOWED_HEADERS); if
	 * (request.getMethod() == HttpMethod.OPTIONS) {
	 * response.setStatusCode(HttpStatus.OK); return Mono.empty(); } } return
	 * chain.filter(ctx); }; }
	 */
  
  private static final String FRONTEND_LOCALHOST = "http://localhost:4200";
  
  @Bean
  public CorsFilter corsFilter() {
      final UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
      final CorsConfiguration config=new CorsConfiguration();
      config.setAllowCredentials(true);
      config.addAllowedHeader("*");
      config.addAllowedOrigin("*");
      config.addAllowedMethod("OPTIONS");
      config.addAllowedMethod("POST");
      config.addAllowedMethod("GET");
      config.addAllowedMethod("PUT");
      config.addAllowedMethod("DELETE");
      source.registerCorsConfiguration("/**", config);
      return new CorsFilter((CorsConfigurationSource) source);

  }
	/*
	 * @Bean CorsWebFilter corsWebFilter() { CorsConfiguration corsConfig = new
	 * CorsConfiguration(); corsConfig.applyPermitDefaultValues();
	 * corsConfig.addAllowedMethod(HttpMethod.PUT);
	 * corsConfig.addAllowedMethod(HttpMethod.DELETE);
	 * corsConfig.setAllowedOrigins(Arrays.asList(FRONTEND_LOCALHOST));
	 * corsConfig.setAllowCredentials(true);
	 * 
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	 * corsConfig);
	 * 
	 * return new CorsWebFilter(source); }
	 */
  
  @Bean
  public ModelMapper modelMapper() {
     ModelMapper modelMapper = new ModelMapper();
     return modelMapper;
  }
  
  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // Allow swagger to be accessed without authentication
    web.ignoring().antMatchers("/v2/api-docs")//
        .antMatchers("/swagger-resources/**")//
        .antMatchers("/swagger-ui.html")//
        .antMatchers("/configuration/**")//
        .antMatchers("/search")
        .antMatchers("/progress")
       // .antMatchers("/users/**")
        .antMatchers("/progress/**")
        
        .and()
        .ignoring()
        .antMatchers("/h2-console/**/**");;
  }
  @Autowired
  public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
      auth.authenticationProvider(daoAuthenticationProvider());
  }

  @Bean
  public AuthenticationProvider daoAuthenticationProvider() {
      DaoAuthenticationProvider impl = new DaoAuthenticationProvider();
      impl.setUserDetailsService(localUserDetailsService);
      impl.setPasswordEncoder(new BCryptPasswordEncoder(12));
      impl.setHideUserNotFoundExceptions(false) ;
      return impl;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }

}
