package com.liu.sourceProject.design.pattern.strategy.strategy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class WxWorkStrategyProcessor implements BeanFactoryPostProcessor {
	private final String strategyPackage = "com.lianxin.account.api.msg.receiver";

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
	}
}
