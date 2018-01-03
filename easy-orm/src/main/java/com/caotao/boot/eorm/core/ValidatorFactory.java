/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

import com.caotao.boot.eorm.core.meta.TableMetaData;

/**
 * @author 曹开魁(Colin)
 * @version $Id: ValidatorFactory, v0.1 2018年01月03日 11:42 曹开魁(Colin) Exp $
 */
public interface ValidatorFactory {

    Validator createValidator(TableMetaData tableMetaData);
}
