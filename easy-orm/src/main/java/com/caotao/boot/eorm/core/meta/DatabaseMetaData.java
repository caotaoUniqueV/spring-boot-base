/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.meta;

import com.caotao.boot.eorm.core.ObjectWrapperFactory;
import com.caotao.boot.eorm.core.ValidatorFactory;

/**
 * @author 曹开魁(Colin)
 * @version $Id: DatabaseMetaData, v0.1 2018年01月03日 10:51 曹开魁(Colin) Exp $
 */
public interface DatabaseMetaData {

    ObjectWrapperFactory getObjectWrapperFactory();

    ValidatorFactory getValidatorFactory();

    <T extends TableMetaData> T getTableMetaData(String name);
}
