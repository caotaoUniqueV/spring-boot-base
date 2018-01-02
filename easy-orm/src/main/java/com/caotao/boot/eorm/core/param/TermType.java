/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.param;

/**
 * 提供默认支持的查询条件类型,用于动态指定查询条件
 *
 * @author 曹开魁(Colin)
 * @version $Id: TermType, v0.1 2018年01月02日 17:23 曹开魁(Colin) Exp $
 */
public interface TermType {

    /**
     * ==
     *
     * @since 1.0
     */
    String eq = "eq";

    /**
     * !=
     *
     * @since 1.0
     */
    String not = "not";

    /**
     * like
     *
     * @since 1.0
     */
    String like = "like";

    /**
     * not like
     *
     * @since 1.0
     */
    String nlike = "nlike";

    /**
     * >
     *
     * @since 1.0
     */
    String gt = "gt";

    /**
     * <
     *
     * @since 1.0
     */
    String lt = "lt";
    /**
     * >=
     *
     * @since 1.0
     */
    String gte = "gte";

    /**
     * <=
     *
     * @since 1.0
     */
    String lte = "lte";

    /**
     * in
     *
     * @since 1.0
     */
    String in = "in";

    /**
     * notin
     *
     * @since 1.0
     */
    String nin = "nin";
    /**
     * =''
     *
     * @since 1.0
     */
    String empty = "empty";

    /**
     * !=''
     *
     * @since 1.0
     */
    String nempty = "nempty";
    /**
     * is null
     *
     * @since 1.0
     */
    String isnull = "isnull";

    /**
     * not null
     *
     * @since 1.0
     */
    String notnull = "notnull";

    /**
     * between
     *
     * @since 1.0
     */
    String btw = "btw";

    /**
     * not between
     *
     * @since 1.0
     */
    String nbtw = "nbtw";

}
