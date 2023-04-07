package org.hongsclub.rekosta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "khj_authentication_test")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestAuthorityEntity{
	@Id
	@Column(name="id")
    private String id;
	
	@Column
	private String role;
}
