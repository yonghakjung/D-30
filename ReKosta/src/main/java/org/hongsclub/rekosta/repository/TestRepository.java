package org.hongsclub.rekosta.repository;

import org.hongsclub.rekosta.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TestRepository extends JpaRepository<TestEntity, String>{


	
}
