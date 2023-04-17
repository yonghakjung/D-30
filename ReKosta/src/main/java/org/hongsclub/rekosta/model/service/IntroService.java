package org.hongsclub.rekosta.model.service;

import org.hongsclub.rekosta.entity.IntroEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IntroService {
	//글쓰기
	public boolean writePostIntro(String id, String category, String title, StringBuilder content);
	//제목, 작성자, 작성일 등등
	//public Object readIntroPostDetail(List<IntroEntity> list);
	//content
	//public Object readIntroPostContentDetail(List<IntroEntity> list) throws SQLException, IOException;
	//intro 게시판 글 개수
	public int introListCnt();
	//intro 게시글이 들어가 있는 리스트 페이징네이션
	public Page<IntroEntity> introList(Pageable pageable);


	

	


}
