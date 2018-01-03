/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core;

/**
 * 数据库操作接口
 *
 * @author 曹开魁(Colin)
 * @version $Id: Database, v0.1 2018年01月03日 10:51 曹开魁(Colin) Exp $
 */
public interface Database {

    /**
     * 获取数据库定义对象
     *
     * @return 数据库定义对象
     */
    <T extends DatabaseMetaData> T getMeta();

}
