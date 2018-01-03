/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.eorm.core.meta;

import com.caotao.boot.eorm.core.ObjectWrapperFactory;
import com.caotao.boot.eorm.core.ValidatorFactory;
import com.caotao.boot.eorm.core.meta.storage.MapTableMetaDataStorage;
import com.caotao.boot.eorm.core.meta.storage.TableMetaDataStorage;

/**
 * @author 曹开魁(Colin)
 * @version $Id: AbstractDatabaseMetaData, v0.1 2018年01月03日 14:42 曹开魁(Colin) Exp $
 */
public abstract class AbstractDatabaseMetaData implements DatabaseMetaData {

    protected ObjectWrapperFactory objectWrapperFactory;
    protected ValidatorFactory validatorFactory;
    protected TableMetaDataStorage tableMetaDataStorage = new MapTableMetaDataStorage();

    @Override
    public <T extends TableMetaData> T getTableMetaData(String name) {
        return tableMetaDataStorage.getTableMetaData(name);
    }

    /**
     * Getter method for property <tt>objectWrapperFactory</tt>.
     *
     * @return property value of objectWrapperFactory
     */
    @Override
    public ObjectWrapperFactory getObjectWrapperFactory() {
        return objectWrapperFactory;
    }

    /**
     * Setter method for property <tt>objectWrapperFactory</tt>.
     *
     * @param objectWrapperFactory value to be assigned to property objectWrapperFactory
     */
    public void setObjectWrapperFactory(ObjectWrapperFactory objectWrapperFactory) {
        this.objectWrapperFactory = objectWrapperFactory;
    }

    /**
     * Getter method for property <tt>validatorFactory</tt>.
     *
     * @return property value of validatorFactory
     */
    @Override
    public ValidatorFactory getValidatorFactory() {
        return validatorFactory;
    }

    /**
     * Setter method for property <tt>validatorFactory</tt>.
     *
     * @param validatorFactory value to be assigned to property validatorFactory
     */
    public void setValidatorFactory(ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    /**
     * Setter method for property <tt>tableMetaDataStorage</tt>.
     *
     * @param tableMetaDataStorage value to be assigned to property tableMetaDataStorage
     */
    public void setTableMetaDataStorage(TableMetaDataStorage tableMetaDataStorage) {
        this.tableMetaDataStorage = tableMetaDataStorage;
    }
}
