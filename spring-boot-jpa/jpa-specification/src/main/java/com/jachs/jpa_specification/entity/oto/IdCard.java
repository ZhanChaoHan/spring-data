package com.jachs.jpa_specification.entity.oto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/***
 * 
 * @author zhanchaohan
 *
 */
@Data
@Entity
@Table(name="IdCard")
public class IdCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "cId")
	private Long CId;
	
	@Column(name = "Name")
	private String Name;
	@Column(name = "Age")
	private int Age;
	@Column(name = "Address")
	private String Address;
	@Column(name = "BirthDay")
	private Date BirthDay;
}
