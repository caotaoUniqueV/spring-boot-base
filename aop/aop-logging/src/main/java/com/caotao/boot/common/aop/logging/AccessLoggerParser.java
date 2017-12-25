/**
 * @company 杭州聚点-曹开魁
 * @copyright Copyright (c) 2015 - 2017
 */
package com.caotao.boot.common.logging.aop;

import com.caotao.boot.common.logging.LoggerDefine;

import java.lang.reflect.Method;

/**
 * @author 曹开魁(Colin)
 * @version $Id: AccessLoggerParser, v0.1 2017年12月24日 上午11:46 曹开魁(Colin) Exp $
 */
public interface AccessLoggerParser {

    boolean support(Class clazz, Method method);

    LoggerDefine parse(MethodInterceptorHolder holder);
}
