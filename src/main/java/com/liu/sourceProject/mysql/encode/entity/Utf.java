package com.liu.sourceProject.mysql.encode.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Utf)实体类
 *
 * @author makejava
 * @since 2020-09-10 09:11:57
 */
@Data
public class Utf implements Serializable {
	private static final long serialVersionUID = -34086955030841185L;

	private Integer id;

	private String code;


}