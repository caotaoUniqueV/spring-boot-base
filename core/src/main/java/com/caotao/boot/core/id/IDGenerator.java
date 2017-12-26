/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.core.id;

import com.caotao.boot.common.base.utils.RandomUtil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: IDGenerator, v0.1 2017年12月26日 11:33 曹开魁(Colin) Exp $
 */
public interface IDGenerator<T> {

    T generate();

    IDGenerator<String> UUID = java.util.UUID.randomUUID()::toString;

    IDGenerator<String> RANDOM = RandomUtil::randomChar;

    IDGenerator<String> MD5 = () -> {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(UUID.generate().concat(RandomUtil.randomChar()).getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    };
}
