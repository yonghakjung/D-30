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
	 * @Bean SecurityFilterChain securityFilterChain(HttpSecurity http) throws
	 * Exception { http .authorizeHttpRequests(requests -> requests
	 * .antMatchers("/loginForm", "/login", "/images/**",
	 * "/layout/**","/home","/index","/","/content/**","/**").permitAll()
	 * .anyRequest().authenticated()) .formLogin(login -> login
	 * .loginPage("/loginForm") .loginProcessingUrl("/login")
	 * .defaultSuccessUrl("/home")) .logout(logout -> logout .logoutUrl("/logout")
	 * .logoutSuccessUrl("/loginForm"));
	 * 
	 * return http.build(); }
	 */
   @Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {		
		http.authorizeRequests().antMatchers("/loginForm", "/login", "/images/**","/layout/**","/home","/index","/","/content/**","/**").permitAll()
		.anyRequest().authenticated();
		
		// 인증(authentication): 로그인을 위한 설정
		http.formLogin().loginPage("/loginform") // 로그인 폼이 있는 url
				.loginProcessingUrl("/login")// login form 의 action 경로 ==> templates/fragments/left.html의 로그인 폼에서 확인 
				.failureUrl("/login_fail") // 로그인 실패시 메세지 보여줄 url ==> MemberController에서 메서드 정의 
				.defaultSuccessUrl("/home",true) // 로그인 성공 후 이동할 url, 두번째 인자값 true는 로그인 성공 후 결과페이지 경로를 고정하기 위해서
				.usernameParameter("username") // 로그인 폼 아이디 name 
				.passwordParameter("password")//로그인 폼에서 전달할 패스워드 name 
				.and() 
				.formLogin().permitAll();//로그인 폼은 인증없이 접근하도록 설정 
		// 로그아웃을 위한 설정, 로그아웃 처리 후 로그인 폼이 있는 home으로 이동 , session invalidate (무효화한다) 
		http.logout().permitAll().logoutUrl("/logout").logoutSuccessUrl("/home").invalidateHttpSession(true);

		//http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint("/home"));

		http.exceptionHandling().accessDeniedPage("/accessDeniedView");	
		
		return http.build();
	}
   

}