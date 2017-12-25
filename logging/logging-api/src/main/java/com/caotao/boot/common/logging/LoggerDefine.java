package com.caotao.boot.common.logging;

/**
 * @author 曹开魁(Colin)
 * @version $Id: LoggerDefine, v0.1 2017年12月24日 上午11:28 曹开魁(Colin) Exp $
 */
public class LoggerDefine {

    /**
     * 执行
     */
    private String action;

    /**
     * 描述
     */
    private String describe;

    /**
     * 有参构造函数
     *
     * @param action
     * @param describe
     */
    public LoggerDefine(String action, String describe) {
        this.action = action;
        this.describe = describe;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
