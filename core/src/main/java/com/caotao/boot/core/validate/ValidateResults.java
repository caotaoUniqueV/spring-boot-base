/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.core.validate;

import java.io.Serializable;
import java.util.List;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: ValidateResults, v0.1 2017年12月26日 13:35 曹开魁(Colin) Exp $
 */
public interface ValidateResults extends Serializable {

    boolean isSuccess();

    List<Result> getResults();

    interface Result extends Serializable {
        String getField();

        String getMessage();
    }
}
