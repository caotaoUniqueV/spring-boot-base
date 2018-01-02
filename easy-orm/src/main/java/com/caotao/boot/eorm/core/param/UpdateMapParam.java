/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.param;

import java.util.HashMap;
import java.util.Map;

/**
 * 修改MAP参数
 *
 * @author 曹开魁(Colin)
 * @version $Id: UpdateMapParam, v0.1 2018年01月02日 17:57 曹开魁(Colin) Exp $
 */
public class UpdateMapParam extends UpdateParam<Map<String, Object>> {

    public UpdateMapParam() {
        this(new HashMap<>());
    }

    public UpdateMapParam(Map<String, Object> data) {
        setData(data);
    }

    public UpdateMapParam set(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }
}
