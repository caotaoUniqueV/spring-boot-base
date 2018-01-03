/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

import com.caotao.boot.eorm.core.param.SqlTerm;
import com.caotao.boot.eorm.core.param.Term;

/**
 * @author 曹开魁(Colin)
 * @version $Id: SimpleNestConditional, v0.1 2018年01月03日 15:04 曹开魁(Colin) Exp $
 */
public class SimpleNestConditional<T extends TermTypeConditionalSupport> extends SqlConditionSupport<SimpleNestConditional<T>> implements NestConditional<T> {

    private Term term;
    private T target;
    private Accepter<NestConditional<T>, Object> accepter = this::and;

    public SimpleNestConditional(T target, Term term) {
        this.term = term;
        this.target = target;
    }

    @Override
    protected SimpleNestConditional<T> addSqlTerm(SqlTerm term) {
        this.term.addTerm(term);
        return this;
    }

    @Override
    public T end() {
        return target;
    }


    @Override
    public NestConditional<T> and() {
        setAnd();
        accepter = this::and;
        return this;
    }

    @Override
    public NestConditional<T> or() {
        setOr();
        accepter = this::or;
        return this;
    }

    @Override
    public Accepter<NestConditional<T>, Object> getAccepter() {
        return accepter;
    }

    @Override
    public NestConditional<NestConditional<T>> nest() {
        return new SimpleNestConditional<>(this, this.term.nest());
    }

    @Override
    public NestConditional<NestConditional<T>> nest(String column, Object value) {
        return new SimpleNestConditional<>(this, this.term.nest(column, value));
    }

    @Override
    public NestConditional<NestConditional<T>> orNest() {
        return new SimpleNestConditional<>(this, this.term.orNest());
    }

    @Override
    public NestConditional<NestConditional<T>> orNest(String column, Object value) {
        return new SimpleNestConditional<>(this, this.term.orNest(column, value));
    }

    @Override
    public NestConditional<T> and(String column, String termType, Object value) {
        term.and(column, termType, value);
        return this;
    }

    @Override
    public NestConditional<T> or(String column, String termType, Object value) {
        term.or(column, termType, value);
        return this;
    }
}
