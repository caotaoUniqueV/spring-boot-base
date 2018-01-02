/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.param;

import java.util.HashMap;
import java.util.Map;

/**
 * 添加MAP集合参数
 *
 * @author 曹开魁(Colin)
 * @version $Id: InsertParamMapParam, v0.1 2018年01月02日 17:37 曹开魁(Colin) Exp $
 */
public class InsertParamMapParam extends InsertParam<Map<String, Object>> {

    @Override
    public Map<String, Object> getData() {

        // 为空校验
        if (null == super.getData()) {
            setData(new HashMap<>());
        }
        return super.getData();
    }

    public InsertParamMapParam value(String property, Object value) {
        getData().put(property, value);
        return this;
    }

    public InsertParamMapParam values(Map<String, Object> values) {
        getData().putAll(values);
        return this;
    }
}
