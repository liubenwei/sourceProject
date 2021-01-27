package com.liu.sourceProject.source;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class code {
	Object object = new Object();


	/**	汇编后的代码
	 *        0: bipush        10  把数值10 push到操作数栈的栈顶
	 *        2: istore_1          把操作数栈 栈顶的值放入临时变量表 solt下标为1的槽中
	 *        3: iload_1			把solt 1的值取出压到操作数栈的栈顶
	 *        4: iinc          1, 1 操作数栈栈顶的数值加1
	 *        7: istore_2			把操作数栈栈顶的数值放入slot 2
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 10;
		int result = i++;
		System.out.println(result);
	}
}
