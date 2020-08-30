package com.liu.sourceProject.easyExcel.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-08-30 09:21:25
 */
@Data
public class Student implements Serializable {
	private static final long serialVersionUID = -44119409465616940L;

	private Object id;

	private String studentName;

	private long studentNumber;

	private String collegeName;


}