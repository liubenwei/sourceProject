package com.liu.sourceProject.ioc.support;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liu
 */
public class SingletonBeanRegistry {

    public static final Object NULL_OBJECT=  new Object();

    //一级缓存
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>();

    //二级缓存
    private final Map<String, Object> earlySingletonObjects = new HashMap<String, Object>();

    //三级缓存
    private final Map<String, Object> singletonFactories = new HashMap<String, Object>();

    private final Set<String> singletonsCurrentlyInCreation = null;
}
