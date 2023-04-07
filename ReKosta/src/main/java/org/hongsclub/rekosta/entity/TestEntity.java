package org.hongsclub.rekosta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "khj_member_test")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity implements Serializable{
	private static final long serialVersionUID = -3111611412349521110L;
	@Id
	@Column(name="id")
	private String id;
	@Column
	private String password;
	@Column
	private String name;
	
	public TestEntity(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
