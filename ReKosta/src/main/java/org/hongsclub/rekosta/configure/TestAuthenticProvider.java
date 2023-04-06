package org.hongsclub.rekosta.configure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hongsclub.rekosta.entity.TestAuthorityEntity;
import org.hongsclub.rekosta.entity.TestEntity;
import org.hongsclub.rekosta.model.service.TestServiceKHJ;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestAuthenticProvider implements AuthenticationProvider {
	private final TestServiceKHJ testServiceKHJ;
	
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {		
		System.out.println(authentication);
		//1.파라미터로 전달받은 Authentication 객체에 대해 지정한 id , password 방식의 인증처리를 지원하지 않으면 null을 리턴한다.
		//  supports 메서드는 아래에 오버라이딩 되어있음 
		if(!supports(authentication.getClass())){
			return null;
		}
		//2.사용자 정보 DB로부터 조회
		String id = authentication.getName();//사용자가 로그인시 입력한 ID 반환 		
		Optional<TestEntity> testEntityOptional = testServiceKHJ.findMemberById(id);
		TestEntity testEntity=testEntityOptional.get();
		if(testEntity == null){
			throw new UsernameNotFoundException("회원 아이디가 존재하지 않습니다");
		}
		String password=(String)authentication.getCredentials();//사용자가 입력한 패스워드 반환 
		
		/*
		 * if (!passwordEncoder.matches(password, testEntity.getPassword()))//! 비밀번호가
		 * 일치하지 않으면 throw new BadCredentialsException("비밀번호가 일치하지 않습니다");
		 */
		if(!password.equals(testEntity.getPassword())) {
			throw new BadCredentialsException("비밀번호가 일치하지 않습니다");
		}
		//4.사용자 권한 조회
		List<TestAuthorityEntity> list = testServiceKHJ.findAuthorityById(id);
		// 권한이 하나 이상 없으면 자격 증명이 불충분한 것으로 판단한다
		// ( 회원가입시 ROLE_MEMBER 로 권한이 자동 등록되도록 MemberService 에 구현되어 있음 ) 
		if(list.size() == 0){ 
			throw new InsufficientAuthenticationException("권한이 없습니다.");
		}
		// 회원과 권한이 1 대 다 이므로 권한을 리스트로 저장해서 반환할 Authentication 에 할당한다 
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();		
		for(TestAuthorityEntity au : list){ // ROLE_ 형식의 db 정보가 아니라면 이 시점에 ROLE_ 를 접두어로 추가한다
			authorities.add(new SimpleGrantedAuthority(au.getRole()));
		}
				
		Authentication auth = new UsernamePasswordAuthenticationToken(testEntity, password, authorities);
		log.debug("MemberAuthenticationProvider 인증처리완료:{}",auth);
		return auth;		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		//현재 MemberAuthenticationProvider가  지정된 Authentication 객체가 id,password 인증방식이면 true를 반환한다 
		//위의 authenticate 메서드 인증로직 첫 시점에 비교한다 
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}	
}
