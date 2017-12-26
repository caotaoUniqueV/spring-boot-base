package com.caotao.boot.core;

import java.lang.annotation.*;

/**
 * 功能描述
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
