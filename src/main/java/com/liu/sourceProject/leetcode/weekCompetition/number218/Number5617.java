package com.liu.sourceProject.leetcode.weekCompetition.number218;

/**
 * @author liu
 * @Date 2020/12/6 10:51
 */
public class Number5617 {
	public static void main(String[] args) {
		Number5617 number5617 = new Number5617();
		String interpret = number5617.interpret("G()(al)");
		System.out.println(interpret);
	}

	public String interpret(String command) {
		if (command == null) {
			return command;
		}
		command = command.replace("()", "o");
		command = command.replace("(al)", "al");
		return command;
	}
}
