/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.param;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 修改参数
 *
 * @author 曹开魁(Colin)
 * @version $Id: UpdateParam, v0.1 2018年01月02日 17:56 曹开魁(Colin) Exp $
 */
public class UpdateParam<T> extends Param {

    private T data;

    public UpdateParam() {
    }

    public UpdateParam(T data) {
        this.data = data;
    }

    public <C extends UpdateParam<T>> C set(T data) {
        this.data = data;
        return (C) this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public UpdateParam clone() {
        UpdateParam param = new UpdateParam();
        param.setData(data);
        param.setExcludes(new LinkedHashSet<>(excludes));
        param.setIncludes(new LinkedHashSet<>(includes));
        List<Term> terms = this.terms.stream().map(term -> term.clone()).collect(Collectors.toList());
        param.setTerms(terms);
        return param;
    }
}
