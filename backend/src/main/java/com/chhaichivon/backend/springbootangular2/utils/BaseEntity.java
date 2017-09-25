package com.chhaichivon.backend.springbootangular2.utils;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/5/2017
 * TIME   : 7:44 PM
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

}
