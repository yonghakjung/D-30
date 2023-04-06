package org.hongsclub.rekosta.model.service;

import java.util.List;
import java.util.Optional;

import org.hongsclub.rekosta.entity.TestAuthorityEntity;
import org.hongsclub.rekosta.entity.TestEntity;

public interface TestServiceKHJ {
	Optional<TestEntity> findMemberById(String id);

	List<TestAuthorityEntity> findAuthorityById(String id);

	void registerMember(TestEntity testEntity);
}
