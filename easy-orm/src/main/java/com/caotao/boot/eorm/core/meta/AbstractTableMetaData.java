/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.meta;

import com.caotao.boot.eorm.core.*;

import java.util.*;
import java.util.function.Supplier;

/**
 * @author 曹开魁(Colin)
 * @version $Id: AbstractTableMetaData, v0.1 2018年01月03日 10:59 曹开魁(Colin) Exp $
 */
public abstract class AbstractTableMetaData<C extends AbstractColumnMetaData> implements TableMetaData {

    /**
     * 表名称
     */
    protected String name = null;

    /**
     * 表别名,如果指定了别名,查询结果将使用别名进行封装
     */
    protected String alias = null;

    /**
     * 备注
     */
    protected String comment = null;

    /**
     * 表字段
     */
    protected Map<String, C> columnMetaDataMap = new LinkedHashMap<>();

    /**
     * 表字段备注
     */
    protected Map<String, C> aliasColumnMetaDataMap = new LinkedHashMap<>();

    /**
     *
     */
    protected Validator validator = null;

    /**
     *
     */
    protected ObjectWrapper objectWrapper = null;

    /**
     *
     */
    protected Map<String, Object> properties = new HashMap<>();

    /**
     *
     */
    protected Map<String, Trigger> triggerBase = new HashMap<>();

    /**
     * Getter method for property <tt>objectWrapper</tt>.
     *
     * @return property value of objectWrapper
     */
    @Override
    public <T> ObjectWrapper<T> getObjectWrapper() {
        return objectWrapper;
    }

    /**
     * Setter method for property <tt>objectWrapper</tt>.
     *
     * @param objectWrapper value to be assigned to property objectWrapper
     */
    public void setObjectWrapper(ObjectWrapper objectWrapper) {
        this.objectWrapper = objectWrapper;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>alias</tt>.
     *
     * @return property value of alias
     */
    @Override
    public String getAlias() {
        if (alias == null) {
            alias = name;
        }
        return alias;
    }

    /**
     * Setter method for property <tt>alias</tt>.
     *
     * @param alias value to be assigned to property alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Getter method for property <tt>comment</tt>.
     *
     * @return property value of comment
     */
    @Override
    public String getComment() {
        return comment;
    }

    /**
     * Setter method for property <tt>comment</tt>.
     *
     * @param comment value to be assigned to property comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取列集合
     *
     * @return
     */
    @Override
    public Set<C> getColumns() {
        return new LinkedHashSet<>(columnMetaDataMap.values());
    }

    @Override
    public C getColumn(String name) {
        C metaData = columnMetaDataMap.get(name);
        if (metaData == null) {
            metaData = aliasColumnMetaDataMap.get(name);
        }
        return metaData;
    }

    /**
     * 删除列
     *
     * @param name
     */
    public void removeColumn(String name) {
        columnMetaDataMap.remove(name);
        aliasColumnMetaDataMap.remove(name);
    }

    /**
     * 添加列名
     *
     * @param columnMetaData
     * @param <T>
     * @return
     */
    public <T extends AbstractTableMetaData<C>> T addColumn(C columnMetaData) {
        columnMetaData.setTableMetaData(this);
        columnMetaDataMap.put(columnMetaData.getName(), columnMetaData);
        if (!columnMetaData.getName().equals(columnMetaData.getAlias())) {
            aliasColumnMetaDataMap.put(columnMetaData.getAlias(), columnMetaData);
        }
        return (T) this;
    }

    /**
     * 查询列名
     *
     * @param name 名称
     * @return
     */
    @Override
    public abstract C findColumn(String name);

    @Override
    public PropertyWrapper getProperty(String name) {
        return new SimplePropertyWrapper(properties.get(name));
    }

    @Override
    public PropertyWrapper getProperty(String name, Object defaultValue) {
        return new SimplePropertyWrapper(properties.getOrDefault(name, defaultValue));
    }

    @Override
    public PropertyWrapper getProperty(String name, Supplier<Object> defaultValue) {
        return new SimplePropertyWrapper(properties.getOrDefault(name, defaultValue.get()));
    }

    @Override
    public PropertyWrapper setProperty(String name, Object value) {
        return new SimplePropertyWrapper(properties.put(name, value));
    }

    /**
     * 删除
     *
     * @param name
     * @return
     */
    public PropertyWrapper removeProperty(String name) {

        return new SimplePropertyWrapper(properties.remove(name));
    }


    @Override
    public void on(String name, Trigger trigger) {

        triggerBase.put(name, trigger);
    }

    @Override
    public void on(String name, Map<String, Object> triggerContext) {

        if (triggerIsSupport(name)) {
            Trigger trigger = triggerBase.get(name);
            trigger.execute(triggerContext);
        }
    }

    @Override
    public boolean triggerIsSupport(String name) {
        return triggerBase.containsKey(name);
    }

    /**
     * Getter method for property <tt>validator</tt>.
     *
     * @return property value of validator
     */
    public Validator getValidator() {
        return validator;
    }

    /**
     * Setter method for property <tt>validator</tt>.
     *
     * @param validator value to be assigned to property validator
     */
    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    /**
     * Getter method for property <tt>properties</tt>.
     *
     * @return property value of properties
     */
    public Map<String, Object> getProperties() {
        return properties;
    }

    /**
     * Setter method for property <tt>properties</tt>.
     *
     * @param properties value to be assigned to property properties
     */
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return name + " [" + alias + "]" + "(" + comment + ")";
    }
}
