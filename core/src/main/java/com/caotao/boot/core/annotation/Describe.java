package com.caotao.boot.core.annotation;

import java.lang.annotation.*;

/**
 * 描述 - 注解
 *
 * @author 曹开魁(Colin)
 * @version $Id: Describe, v0.1 2017年12月26日 11:32 曹开魁(Colin) Exp $
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Describe {

    String value();

    Class type() default Object.class;
}
