/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.common.utils;

import java.util.*;
import java.util.function.Supplier;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: Lists, v0.1 2017年12月26日 11:27 曹开魁(Colin) Exp $
 */
public class Lists {

    public static <V> ListBuilder<V> buildList(Supplier<List<V>> supplier) {
        return buildList(supplier.get());
    }

    public static <V> ListBuilder<V> buildList(V... array) {
        return buildList(array.length == 0 ? new ArrayList<>() : new ArrayList<>(Arrays.asList(array)));
    }

    public static <V> ListBuilder<V> buildList(List<V> target) {
        return new ListBuilder<>(target);
    }

    public static class ListBuilder<V> {
        private final List<V> target;

        private ListBuilder(List<V> target) {
            Objects.requireNonNull(target);
            this.target = target;
        }

        public ListBuilder<V> add(V value, V... more) {
            this.target.add(value);
            if (more.length > 0) {
                addAll(Arrays.asList(more));
            }
            return this;
        }


        public ListBuilder<V> addAll(Collection<V> value) {
            this.target.addAll(value);
            return this;
        }

        public List<V> get() {
            return target;
        }

    }
}
