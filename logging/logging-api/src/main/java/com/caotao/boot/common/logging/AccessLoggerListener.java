/**
 * @company 杭州聚点-曹开魁
 * @copyright Copyright (c) 2015 - 2017
 */
package com.caotao.boot.common.logging;

/**
 * 访问日志监听器,实现此接口并注入到spring容器即可获取访问日志信息
 *
 * @author 曹开魁(Colin)
 * @version $Id: AccessLoggerListener, v0.1 2017年12月24日 上午11:26 曹开魁(Colin) Exp $
 */
public interface AccessLoggerListener {

    /**
     * 当产生访问日志时,将调用此方法.注意,此方法内的操作应尽量设置为异步操作,否则可能影响请求性能
     *
     * @param loggerInfo 产生的日志信息
     */
    void onLogger(AccessLoggerInfo loggerInfo);

    default void onLogBefore(AccessLoggerInfo loggerInfo){}
}
