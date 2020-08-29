package com.liu.sourceProject.easyExcel.handler;

import com.liu.sourceProject.easyExcel.validate.ValidateResult;

import java.io.InputStream;
import java.util.List;

/**
 * @author liu
 * @Date 2020/8/29 15:48
 */
public abstract class AbstractImportHandler<T, R extends ValidateResult>
		implements ImportHandler {

	/**
	 * 读取所有的数据
	 * 
	 * @param excelInputStream
	 *            excel的额输入流
	 * @return
	 */
	protected abstract List<T> importData(InputStream excelInputStream);

	/**
	 * 验证数据
	 * 
	 * @param datas
	 *            excel读入的数据
	 * @return
	 */
	protected abstract R validate(List<T> datas);

	protected abstract void saveToDB(List<T> datas);

	protected abstract String writeErrorToFile(List<T> datas, R validateContext);
}
