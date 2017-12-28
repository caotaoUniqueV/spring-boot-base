/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: ApplicationContextHolder, v0.1 2017年12月26日 11:28 曹开魁(Colin) Exp $
 */
@Component
public class ApplicationContextHolder {

    private static ApplicationContext context;

    public static ApplicationContext get() {
        if (null == context) {
            throw new UnsupportedOperationException("ApplicationContext not ready!");
        }
        return context;
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        if (null == ApplicationContextHolder.context) {
            ApplicationContextHolder.context = context;
        }
    }
}
