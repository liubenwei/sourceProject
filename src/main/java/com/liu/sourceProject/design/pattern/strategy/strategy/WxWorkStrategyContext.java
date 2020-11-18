package com.liu.sourceProject.design.pattern.strategy.strategy;

import com.liu.sourceProject.design.pattern.strategy.WxWorkCallBackDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WxWorkStrategyContext {
	@Autowired
	private ApplicationContext applicationContext;
	private Map<WxWorkCallBackDef.ChangeType, Class<WxWorkAbstractStrategy>> strategyMap;

	public WxWorkStrategyContext(
			Map<WxWorkCallBackDef.ChangeType, Class<WxWorkAbstractStrategy>> strategyMap) {
		this.strategyMap = strategyMap;
	}

	public WxWorkAbstractStrategy getStrategy(
			WxWorkCallBackDef.ChangeType changeType) {
		Class<WxWorkAbstractStrategy> clazz = strategyMap.get(changeType);
		return applicationContext.getBean(clazz);
	}
}
