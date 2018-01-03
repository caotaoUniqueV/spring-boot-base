/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 曹开魁(Colin)
 * @version $Id: PropertyWrapper, v0.1 2018年01月03日 11:11 曹开魁(Colin) Exp $
 */
public interface PropertyWrapper extends Serializable {

    <T> T getValue();

    @Override
    String toString();

    int toInt();

    double toDouble();

    boolean isTrue();

    Date toDate();

    Date toDate(String format);

    Map<String, Object> toMap();

    List<Map> toList();

    <T> T toBean(Class<T> type);

    <T> List<T> toBeanList(Class<T> type);

    boolean isNullOrEmpty();

    boolean valueTypeOf(Class<?> type);
}
