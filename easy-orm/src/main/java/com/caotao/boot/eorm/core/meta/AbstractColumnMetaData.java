/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.meta;

import com.caotao.boot.eorm.core.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 曹开魁(Colin)
 * @version $Id: AbstractColumnMetaData, v0.1 2018年01月03日 11:00 曹开魁(Colin) Exp $
 */
public abstract class AbstractColumnMetaData implements ColumnMetaData {

    protected String name;
    protected String alias;
    protected String comment;
    protected Class javaType;
    protected TableMetaData tableMetaData;
    protected OptionConverter optionConverter;
    protected ValueConverter valueConverter;
    protected DefaultValue defaultValue;
    protected Set<String> validator;
    protected Map<String, Object> properties = new HashMap<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAlias() {
        if (alias == null) {
            alias = name;
        }
        return alias;
    }

    @Override
    public String getComment() {
        if (comment == null) {
            comment = "";
        }
        return comment;
    }

    @Override
    public Class getJavaType() {
        return javaType;
    }

    @Override
    public <T extends TableMetaData> T getTableMetaData() {
        return (T) tableMetaData;
    }

    @Override
    public ValueConverter getValueConverter() {
        return valueConverter;
    }

    @Override
    public OptionConverter getOptionConverter() {
        return optionConverter;
    }

    @Override
    public DefaultValue getDefaultValue() {
        return defaultValue;
    }

    @Override
    public Set<String> getValidator() {
        return validator;
    }

    @Override
    public PropertyWrapper getProperty(String property) {
        return new SimplePropertyWrapper(properties.get(property));
    }

    @Override
    public PropertyWrapper getProperty(String property, Object defaultValue) {
        Object value = properties.get(property);
        return new SimplePropertyWrapper(value == null ? defaultValue : value);
    }

    @Override
    public PropertyWrapper setProperty(String property, Object value) {
        return new SimplePropertyWrapper(properties.put(property, value));
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
     * Setter method for property <tt>alias</tt>.
     *
     * @param alias value to be assigned to property alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
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
     * Setter method for property <tt>javaType</tt>.
     *
     * @param javaType value to be assigned to property javaType
     */
    public void setJavaType(Class javaType) {
        this.javaType = javaType;
    }

    /**
     * Setter method for property <tt>tableMetaData</tt>.
     *
     * @param tableMetaData value to be assigned to property tableMetaData
     */
    public void setTableMetaData(TableMetaData tableMetaData) {
        this.tableMetaData = tableMetaData;
    }

    /**
     * Setter method for property <tt>optionConverter</tt>.
     *
     * @param optionConverter value to be assigned to property optionConverter
     */
    public void setOptionConverter(OptionConverter optionConverter) {
        this.optionConverter = optionConverter;
    }

    /**
     * Setter method for property <tt>valueConverter</tt>.
     *
     * @param valueConverter value to be assigned to property valueConverter
     */
    public void setValueConverter(ValueConverter valueConverter) {
        this.valueConverter = valueConverter;
    }

    /**
     * Setter method for property <tt>validator</tt>.
     *
     * @param validator value to be assigned to property validator
     */
    public void setValidator(Set<String> validator) {
        this.validator = validator;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }


    @Override
    public abstract AbstractColumnMetaData clone();
}
