package com.liu.sourceProject.easyExcel.validate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liu
 * @Date 2020/8/29 15:48
 *
 *       验证结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateResult<T> {

	private Boolean Error = false;
	private T validateContext;

	public ValidateResult(T validateContext) {
		this.validateContext = validateContext;
	}
}
