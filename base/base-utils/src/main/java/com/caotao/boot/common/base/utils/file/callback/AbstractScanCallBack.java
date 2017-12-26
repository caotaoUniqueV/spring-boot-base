package com.caotao.boot.common.base.utils.file.callback;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: StringUtils, v0.1 2017年12月25日 17:11 曹开魁(Colin) Exp $
 */
public abstract class AbstractScanCallBack implements ScanCallBack {

    private boolean exit = false;

    @Override
    public void exit() {
        exit = true;
    }

    @Override
    public boolean isExit() {
        return exit;
    }

}
