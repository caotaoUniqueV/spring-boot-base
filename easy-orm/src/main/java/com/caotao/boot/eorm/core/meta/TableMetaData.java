/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.meta;

import com.caotao.boot.eorm.core.ObjectWrapper;
import com.caotao.boot.eorm.core.PropertyWrapper;
import com.caotao.boot.eorm.core.Trigger;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * @author 曹开魁(Colin)
 * @version $Id: TableMetaData, v0.1 2018年01月03日 10:52 曹开魁(Colin) Exp $
 */
public interface TableMetaData extends Serializable {

    String getName();

    String getComment();

    String getAlias();

    <T extends DatabaseMetaData> T getDatabaseMetaData();

    <T extends ColumnMetaData> Set<T> getColumns();

    <T extends ColumnMetaData> T getColumn(String name);

    <T extends ColumnMetaData> T findColumn(String name);

    <T> ObjectWrapper<T> getObjectWrapper();

    PropertyWrapper getProperty(String property);

    PropertyWrapper getProperty(String property, Object defaultValue);

    PropertyWrapper getProperty(String name, Supplier<Object> defaultValue);

    PropertyWrapper setProperty(String property, Object value);

    void on(String name, Trigger trigger);

    void on(String name, Map<String, Object> triggerContext);

    boolean triggerIsSupport(String name);
}
