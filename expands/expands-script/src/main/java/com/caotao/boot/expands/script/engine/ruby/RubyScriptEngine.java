package com.caotao.boot.expands.script.engine.ruby;


import com.caotao.boot.expands.script.engine.common.CommonScriptEngine;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: DynamicScriptEngineFactory, v0.1 2017年12月25日 13:39 曹开魁(Colin) Exp $
 */
public class RubyScriptEngine extends CommonScriptEngine {

    @Override
    public String getScriptName() {
        return "ruby";
    }
}
