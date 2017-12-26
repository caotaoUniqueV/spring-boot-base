/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.expands.security.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: RSAEncrypt, v0.1 2017年12月25日 14:05 曹开魁(Colin) Exp $
 */
public class RSAEncrypt {

    RSAPublicKey publicKey;
    RSAPrivateKey privateKey;
    int keySize;

    private RSAEncrypt(int keySize) {
        this.keySize = keySize;
    }

    protected void createKey() {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(this.keySize);
            KeyPair e = keyPairGen.generateKeyPair();
            this.publicKey = (RSAPublicKey) e.getPublic();
            this.privateKey = (RSAPrivateKey) e.getPrivate();
        } catch (NoSuchAlgorithmException var3) {
            throw new RuntimeException(var3);
        }
    }

    public RSAPublicEncrypt publicEncrypt() {
        if (this.publicKey == null) {
            this.createKey();
        }

        return new RSAPublicEncrypt(this.publicKey);
    }

    public RSAPrivateEncrypt privateEncrypt() {
        if (this.privateKey == null) {
            this.createKey();
        }

        return new RSAPrivateEncrypt(this.privateKey);
    }

    public RSAPublicEncrypt publicEncrypt(String key) {
        return new RSAPublicEncrypt(key);
    }

    public RSAPrivateEncrypt privateEncrypt(String key) {
        return new RSAPrivateEncrypt(key);
    }

    public RSAPublicEncrypt publicEncrypt(byte[] key) {
        return new RSAPublicEncrypt(key);
    }

    public RSAPrivateEncrypt privateEncrypt(byte[] key) {
        return new RSAPrivateEncrypt(key);
    }

    public static RSAEncrypt get() {
        return get(1024);
    }

    public static RSAEncrypt get(int keySize) {
        return new RSAEncrypt(keySize);
    }
}
