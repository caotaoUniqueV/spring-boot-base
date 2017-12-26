/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.expands.script.engine.java;

import java.util.Map;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: Executor, v0.1 2017年12月25日 15:44 曹开魁(Colin) Exp $
 */
public interface Executor {

    Object execute(Map<String, Object> var) throws Exception;
}
