/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

import java.io.Serializable;

/**
 * @author 曹开魁(Colin)
 * @version $Id: DefaultValue, v0.1 2018年01月03日 10:50 曹开魁(Colin) Exp $
 */
public interface DefaultValue extends Serializable {

    Object get();
}
