package com.liu.sourceProject.mysql.encode.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (UtfMb)实体类
 *
 * @author makejava
 * @since 2020-09-10 09:12:23
 */
@Data
public class UtfMb implements Serializable {
	private static final long serialVersionUID = -36700799278660747L;

	private Integer id;

	private String code;


}