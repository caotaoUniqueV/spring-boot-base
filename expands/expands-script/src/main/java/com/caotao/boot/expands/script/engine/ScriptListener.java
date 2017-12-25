package com.caotao.boot.expands.script.engine;

/**
 * @author 曹开魁(Colin)
 * @version $Id: ScriptListener, v0.1 2017年12月24日 下午9:08 曹开魁(Colin) Exp $
 */
public interface ScriptListener {

    void before(ScriptContext context);

    void after(ScriptContext context, ExecuteResult result);
}
