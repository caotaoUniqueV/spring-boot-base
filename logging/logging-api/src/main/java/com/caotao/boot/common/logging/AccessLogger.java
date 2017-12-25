package com.caotao.boot.common.logging;

import java.lang.annotation.*;

/**
 * 访问日志,在类或者方法上注解此类,将对方法进行访问日志记录
 *
 * @author 曹开魁(Colin)
 * @version $Id: AccessLogger, v0.1 2017年12月24日 上午11:32 曹开魁(Colin) Exp $
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AccessLogger {

    /**
     * @return 对类或方法的简单说明
     * @see AccessLoggerInfo#getAction()
     */
    String value();

    /**
     * @return 对类或方法的详细描述
     * @see AccessLoggerInfo#getDescribe()
     */
    String[] describe() default "";

    /**
     * @return 是否取消日志记录, 如果不想记录某些方法或者类, 设置为true即可
     */
    boolean ignore() default false;
}
