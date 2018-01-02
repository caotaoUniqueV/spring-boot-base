/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.param;

/**
 * 排序
 *
 * @author 曹开魁(Colin)
 * @version $Id: Sort, v0.1 2018年01月02日 17:30 曹开魁(Colin) Exp $
 */
public class Sort extends Column {

    private String order = "asc";

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Sort() {
    }

    public Sort(String name) {
        setName(name);
    }

    public void asc() {
        this.order = "asc";
    }

    public void desc() {
        this.order = "desc";
    }

    @Override
    public int hashCode() {
        return String.valueOf(getName()).concat(order).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        return this.hashCode() == obj.hashCode();
    }

}
