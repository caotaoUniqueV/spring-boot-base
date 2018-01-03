/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

import com.alibaba.fastjson.JSON;
import com.caotao.boot.common.base.utils.ClassUtils;
import com.caotao.boot.common.base.utils.DateTimeUtils;
import com.caotao.boot.common.base.utils.StringUtils;
import com.caotao.boot.common.base.utils.time.DateFormatter;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 曹开魁(Colin)
 * @version $Id: SimplePropertyWrapper, v0.1 2018年01月03日 11:15 曹开魁(Colin) Exp $
 */
public class SimplePropertyWrapper implements PropertyWrapper {

    private Object value;

    /**
     * 有参构造函数
     *
     * @param value 值
     */
    public SimplePropertyWrapper(Object value) {
        this.value = value;
    }

    @Override
    public <T> T getValue() {
        return (T) value;
    }

    @Override
    public int toInt() {
        return StringUtils.toInt(value);
    }

    @Override
    public double toDouble() {
        return StringUtils.toDouble(value);
    }

    @Override
    public boolean isTrue() {
        return StringUtils.isTrue(value);
    }

    @Override
    public Date toDate() {
        if (value instanceof Date) {
            return ((Date) value);
        }
        return DateFormatter.fromString(toString());
    }

    @Override
    public Date toDate(String format) {
        if (value instanceof Date) {
            return ((Date) value);
        }
        return DateTimeUtils.formatDateString(toString(), format);
    }

    @Override
    public Map<String, Object> toMap() {
        return toBean(Map.class);
    }

    @Override
    public List<Map> toList() {
        return toBeanList(Map.class);
    }

    @Override
    public <T> T toBean(Class<T> type) {
        if (valueTypeOf(type)) {
            return ((T) getValue());
        }
        return JSON.parseObject(toString(), type);
    }

    @Override
    public <T> List<T> toBeanList(Class<T> type) {
        if (getValue() instanceof List) {
            return ((List) getValue());
        }
        return JSON.parseArray(toString(), type);
    }

    @Override
    public boolean isNullOrEmpty() {
        return StringUtils.isNullOrEmpty(value);
    }

    @Override
    public boolean valueTypeOf(Class<?> type) {
        if (value == null) {
            return false;
        }
        return ClassUtils.instanceOf(value.getClass(), type);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
