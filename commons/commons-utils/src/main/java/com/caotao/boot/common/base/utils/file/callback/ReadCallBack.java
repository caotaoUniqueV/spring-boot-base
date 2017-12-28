package com.caotao.boot.common.base.utils.file.callback;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: StringUtils, v0.1 2017年12月25日 17:11 曹开魁(Colin) Exp $
 */
public interface ReadCallBack extends CanExitCallBack {

    void readLine(int lineNumber, String line);

    default void error(Throwable e) {
        e.printStackTrace();
    }

    default void done(int total) {
    }

}
