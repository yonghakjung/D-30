package org.hongsclub.rekosta.entity;

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
public class TestEntity {
	@Id
	@Column(name="id")
	private String id;
	@Column
	private String password;
	@Column
	private String name;
}
