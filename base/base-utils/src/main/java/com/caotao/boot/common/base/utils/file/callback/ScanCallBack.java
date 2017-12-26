package com.caotao.boot.common.base.utils.file.callback;

import java.io.File;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: StringUtils, v0.1 2017年12月25日 17:11 曹开魁(Colin) Exp $
 */
public interface ScanCallBack extends CanExitCallBack {

    void accept(int deep, File file);

    default void error(int deep, File file, Throwable e) {
        e.printStackTrace();
    }

}
