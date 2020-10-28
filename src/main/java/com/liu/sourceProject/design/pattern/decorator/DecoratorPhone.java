package com.liu.sourceProject.design.pattern.decorator;

public class DecoratorPhone implements IPhone {
	private IPhone iPhone;

	public DecoratorPhone(IPhone iPhone) {
		this.iPhone = iPhone;
	}

	@Override
	public String callIn() {
		System.out.println("开始");
		String result = iPhone.callIn();
		System.out.println("结束");
		return result;
	}
}
