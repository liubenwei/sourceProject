package com.liu.sourceProject.design.pattern.strategy.annotation;

import com.liu.sourceProject.design.pattern.strategy.WxWorkCallBackDef;

import java.lang.annotation.*;


/**
 * 微信回调类型的注解
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface WxWorkChangeType {
	WxWorkCallBackDef.ChangeType value();
}
