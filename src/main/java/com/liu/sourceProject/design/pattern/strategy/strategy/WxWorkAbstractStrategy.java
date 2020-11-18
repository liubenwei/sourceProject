package com.liu.sourceProject.design.pattern.strategy.strategy;


import com.liu.sourceProject.design.pattern.strategy.WxWorkCallBack;

public interface WxWorkAbstractStrategy {
	void process(WxWorkCallBack wxWorkCallBack);
}
