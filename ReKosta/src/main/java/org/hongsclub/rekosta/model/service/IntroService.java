package org.hongsclub.rekosta.model.service;

import java.io.IOException;
import java.sql.SQLException;

public interface IntroService {

	public boolean writePostIntro(String id, String category, String title, StringBuilder content);

	public Object readIntroPostDetail(int post_no);

	public Object readIntroPostContentDetail(int post_no) throws SQLException, IOException;


}
