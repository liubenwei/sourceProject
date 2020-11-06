package com.liu.sourceProject.leetcode.interview;

/**
 * @author liu
 * @Date 2020/11/6 9:58
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * 通过次数15,943提交次数49,184
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number0105 {
	public static void main(String[] args) {
		boolean b = new Number0105().oneEditAway("islander", "slander");
		System.out.println(b);
	}

	public boolean oneEditAway(String first, String second) {
		if(Math.abs(first.length()-second.length()) > 1){
			return false;
		}
		if(first.length() > second.length()){
			String temp = first;
			first = second;
			second = temp;
		}
		int secondIndex = 0;
		int diffentCount = 0;
		for(int i =0  ; (i < first.length() && secondIndex<second.length());){
			if(first.charAt(i) == second.charAt(secondIndex)){
				secondIndex++;
				i++;
			}else{
				if(first.length()==second.length()){
					secondIndex++;
					i++;
					diffentCount++;
				}else{
					secondIndex++;
					diffentCount++;
				}

			}
		}
		return diffentCount <= 1;
	}
}
