/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.core.validate;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 完成注释
 *
 * @author 曹开魁(Colin)
 * @version $Id: SimpleValidateResults, v0.1 2017年12月26日 13:36 曹开魁(Colin) Exp $
 */
public class SimpleValidateResults implements ValidateResults {

    private List<ValidateResults.Result> results = new ArrayList<>();

    public SimpleValidateResults addResult(String field, String message) {
        results.add(new Result(field, message));
        return this;
    }

    @Override
    public boolean isSuccess() {
        return results == null || results.isEmpty();
    }

    @Override
    public List<ValidateResults.Result> getResults() {
        return results;
    }

    class Result implements ValidateResults.Result {
        private String field;
        private String message;

        public Result(String field, String message) {
            this.field = field;
            this.message = message;
        }

        @Override
        public String getField() {
            return field;
        }

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return "{" +
                    "\"field\":\"" + field + '\"' +
                    ", \"message:\"" + message + '\"' +
                    '}';
        }
    }

    @Override
    public String toString() {
        if (isSuccess()) {
            return "success";
        }
        return results.toString();
    }
}
