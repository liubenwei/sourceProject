package com.liu.sourceProject.easyExcel.handler;

import java.io.InputStream;

/**
 * @author liu
 * @Date 2020/8/29 15:42
 *
 *       excel导入的处理器
 */
public interface ImportHandler {

	default void handle(InputStream excel, Long userId){

	}
	default void handle(InputStream excel){
	}
}
