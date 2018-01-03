/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

/**
 * @author 曹开魁(Colin)
 * @version $Id: TriggerSkipSupport, v0.1 2018年01月03日 11:43 曹开魁(Colin) Exp $
 */
public interface TriggerSkipSupport<O> {

    O skipTrigger();
}
