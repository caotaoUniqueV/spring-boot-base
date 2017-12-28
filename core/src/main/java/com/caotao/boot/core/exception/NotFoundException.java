/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.core.exception;

/**
 * 不存在||找不到 - 异常
 *
 * @author 曹开魁(Colin)
 * @version $Id: NotFoundException, v0.1 2017年12月26日 11:31 曹开魁(Colin) Exp $
 */
public class NotFoundException extends BusinessException {

    public NotFoundException(String message) {
        super(message, 404);
    }

    public NotFoundException() {
        this("data not found");
    }
}
