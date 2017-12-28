/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.core.exception;

/**
 * 业务异常
 *
 * @author 曹开魁(Colin)
 * @version $Id: BusinessException, v0.1 2017年12月26日 11:30 曹开魁(Colin) Exp $
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 5441923856899380112L;

    private int status = 500;

    public BusinessException(String message) {
        this(message, 500);
    }

    public BusinessException(String message, int status) {
        super(message);
        this.status = status;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, Throwable cause, int status) {
        super(message, cause);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
