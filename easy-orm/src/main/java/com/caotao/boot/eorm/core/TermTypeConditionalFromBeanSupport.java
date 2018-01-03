/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 曹开魁(Colin)
 * @version $Id: TermTypeConditionalFromBeanSupport, v0.1 2018年01月03日 10:32 曹开魁(Colin) Exp $
 */
public interface TermTypeConditionalFromBeanSupport {

    Logger logger = LoggerFactory.getLogger("queryForBean");

    Object getBean();

    default Object getValue(String property) {

        // 为空校验
        if (getBean() == null) {
            return null;
        }
        PropertyUtilsBean propertyUtilsBean = BeanUtilsBean.getInstance().getPropertyUtils();
        try {
            return propertyUtilsBean.getProperty(getBean(), property);
        } catch (Exception e) {
            logger.warn("get bean property {} error", property, e);
        }
        return null;
    }
}
