package com.liu.sourceProject.ioc.support;

/**
 * @author liu
 */
public interface BeanFactory {

    Object getBean(String name);

    <T> T getBean(Class<?> requiredType);

    boolean containsBean(String name);
}
