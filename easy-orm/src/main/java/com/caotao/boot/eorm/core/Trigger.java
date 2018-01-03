/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

import java.util.Map;

/**
 * @author 曹开魁(Colin)
 * @version $Id: Trigger, v0.1 2018年01月03日 11:40 曹开魁(Colin) Exp $
 */
public interface Trigger {

    void execute(Map<String, Object> context);

    String select_before = "select.before";
    String select_wrapper_each = "select.wrapper.each";
    String select_wrapper_done = "select.wrapper.done";
    String select_done = "select.done";
    String insert_before = "insert.before";
    String insert_done = "insert.done";
    String update_before = "update.before";
    String update_done = "update.done";
    String delete_before = "delete.before";
    String delete_done = "delete.done";
}
