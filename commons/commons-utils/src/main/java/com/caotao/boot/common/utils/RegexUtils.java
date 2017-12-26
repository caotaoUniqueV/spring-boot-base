/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.common.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 正则表达式 - 工具类
 *
 * @author 曹开魁(Colin)
 * @version $Id: RegexUtils, v0.1 2017年12月26日 10:49 曹开魁(Colin) Exp $
 */
public class RegexUtils {

    private static Set<Character> SPECIAL_WORDS = new HashSet<>(Arrays.asList('\\', '$', '(', ')', '*', '+', '.', '[', ']', '?', '^', '{', '}', '|'));

    public static String escape(String regex) {
        if (regex == null || regex.isEmpty()) {
            return regex;
        }
        char[] chars = regex.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            if (SPECIAL_WORDS.contains(aChar)) {
                builder.append('\\');
            }
            builder.append(aChar);
        }
        return builder.toString();
    }
}
