package com.caotao.boot.expands.script.engine.js;


import com.caotao.boot.common.base.utils.StringUtils;
import com.caotao.boot.expands.script.engine.common.CommonScriptEngine;
import org.apache.commons.codec.digest.DigestUtils;

import javax.script.CompiledScript;

/**
 * @author 曹开魁(Colin)
 * @version $Id: DynamicScriptEngine, v0.1 2017年12月24日 下午9:03 曹开魁(Colin) Exp $
 */
public class JavaScriptEngine extends CommonScriptEngine {

    @Override
    public String getScriptName() {
        return "javascript";
    }

    @Override
    public boolean compile(String id, String code) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("compile {} {} : {}", getScriptName(), id, code);
        }
        if (compilable == null) {
            init();
        }
        CompiledScript compiledScript = compilable.compile(StringUtils.join("(function(){", code, "\n})();"));
        CommonScriptContext scriptContext = new CommonScriptContext(id, DigestUtils.md5Hex(code), compiledScript);
        scriptBase.put(id, scriptContext);
        return true;
    }
}
