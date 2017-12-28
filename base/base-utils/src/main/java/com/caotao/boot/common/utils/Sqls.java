/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.common.utils;


import com.caotao.boot.common.base.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: Sqls, v0.1 2017年12月26日 10:48 曹开魁(Colin) Exp $
 */
public class Sqls {

    public static List<String> parse(String sqlText) {
        String[] list = sqlText.split("[\n]");
        List<String> sqlList = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        Stream.of(list)
                .filter(s -> !s.startsWith("--") && s.trim().length() != 0)
                .forEach(s1 -> {
                    if (s1.trim().endsWith(";")) {
                        s1 = s1.trim();
                        s1 = s1.substring(0, s1.length() - 1);
                        if (!StringUtils.isEmpty(s1)) {
                            tmp.add(s1);
                        }
                        sqlList.add(String.join("\n", tmp.toArray(new String[tmp.size()])));
                        tmp.clear();
                    } else {
                        if (!StringUtils.isEmpty(s1)) {
                            tmp.add(s1);
                        }
                    }
                });
        if (!tmp.isEmpty()) {
            sqlList.add(String.join("\n", tmp.toArray(new String[tmp.size()])));
            tmp.clear();
        }
        return sqlList;
    }
}
