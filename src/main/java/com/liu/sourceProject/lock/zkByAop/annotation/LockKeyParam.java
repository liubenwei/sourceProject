package com.liu.sourceProject.lock.zkByAop.annotation;

import java.lang.annotation.*;

/**
 * @author liu
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LockKeyParam {
    /**
     * lockKey的参数
     *
     * @return
     */
    String[] fields() default {};
}
