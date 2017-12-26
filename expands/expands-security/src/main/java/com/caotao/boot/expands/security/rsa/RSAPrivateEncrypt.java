/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.expands.security.rsa;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: RSAPrivateEncrypt, v0.1 2017年12月25日 14:06 曹开魁(Colin) Exp $
 */
public class RSAPrivateEncrypt extends DefaultEncrypt {

    private byte[] privateKey;

    public RSAPrivateEncrypt(RSAPrivateKey privateKey) {
        this.privateKey = Base64.encodeBase64(privateKey.getEncoded());
    }

    public RSAPrivateEncrypt(String privateKey) {
        this.privateKey = privateKey.getBytes();
    }

    public RSAPrivateEncrypt(byte[] privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public String getKey() {
        return new String(this.privateKey);
    }

    @Override
    protected EncodedKeySpec encodedKeySpec(byte[] keyBytes) {
        return new PKCS8EncodedKeySpec(keyBytes);
    }

    public String sign(byte[] data) {
        try {
            byte[] e = Base64.decodeBase64(this.privateKey);
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(e);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initSign(privateK);
            signature.update(data);
            return new String(Base64.encodeBase64(signature.sign()));
        } catch (Exception var7) {
            throw new RuntimeException(var7);
        }
    }
}
