package com.caotao.boot.common.base.utils.file.callback;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: StringUtils, v0.1 2017年12月25日 17:11 曹开魁(Colin) Exp $
 */
public class ReadStringCallBack implements ReadCallBack {

    protected StringBuilder builder = new StringBuilder();

    @Override
    public String toString() {
        return builder.toString();
    }

    @Override
    public void readLine(int lineNumber, String line) {
        builder.append(line).append("\n");
    }
}
