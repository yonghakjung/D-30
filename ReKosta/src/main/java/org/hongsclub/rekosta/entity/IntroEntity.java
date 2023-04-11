package org.hongsclub.rekosta.entity;

import java.sql.Clob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="intro")
@AllArgsConstructor
@NoArgsConstructor
public class IntroEntity {
	@Column(name="post_no")
	@Id
	private int post_no;
	@Column
	private String category;
	@Column
	private String title;
	@Lob
	private Clob content;
	@Column
	private String id;
	@Column
	private Date post_date;
	@Column
	private Date update_date;
	 
	
}
