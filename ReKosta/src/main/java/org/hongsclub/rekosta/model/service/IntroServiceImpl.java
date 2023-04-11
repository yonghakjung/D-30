package org.hongsclub.rekosta.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;
import javax.transaction.Transactional;

import org.hongsclub.rekosta.entity.IntroEntity;
import org.hongsclub.rekosta.repository.IntroRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IntroServiceImpl implements IntroService{
	private final IntroRepository introRepository;
	@Transactional
	public boolean writePostIntro(String id, String category, String title, StringBuilder content) {
		IntroEntity introEntity=new IntroEntity();
		introEntity.setId(id);
		introEntity.setCategory(category);
		introEntity.setTitle(title);
		SerialClob clobContent;
		try {
			clobContent = new SerialClob(content.toString().toCharArray());
			introEntity.setContent(clobContent);
			LocalDateTime now = LocalDateTime.now();
			introEntity.setPost_date(Date.valueOf(now.toLocalDate()));;
			System.out.println(introEntity);
			introRepository.save(introEntity);		
		} catch (SerialException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public IntroEntity readIntroPostDetail(int post_no) {
		IntroEntity introEntity = introRepository.findById(post_no).get();
		
		System.out.println(introEntity);
		return introEntity;
	}
	@Override
	public StringBuilder readIntroPostContentDetail(int post_no) throws SQLException, IOException {
		Clob clob = introRepository.findById(post_no).get().getContent();//Clob데이터형은 기본적으로 데이터베이스에서 사용되는 자료형으로써 java에서 사용하기에는 부적절	
		Reader reader = clob.getCharacterStream();
		//getCharactherStream은 clob데이터를 읽기위한 reader클래스를 반환함. Reader클래스는 텍스트 데이터를 문자로 변환함
		//즉 데이터베이스에 텍스트데이터 형태로 저장되어있는 정보를 가져온 뒤 getCharacterStream을 사용하여 문자로 변환하는 Reader 클래스를 만듦
		BufferedReader bufferedReader = new BufferedReader(reader); //문자를 문자열로 만드는 변환기
		StringBuilder contentStringBuilder = new StringBuilder();//데이터 용량이 커서 String 대신 StringBuilder클래스를 사용함
		String line;//BufferReader를 통해 문자에서 문자열(문장)으로 만들어진걸 저장할 String 객체
		while ((line = bufferedReader.readLine()) != null) {//문자->문자열로 바뀐걸 한 줄 한 줄 변환해서
			contentStringBuilder.append(line);//StringBuilder클래스에 추가해줌.
		}
		
		return contentStringBuilder;
	}
	
	
	

	
}
