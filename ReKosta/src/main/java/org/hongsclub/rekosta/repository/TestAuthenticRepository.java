package org.hongsclub.rekosta.repository;

import java.util.List;

import org.hongsclub.rekosta.entity.TestAuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TestAuthenticRepository extends JpaRepository<TestAuthorityEntity, String>{

	List<TestAuthorityEntity> findAuthorityById(String id);
	
}
