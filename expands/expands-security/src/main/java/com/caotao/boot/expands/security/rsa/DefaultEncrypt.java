/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.expands.security.rsa;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.EncodedKeySpec;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: DefaultEncrypt, v0.1 2017年12月25日 14:05 曹开魁(Colin) Exp $
 */
public abstract class DefaultEncrypt {

    static final int MAX_ENCRYPT_BLOCK = 117;
    static final int MAX_DECRYPT_BLOCK = 128;
    static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    public DefaultEncrypt() {
    }

    protected abstract String getKey();

    protected abstract EncodedKeySpec encodedKeySpec(byte[] var1);

    public byte[] encrypt(byte[] data) {
        try {
            byte[] e = Base64.decodeBase64(this.getKey());
            EncodedKeySpec keySpec = this.encodedKeySpec(e);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Object key = this instanceof RSAPrivateEncrypt ? keyFactory.generatePrivate(keySpec) : keyFactory.generatePublic(keySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(1, (Key) key);
            return this.doFinal(data, cipher, 117);
        } catch (Exception var7) {
            throw new RuntimeException(var7);
        }
    }

    private byte[] doFinal(byte[] data, Cipher cipher, int max) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Throwable var5 = null;

        try {
            int inputLen = data.length;
            int offSet = 0;

            for (int i = 0; inputLen - offSet > 0; offSet = i * max) {
                byte[] cache;
                if (inputLen - offSet > max) {
                    cache = cipher.doFinal(data, offSet, max);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }

                out.write(cache, 0, cache.length);
                ++i;
            }

            byte[] decryptedData = out.toByteArray();
            out.close();
            byte[] var11 = decryptedData;
            return var11;
        } catch (Throwable var20) {
            var5 = var20;
            throw var20;
        } finally {
            if (out != null) {
                if (var5 != null) {
                    try {
                        out.close();
                    } catch (Throwable var19) {
                        var5.addSuppressed(var19);
                    }
                } else {
                    out.close();
                }
            }

        }
    }

    public byte[] decrypt(byte[] data) {
        try {
            byte[] e = Base64.decodeBase64(this.getKey());
            EncodedKeySpec keySpec = this.encodedKeySpec(e);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Object key = this instanceof RSAPrivateEncrypt ? keyFactory.generatePrivate(keySpec) : keyFactory.generatePublic(keySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(2, (Key) key);
            return this.doFinal(data, cipher, 128);
        } catch (Exception var7) {
            throw new RuntimeException(var7);
        }
    }
}
