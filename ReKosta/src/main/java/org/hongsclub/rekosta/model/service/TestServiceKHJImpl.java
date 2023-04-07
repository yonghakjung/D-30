package org.hongsclub.rekosta.model.service;

import java.util.List;
import java.util.Optional;

import org.hongsclub.rekosta.entity.TestAuthorityEntity;
import org.hongsclub.rekosta.entity.TestEntity;
import org.hongsclub.rekosta.repository.TestAuthenticRepository;
import org.hongsclub.rekosta.repository.TestRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestServiceKHJImpl implements TestServiceKHJ{
	private final TestRepository testRepository;
	private final TestAuthenticRepository testAuthenticRepository;
	
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Transactional // AOP 
	@Override
	public void registerMember(TestEntity testEntity) {
		// 비밀번호를 bcrypt 알고리즘으로 암호화하여 DB에 저장한다
		String encodedPwd = passwordEncoder.encode(testEntity.getPassword());
		testEntity.setPassword(encodedPwd);
		testRepository.save(testEntity);
		// 회원 가입시 반드시 권한이 등록되도록 트랜잭션처리를 한다
		TestAuthorityEntity testAuthority = new TestAuthorityEntity(testEntity.getId(), "ROLE_MEMBER");
		testAuthenticRepository.save(testAuthority);
	}
	
	@Override
	public Optional<TestEntity> findMemberById(String id) {
		return testRepository.findById(id);
	}
	@Override
	public List<TestAuthorityEntity> findAuthorityById(String id) {
		return testAuthenticRepository.findAuthorityById(id);
	}
}
