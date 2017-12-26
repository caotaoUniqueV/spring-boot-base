/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.expands.security.rsa;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: RSAPublicEncrypt, v0.1 2017年12月25日 14:06 曹开魁(Colin) Exp $
 */
public class RSAPublicEncrypt extends DefaultEncrypt {

    private byte[] publicKey;

    public RSAPublicEncrypt(RSAPublicKey publicKey) {
        this.publicKey = Base64.encodeBase64(publicKey.getEncoded());
    }

    public RSAPublicEncrypt(String publicKey) {
        this.publicKey = publicKey.getBytes();
    }

    public RSAPublicEncrypt(byte[] publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public String getKey() {
        return new String(this.publicKey);
    }

    @Override
    protected EncodedKeySpec encodedKeySpec(byte[] keyBytes) {
        return new X509EncodedKeySpec(keyBytes);
    }

    public boolean verify(String sign, byte[] data) {
        try {
            byte[] e = Base64.decodeBase64(this.publicKey);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(e);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicK = keyFactory.generatePublic(keySpec);
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(publicK);
            signature.update(data);
            return signature.verify(Base64.decodeBase64(sign));
        } catch (Exception var8) {
            throw new RuntimeException(var8);
        }
    }
}
