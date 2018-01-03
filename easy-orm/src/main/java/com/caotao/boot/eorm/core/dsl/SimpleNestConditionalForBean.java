/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.dsl;

import com.caotao.boot.eorm.core.NestConditionalFromBean;
import com.caotao.boot.eorm.core.SqlConditionSupport;
import com.caotao.boot.eorm.core.TermTypeConditionalFromBeanSupport;
import com.caotao.boot.eorm.core.param.SqlTerm;
import com.caotao.boot.eorm.core.param.Term;

/**
 * @author 曹开魁(Colin)
 * @version $Id: SimpleNestConditionalForBean, v0.1 2018年01月03日 14:54 曹开魁(Colin) Exp $
 */
public class SimpleNestConditionalForBean<T extends TermTypeConditionalFromBeanSupport>
        extends SqlConditionSupport<SimpleNestConditionalForBean<T>> implements NestConditionalFromBean<T> {

    protected T proxy;
    protected Accepter<NestConditionalFromBean<T>, Object> accepter = this::and;
    protected Term term;

    public SimpleNestConditionalForBean(T proxy, Term term) {
        this.proxy = proxy;
        this.term = term;
    }

    @Override
    protected SimpleNestConditionalForBean<T> addSqlTerm(SqlTerm term) {
        this.term.addTerm(term);
        return this;
    }

    @Override
    public T end() {
        return proxy;
    }

    @Override
    public NestConditionalFromBean<NestConditionalFromBean<T>> nest() {
        return new SimpleNestConditionalForBean<>(this, term.nest());
    }

    @Override
    public NestConditionalFromBean<NestConditionalFromBean<T>> nest(String column) {
        return new SimpleNestConditionalForBean<>(this, term.nest(column, getValue(column)));
    }

    @Override
    public NestConditionalFromBean<NestConditionalFromBean<T>> orNest() {
        return new SimpleNestConditionalForBean<>(this, term.orNest());
    }

    @Override
    public NestConditionalFromBean<NestConditionalFromBean<T>> orNest(String column) {
        return new SimpleNestConditionalForBean<>(this, term.orNest(column, getValue(column)));
    }

    @Override
    public NestConditionalFromBean<T> and() {
        setAnd();
        accepter = this::and;
        return this;
    }

    @Override
    public NestConditionalFromBean<T> or() {
        setOr();
        accepter = this::or;
        return this;
    }

    @Override
    public NestConditionalFromBean<T> and(String column, String termType) {
        term.and(column, termType, getValue(column));
        return this;
    }

    @Override
    public NestConditionalFromBean<T> or(String column, String termType) {
        term.or(column, termType, getValue(column));
        return this;
    }

    public NestConditionalFromBean<T> and(String column, String termType, Object value) {
        term.and(column, termType, value);
        return this;
    }

    public NestConditionalFromBean<T> or(String column, String termType, Object value) {
        term.or(column, termType, value);
        return this;
    }

    @Override
    public Accepter<NestConditionalFromBean<T>, Object> getAccepter() {
        return accepter;
    }

    @Override
    public Object getBean() {
        return proxy.getBean();
    }
}
