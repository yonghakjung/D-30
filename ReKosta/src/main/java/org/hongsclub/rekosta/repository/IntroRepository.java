package org.hongsclub.rekosta.repository;

import org.hongsclub.rekosta.entity.IntroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface IntroRepository extends JpaRepository<IntroEntity, Integer>{
	@Query("select Max(post_no) from IntroEntity")
	int introListCnt();

}
