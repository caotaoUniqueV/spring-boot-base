/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.core.validate;

import com.caotao.boot.core.BusinessException;

import java.util.List;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: ValidationException, v0.1 2017年12月26日 13:35 曹开魁(Colin) Exp $
 */
public class ValidationException extends BusinessException {

    private ValidateResults results;

    public ValidationException(String message) {
        super(message, 400);
    }

    public ValidationException(String message, String field) {
        super(message, 400);
        results = new SimpleValidateResults().addResult(field, message);
    }

    public ValidationException(ValidateResults results) {
        super(results.toString(), 400);
        this.results = results;
    }

    public List<ValidateResults.Result> getResults() {
        if (results == null) {
            return null;
        }
        return results.getResults();
    }
}
