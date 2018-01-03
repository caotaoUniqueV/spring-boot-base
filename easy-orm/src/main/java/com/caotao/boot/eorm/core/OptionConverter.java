/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

/**
 * 选项映射器,当一个字段持有映射器时.
 * <ul>
 *      <li>
 *          在查询时,会追加一个名为{@link OptionConverter#getFieldName()}的字段为{@link OptionConverter#converterValue(Object)} 的值
 *      </li>
 *      <li>
 *          在修改或者插入时,验证器会首先通过 {@link OptionConverter#converterData(Object)}来获取一个结果.
 *          如果返回null.则调用{@link OptionConverter#converterValue(Object)} ,并将值放入数据库.
 *          如果继续返回null,则会抛出验证器异常,提示值不再选项范围中
 *      </li>
 * </ul>
 *
 * @author 曹开魁(Colin)
 * @version $Id: OptionConverter, v0.1 2018年01月03日 11:10 曹开魁(Colin) Exp $
 */
public interface OptionConverter {

    /**
     * 获取所有选项
     *
     * @return 选项
     */
    Object getOptions();

    /**
     * 获取转换后的字段名称
     *
     * @return 转换后的字段名称
     */
    String getFieldName();

    /**
     * 将提交的数据,转换为目标数据
     *
     * @param value 提交的数据
     * @return 转换结果
     */
    Object converterData(Object value);

    /**
     * 将数据库的数据,转换为目标数据
     *
     * @param data 数据库数据
     * @return 转换结果
     */
    Object converterValue(Object data);
}
