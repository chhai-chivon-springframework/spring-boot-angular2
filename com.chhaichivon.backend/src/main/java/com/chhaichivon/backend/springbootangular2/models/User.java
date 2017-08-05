package com.chhaichivon.backend.springbootangular2.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/5/2017
 * TIME   : 7:38 PM
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id")
	@JsonProperty("ID")
	private Long id;

	@Column(name = "name")
	@JsonProperty("NAME")
	private String name;

	@Column(name = "email", nullable = false, unique = true)
	@JsonProperty("EMAIL")
	private String email;

	@Column(name = "password")
	@JsonProperty("PASSWORD")
	private String password;

	@Column(name = "mobile")
	@JsonProperty("PHONE_NO")
	private String PhoneNo;

	private transient String confirmPassword;
}
