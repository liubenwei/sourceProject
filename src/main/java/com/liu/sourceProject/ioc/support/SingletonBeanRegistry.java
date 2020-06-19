package com.liu.sourceProject.ioc.support;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liu
 */
public class SingletonBeanRegistry {

    public static final Object NULL_OBJECT = new Object();

    //一级缓存
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>();

    //二级缓存
    private final Map<String, Object> earlySingletonObjects = new HashMap<String, Object>();

    //三级缓存
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();


    private final Set<String> singletonsCurrentlyInCreation = Collections.newSetFromMap(new ConcurrentHashMap<>());

    protected Object getSingleton(String beanName, boolean allowEarlyReference) {
        //先尝试从一级缓存中获取bean
        Object singletonObject = this.singletonObjects.get(beanName);

        if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
            //不在一级缓存中并且这个bean正在创建中
            //尝试从二级缓存中获取bean
            singletonObject = this.earlySingletonObjects.get(beanName);
            if (singletonObject == null && allowEarlyReference) {
                //不在二级缓存中，并且允许早期引用
                //从三级缓存中拿到创建bean的bean工厂
                ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
                if (singletonObject == null) {
                    //使用bean工厂新建bean
                    singletonObject = singletonFactory.getObject();
                    //把bean工厂新建好的bean放入二级缓存
                    this.earlySingletonObjects.put(beanName, singletonObject);
                    //bean工厂创建好bean之后，把bean从工厂移除
                    this.singletonFactories.remove(beanName);

                }
            }
        }
        //单例的bean对象实例都存储在map中，但是map不允许存储null，所以当bean为null时，用NULL_OBJECT代替null存储到map中
        return (singletonObject != NULL_OBJECT) ? singletonObject : null;
    }


    protected boolean isSingletonCurrentlyInCreation(String beanName) {
        return this.singletonsCurrentlyInCreation.contains(beanName);
    }
}
