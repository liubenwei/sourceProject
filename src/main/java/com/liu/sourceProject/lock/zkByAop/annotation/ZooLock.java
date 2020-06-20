package com.liu.sourceProject.lock.zkByAop.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author liu
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ZooLock {
    /**
     * 分布式锁的key
     */
    String key();

    /**
     * 锁的释放时间，默认5秒
     *
     * @return
     */
    long timeout() default 5 * 1000;

    /**
     * 时间单位， 默认毫秒
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
