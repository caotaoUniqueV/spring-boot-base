/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.param;

/**
 * 添加参数
 *
 * @author 曹开魁(Colin)
 * @version $Id: InsertParam, v0.1 2018年01月02日 17:36 曹开魁(Colin) Exp $
 */
public class InsertParam<T> {

    private T data;

    public InsertParam() {
    }

    public InsertParam(T data) {
        this.data = data;
    }

    public InsertParam<T> value(T data) {
        this.data = data;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> InsertParam<T> build(T data) {
        return new InsertParam<>(data);
    }

}
