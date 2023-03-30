package org.hongsclub.rekosta.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//스프링 시큐리티 설정 클래스 
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity 어노테이션은 @Secured @PreAuthorize, @PostAuthorize 애노테이션을 사용하여 인증,인가 처리를 하고 싶을때 사용하는 설정
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityConfigure  {

   //비밀번호 암호화를 위한 bean 생성 -> MemberService 에서 비번 암호화를 위해 사용 , 
   //MemberAuthenticationProvider 에서 비번 일치여부를 위해 사용 
   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();   // 비밀번호 암호화 객체
      return encoder;
   }
	/*
	 * @Bean SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 * http.authorizeHttpRequests(requests -> requests.antMatchers(
	 * "/images/**","/layout/**","/home","/index","/","/content/**","/**"
	 * ).permitAll() .anyRequest().authenticated()); http.formLogin(login ->
	 * login.loginPage("/login/loginform") .loginProcessingUrl("/login")
	 * .failureUrl("/login_fail") .defaultSuccessUrl("/home", true)
	 * .usernameParameter("id") .passwordParameter("password")) .formLogin(login ->
	 * login.permitAll()); http.logout(logout ->
	 * logout.permitAll().logoutUrl("/logout").logoutSuccessUrl("/home").
	 * invalidateHttpSession(true)); //http.exceptionHandling(handling ->
	 * handling.authenticationEntryPoint(new
	 * CustomAuthenticationEntryPoint("/loginForm")));
	 * http.exceptionHandling(handling ->
	 * handling.accessDeniedPage("/accessDeniedView"));
	 * 
	 * return http.build(); }
	 */
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
           .authorizeRequests()
               .antMatchers("/loginForm", "/login","/images/**","/layout/**").permitAll()
               .anyRequest().authenticated()
               .and()
           .formLogin()
               .loginPage("/loginForm")
               .loginProcessingUrl("/login")
               .defaultSuccessUrl("/home")
               .and()
           .logout()
               .logoutUrl("/logout")
               .logoutSuccessUrl("/loginForm");

       return http.build();
   }
   

}