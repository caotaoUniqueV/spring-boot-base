package com.caotao.boot.expands.script.engine;

/**
 * @author 曹开魁(Colin)
 * @version $Id: ScriptContext, v0.1 2017年12月24日 下午9:08 曹开魁(Colin) Exp $
 */
public class ScriptContext {

    private String id;

    private String md5;

    public ScriptContext(String id, String md5) {
        this.id = id;
        this.md5 = md5;
    }

    public String getId() {
        return id;
    }

    public String getMd5() {
        return md5;
    }

}
