/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.core.annotation;

import java.lang.annotation.*;

/**
 *  脚本范围 - 注解
 *
 * @author 曹开魁(Colin)
 * @version $Id: ScriptScope, v0.1 2017年12月26日 11:33 曹开魁(Colin) Exp $
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ScriptScope {

    String value() default "";
}
