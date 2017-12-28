/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.common.utils;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;
import java.util.function.Supplier;

/**
 * ThreadLocal 工具类,通过在ThreadLocal存储map信息,来实现在ThreadLocal中维护多个信息
 * <br>e.g.<code>
 * ThreadLocalUtils.put("key",value);<br>
 * ThreadLocalUtils.get("key");<br>
 * ThreadLocalUtils.remove("key");<br>
 * ThreadLocalUtils.getAndRemove("key");<br>
 * ThreadLocalUtils.get("key",()-&gt;defaultValue);<br>
 * ThreadLocalUtils.clear();<br>
 * </code>
 *
 * @author 曹开魁(Colin)
 * @version $Id: ThreadLocalUtils, v0.1 2017年12月25日 10:55 曹开魁(Colin) Exp $
 */
@SuppressWarnings("unchecked")
public final class ThreadLocalUtils {

    private ThreadLocalUtils() {
    }

    private static final ThreadLocal<Map<String, Object>> local = ThreadLocal.withInitial(HashedMap::new);

    /**
     * @return threadLocal中的全部值
     */
    public static Map<String, Object> getAll() {
        return local.get();
    }

    /**
     * 设置一个值到ThreadLocal
     *
     * @param key   键
     * @param value 值
     * @param <T>   值的类型
     * @return 被放入的值
     */
    public static <T> T put(String key, T value) {
        local.get().put(key, value);
        return value;
    }

    /**
     * 根据key删除对应的值
     *
     * @param key 键
     */
    public static void remove(String key) {
        local.get().remove(key);
    }

    /**
     * 清空ThreadLocal
     */
    public static void clear() {
        local.remove();
    }

    /**
     * 根据key获取ThreadLocal中对应的值
     *
     * @param key 键
     * @param <T> 值泛型
     * @return 值, 不存在则返回null, 如果类型与泛型不一致, 可能抛出{@link ClassCastException}
     */
    public static <T> T get(String key) {
        return (T) local.get().get(key);
    }

    /**
     * 从ThreadLocal中获取ThreadLocal中对应的值
     *
     * @param key            键
     * @param supplierOnNull
     * @param <T>            值泛型
     * @return 值, 不存在则返回null, 如果类型与泛型不一致, 可能抛出{@link ClassCastException}
     */
    public static <T> T get(String key, Supplier<T> supplierOnNull) {
        return ((T) local.get().computeIfAbsent(key, k -> supplierOnNull.get()));
    }

    /**
     * 获取一个值后然后删除掉
     *
     * @param key 键
     * @param <T> 值泛型
     * @return 值, 不存在则返回null
     */
    public static <T> T getAndRemove(String key) {

        try {
            return get(key);
        } finally {
            remove(key);
        }
    }

}
