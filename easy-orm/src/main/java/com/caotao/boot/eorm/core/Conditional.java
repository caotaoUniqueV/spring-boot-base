/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

import com.caotao.boot.common.base.utils.StringUtils;
import com.caotao.boot.eorm.core.param.TermType;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * 嵌套条件
 *
 * @author 曹开魁(Colin)
 * @version $Id: Conditional, v0.1 2018年01月02日 16:52 曹开魁(Colin) Exp $
 */
public interface Conditional<T extends Conditional> extends LogicalOperation<T>, TermTypeConditionalSupport {

    /**
     * 嵌套条件，如: where name = ? or (age > 18 and age <90)
     *
     * @return
     */
    NestConditional<T> nest();

    NestConditional<T> nest(String column, Object value);

    NestConditional<T> orNest();

    NestConditional<T> orNest(String column, Object value);

    /**
     * and切换
     *
     * @return
     */
    T and();

    /**
     * or切换
     *
     * @return
     */
    T or();

    /**
     * 自定义and的操作
     *
     * @param consumer
     * @return
     */
    default T and(Consumer<T> consumer) {
        consumer.accept(this.and());
        return (T) this;
    }

    /**
     * 自定义or的操作
     *
     * @param consumer
     * @return
     */
    default T or(Consumer<T> consumer) {
        consumer.accept(this.or());
        return (T) this;
    }

    /**
     * 自定义条件类型 and的操作
     *
     * @param column
     * @param termType
     * @param value
     * @return
     */
    T and(String column, String termType, Object value);

    /**
     * 自定义条件类型 or的操作
     *
     * @param column
     * @param termType
     * @param value
     * @return
     */
    T or(String column, String termType, Object value);

    /**
     * 查询条件
     *
     * @param column
     * @param value
     * @return
     */
    default T where(String column, Object value) {
        return and(column, TermType.eq, value);
    }

    default T where() {
        return (T) this;
    }

    default T where(Consumer<Conditional> consumer) {
        consumer.accept(this);
        return (T) this;
    }

    default T and(String column, Object value) {
        return and(column, TermType.eq, value);
    }

    default T is(String column, Object value) {
        return accept(column, TermType.eq, value);
    }

    default T or(String column, Object value) {
        return or(column, TermType.eq, value);
    }

    default T like(String column, Object value) {
        return accept(column, TermType.like, value);
    }

    default T like$(String column, Object value) {
        if (value == null) {
            return like(column, null);
        }
        return accept(column, TermType.like, StringUtils.join(value, "%"));
    }

    default T $like(String column, Object value) {
        if (value == null) {
            return like(column, null);
        }
        return accept(column, TermType.like, StringUtils.join("%", value));
    }

    default T $like$(String column, Object value) {
        if (value == null) {
            return like(column, null);
        }
        return accept(column, TermType.like, StringUtils.join("%", value, "%"));
    }

    default T notLike(String column, Object value) {
        return accept(column, TermType.nlike, value);
    }

    default T gt(String column, Object value) {
        return accept(column, TermType.gt, value);
    }

    default T lt(String column, Object value) {
        return accept(column, TermType.lt, value);
    }

    default T gte(String column, Object value) {
        return accept(column, TermType.gte, value);
    }

    default T lte(String column, Object value) {
        return accept(column, TermType.lte, value);
    }

    default T in(String column, Object value) {
        return accept(column, TermType.in, value);
    }

    default T in(String column, Object... values) {
        return accept(column, TermType.in, values);
    }

    default T in(String column, Collection values) {
        return accept(column, TermType.in, values);
    }

    default T notIn(String column, Object value) {
        return accept(column, TermType.nin, value);
    }

    default T isEmpty(String column) {
        return accept(column, TermType.empty, 1);
    }

    default T notEmpty(String column) {
        return accept(column, TermType.nempty, 1);
    }

    default T isNull(String column) {
        return accept(column, TermType.isnull, 1);
    }

    default T notNull(String column) {
        return accept(column, TermType.notnull, 1);
    }

    default T not(String column, Object value) {
        return accept(column, TermType.not, value);
    }

    default T between(String column, Object between, Object and) {
        return accept(column, TermType.btw, Arrays.asList(between, and));
    }

    default T notBetween(String column, Object between, Object and) {
        return accept(column, TermType.nbtw, Arrays.asList(between, and));
    }

    default T accept(String column, String termType, Object value) {
        return getAccepter().accept(column, termType, value);
    }

    /**
     * 直接拼接sql,参数支持预编译
     * 例如
     * <ul>
     * <li>query.sql("name=?","admin")</li>
     * <li>query.sql("name=#{name}",{name:"admin"})</li>
     * <li>query.sql("name=#{[0]}",["admin"])</li>
     * </ul>
     *
     * @param sql    sql字符串
     * @param params 参数
     * @return {@link T}
     */
    T sql(String sql, Object... params);

    Accepter<T, Object> getAccepter();
}
