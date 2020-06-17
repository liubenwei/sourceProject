package com.liu.sourceProject.ioc.model;

/**
 * @author liu
 */
public class BeanDefinition {

    private volatile Class<?> beanClass;

    public Class<?> getBeanClass(){
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass){
        this.beanClass = beanClass;
    }
}
