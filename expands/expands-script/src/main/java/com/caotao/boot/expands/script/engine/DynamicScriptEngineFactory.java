/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.expands.script.engine;

import com.caotao.boot.expands.script.engine.groovy.GroovyEngine;
import com.caotao.boot.expands.script.engine.java.JavaEngine;
import com.caotao.boot.expands.script.engine.js.JavaScriptEngine;
import com.caotao.boot.expands.script.engine.ognl.OgnlEngine;
import com.caotao.boot.expands.script.engine.python.PythonScriptEngine;
import com.caotao.boot.expands.script.engine.ruby.RubyScriptEngine;
import com.caotao.boot.expands.script.engine.spel.SpElEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: DynamicScriptEngineFactory, v0.1 2017年12月25日 13:39 曹开魁(Colin) Exp $
 */
public class DynamicScriptEngineFactory {

    private static final Map<String, DynamicScriptEngine> map = new HashMap<>();

    static {
        JavaScriptEngine engine = new JavaScriptEngine();
        map.put("js", engine);
        map.put("javascript", engine);
        map.put("groovy", new GroovyEngine());
        map.put("ruby", new RubyScriptEngine());
        map.put("python", new PythonScriptEngine());
        try {
            map.put("java", new JavaEngine());
        } catch (Exception e) {

        }
        try {
            Class.forName("org.springframework.expression.ExpressionParser");
            map.put("spel", new SpElEngine());
        } catch (ClassNotFoundException e) {
        }
        try {
            Class.forName("ognl.Ognl");
            map.put("ognl", new OgnlEngine());
        } catch (ClassNotFoundException e) {
        }
    }

    public static final DynamicScriptEngine getEngine(String type) {
        return map.get(type);
    }
}
