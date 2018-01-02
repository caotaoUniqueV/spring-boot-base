/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.param;

/**
 * 直接拼接sql的方式
 *
 * @author 曹开魁(Colin)
 * @version $Id: SqlTerm, v0.1 2018年01月02日 17:27 曹开魁(Colin) Exp $
 */
public class SqlTerm extends Term {

    private String sql;

    private Object param;

    public SqlTerm() {
    }

    public SqlTerm(String sql) {
        this(sql, null);
    }

    public SqlTerm(String sql, Object param) {
        this.sql = sql;
        this.param = param;
        setColumn(sql);
        if (param == null) {
            param = sql;
        }
        setValue(param);
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        setColumn(sql);
        this.sql = sql;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        setValue(param);
        this.param = param;
    }

    @Override
    public SqlTerm clone() {
        SqlTerm term = new SqlTerm();
        term.setColumn(getColumn());
        term.setValue(getValue());
        term.setTermType(getTermType());
        term.setType(getType());
        term.setSql(getSql());
        term.setParam(getParam());
        getTerms().forEach(t -> term.addTerm(t.clone()));
        return term;
    }
}
