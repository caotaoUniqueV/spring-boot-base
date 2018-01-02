/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: TermTypeConditionalSupport, v0.1 2018年01月02日 16:52 曹开魁(Colin) Exp $
 */
public interface TermTypeConditionalSupport {

    /**
     * 条件接收器,用于处理接受到的条件并进行对应的操作如{@link Term.Type#and}
     *
     * @param <T>
     */
    interface Accepter<T, O> {
        T accept(String column, String termType, O value);
    }

    interface SimpleAccepter<T, O> {
        T accept(String column, O value);
    }
}
