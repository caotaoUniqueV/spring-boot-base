/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.expands.script.engine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: ListenerSupportEngine, v0.1 2017年12月25日 13:41 曹开魁(Colin) Exp $
 */
public abstract class ListenerSupportEngine implements DynamicScriptEngine {

    protected List<ScriptListener> listener = new LinkedList<>();
    private Map<String, Object> globalVariable;

    protected void doListenerBefore(ScriptContext context) {
        listener.forEach(listener -> listener.before(context));
    }

    protected void doListenerAfter(ScriptContext context, ExecuteResult result) {
        listener.forEach(listener -> listener.after(context, result));
    }

    @Override
    public void addListener(ScriptListener scriptListener) {
        listener.add(scriptListener);
    }

    protected Map<String, Object> getGlobalVariable() {
        if (null == globalVariable) {
            return new HashMap<>();
        }
        return new HashMap<>(globalVariable);
    }

    @Override
    public void addGlobalVariable(Map<String, Object> vars) {
        globalVariable = vars;
    }
}
