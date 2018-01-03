/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.meta;

import com.caotao.boot.eorm.core.DefaultValue;
import com.caotao.boot.eorm.core.OptionConverter;
import com.caotao.boot.eorm.core.PropertyWrapper;
import com.caotao.boot.eorm.core.ValueConverter;

import java.io.Serializable;
import java.util.Set;

/**
 * @author 曹开魁(Colin)
 * @version $Id: ColumnMetaData, v0.1 2018年01月03日 10:53 曹开魁(Colin) Exp $
 */
public interface ColumnMetaData extends Serializable, Cloneable {

    String getName();

    String getAlias();

    String getComment();

    Class getJavaType();

    <T extends TableMetaData> T getTableMetaData();

    ValueConverter getValueConverter();

    OptionConverter getOptionConverter();

    DefaultValue getDefaultValue();

    Set<String> getValidator();

    PropertyWrapper getProperty(String property);

    PropertyWrapper getProperty(String property, Object defaultValue);

    PropertyWrapper setProperty(String property, Object value);

    <T extends ColumnMetaData> T clone();
}
