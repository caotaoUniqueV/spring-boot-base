/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

import com.caotao.boot.eorm.core.param.SqlTerm;
import com.caotao.boot.eorm.core.param.Term;

/**
 * @author 曹开魁(Colin)
 * @version $Id: SqlConditionSupport, v0.1 2018年01月03日 14:55 曹开魁(Colin) Exp $
 */
public abstract class SqlConditionSupport<T> {

    protected Term.Type nowTermType = Term.Type.and;

    protected abstract T addSqlTerm(SqlTerm term);

    public Term.Type getNowTermType() {
        return nowTermType;
    }

    protected T setOr() {
        nowTermType = Term.Type.or;
        return (T) this;
    }

    protected T setAnd() {
        nowTermType = Term.Type.and;
        return (T) this;
    }

    public T sql(String sql, Object... params) {
        SqlTerm sqlTerm = new SqlTerm();
        sqlTerm.setColumn(sql);
        sqlTerm.setValue(params);
        sqlTerm.setSql(sql);
        sqlTerm.setParam(params);
        sqlTerm.setType(getNowTermType());
        return addSqlTerm(sqlTerm);
    }
}
