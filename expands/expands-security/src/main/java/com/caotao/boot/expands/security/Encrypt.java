/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.expands.security;

import com.caotao.boot.expands.security.rsa.RSAEncrypt;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: Encrypt, v0.1 2017年12月25日 14:04 曹开魁(Colin) Exp $
 */
public abstract class Encrypt {

    public Encrypt() {
    }

    public static RSAEncrypt rsa() {
        return RSAEncrypt.get();
    }
}
