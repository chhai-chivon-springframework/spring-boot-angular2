package com.chhaichivon.backend.springbootangular2.models;

import com.chhaichivon.backend.springbootangular2.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "tb_user")
public class User extends BaseEntity{

	@Column(name = "name")
	@JsonProperty("NAME")
	private String name;

	@Column(name = "email")
	@JsonProperty("EMAIL")
	private String email;

	@Column(name = "password")
	@JsonProperty("PASSWORD")
	private String password;

	@Column(name = "mobile")
	@JsonProperty("MOBILE")
	private String mobile;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_user_role",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

}
