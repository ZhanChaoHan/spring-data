package com.jachs.jpa_specification.entity.oto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/***
 * 
 * @author zhanchaohan
 *
 */
@Data
@Entity
@Table(name = "Person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "pId")
	private Long PId;

	@Column(name = "NickName")
	private String NickName;
	@Column(name = "Email")
	private String Email;

	@OneToOne(cascade = CascadeType.ALL)
	private IdCard  PCard;
}
