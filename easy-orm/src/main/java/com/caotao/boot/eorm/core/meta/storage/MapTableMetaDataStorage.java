/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.meta.storage;

import com.caotao.boot.eorm.core.meta.TableMetaData;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 曹开魁(Colin)
 * @version $Id: MapTableMetaDataStorage, v0.1 2018年01月03日 10:57 曹开魁(Colin) Exp $
 */
public class MapTableMetaDataStorage implements TableMetaDataStorage {

    private final Map<String, TableMetaData> nameTableMetaDataStorage = new HashMap<>();
    private final Map<String, TableMetaData> aliasTableMetaDataStorage = new HashMap<>();

    @Override
    public <T extends TableMetaData> Set<T> getAllTableMetaData() {
        Set<T> all = new LinkedHashSet<>();
        all.addAll((Set) nameTableMetaDataStorage.values());
        return all;
    }

    @Override
    public <T extends TableMetaData> T getTableMetaData(String nameOrAlias) {
        T old = (T) nameTableMetaDataStorage.get(nameOrAlias);
        if (old == null) {
            old = (T) aliasTableMetaDataStorage.get(nameOrAlias);
        }
        return old;
    }

    @Override
    public <T extends TableMetaData> T removeTableMeta(String nameOrAlias) {
        T old = (T) nameTableMetaDataStorage.remove(nameOrAlias);
        T old2 = (T) aliasTableMetaDataStorage.remove(nameOrAlias);
        return old != null ? old : old2;
    }

    @Override
    public <T extends TableMetaData> T putTableMetaData(T table) {
        nameTableMetaDataStorage.put(table.getName(), table);
        if (!table.getName().equals(table.getAlias())) {
            nameTableMetaDataStorage.put(table.getAlias(), table);
        }
        return table;
    }

    @Override
    public void clear() {

        nameTableMetaDataStorage.clear();
        aliasTableMetaDataStorage.clear();
    }
}
