package com.liu.sourceProject.lock.zkByAop.aspectj;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.liu.sourceProject.lock.zkByAop.annotation.LockKeyParam;
import com.liu.sourceProject.lock.zkByAop.annotation.ZooLock;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author liu
 */
public class ZookeeperLockAspect {

    private final CuratorFramework zkClient;

    /**
     * 分布式锁前缀
     */
    private static final String KEY_PREFIX = "DISTRIBUTED_LOCK_";

    private static final String KEY_SEPARATOR = "/";

    @Autowired
    public ZookeeperLockAspect(CuratorFramework zkClient) {
        this.zkClient = zkClient;
    }

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.liu.sourceProject.lock.zkByAop.annotation.ZooLock)")
    public void doLock() {

    }

    /**
     * 环绕通知
     *
     * @param point 切入点
     * @return 原方法返回
     */
    @Around("doLock()")
    public Object around(ProceedingJoinPoint point) throws Exception {

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Object[] args = point.getArgs();
        ZooLock zooLock = method.getAnnotation(ZooLock.class);
        if (StrUtil.isBlank(zooLock.key())) {
            throw new RuntimeException("分布式锁的key不能为空");
        }
        String lockKey = buildLockKey(zooLock, method, args);
        InterProcessMutex lock = new InterProcessMutex(zkClient, lockKey);
        try {
            if (lock.acquire(zooLock.timeout(), zooLock.timeUnit())) {
                return point.proceed();
            } else {
                return new RuntimeException("请勿重复提交");
            }
        } catch (Exception e) {

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            lock.release();
        }
        return null;
    }

    /**
     * 构建分布式锁的key
     *
     * @param lock   zooLock注解
     * @param method 注解标记的方法
     * @param args   方法上的参数
     * @return
     */
    private String buildLockKey(ZooLock lock, Method method, Object[] args) throws NoSuchFieldException, IllegalAccessException {
        StringBuilder key = new StringBuilder(KEY_PREFIX + KEY_SEPARATOR + lock.key());
        /**
         * 把方法上的参数全部取出来
         */
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if (!annotation.annotationType().isInstance(LockKeyParam.class)) {
                    //如果注解不是LockKeyParam
                    continue;
                }
                //拿到注解的所有属性
                String[] fields = ((LockKeyParam) annotation).fields();
                if (ArrayUtil.isEmpty(fields)) {
                    if (ObjectUtil.isNull(args[i])) {
                        throw new RuntimeException("动态参数不能为null");
                    }
                    key.append(KEY_SEPARATOR).append(args[i]);
                } else {
                    //LockKeyParam注解上的值不为null
                    for (String field : fields) {
                        Class<?> clazz = args[i].getClass();
                        Field declaredField = clazz.getDeclaredField(field);
                        declaredField.setAccessible(true);
                        Object value = declaredField.get(clazz);
                        key.append(KEY_SEPARATOR).append(value);

                    }
                }

            }
        }
        return key.toString();
    }
}
