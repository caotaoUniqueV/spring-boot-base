/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.meta.storage;

import com.caotao.boot.eorm.core.meta.TableMetaData;

import java.util.Set;

/**
 * @author 曹开魁(Colin)
 * @version $Id: TableMetaDataStorage, v0.1 2018年01月03日 10:54 曹开魁(Colin) Exp $
 */
public interface TableMetaDataStorage {

    <T extends TableMetaData> Set<T> getAllTableMetaData();

    <T extends TableMetaData> T getTableMetaData(String nameOrAlias);

    <T extends TableMetaData> T removeTableMeta(String nameOrAlias);

    <T extends TableMetaData> T putTableMetaData(T table);

    void clear();
}
