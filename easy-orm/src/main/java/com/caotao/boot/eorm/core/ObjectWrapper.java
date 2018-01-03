/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

import java.util.List;

/**
 * 对象包装器，在执行查询时，通过包装器对查询结果进行初始化
 *
 * @author 曹开魁(Colin)
 * @version $Id: ObjectWrapper, v0.1 2018年01月03日 11:38 曹开魁(Colin) Exp $
 */
public interface ObjectWrapper<T> {

    /**
     * 执行初始化,在sql执行后,包装结果前,将调用此方法,传入查询的列
     *
     * @param columns 列集合
     */
    default void setUp(List<String> columns) {
    }

    <C extends T> Class<C> getType();

    /**
     * 创建对象实例
     *
     * @return 对象实例
     */
    T newInstance();

    /**
     * 向实例中填充一个属性值
     *
     * @param instance 实例对象
     * @param index    当前实例的索引
     * @param attr     属性名称
     * @param value    属性值
     */
    void wrapper(T instance, int index, String attr, Object value);

    /**
     * 当一个实例被填充完成后调用，已进行其他操作
     *
     * @param instance 实例对象
     */
    boolean done(T instance);
}
