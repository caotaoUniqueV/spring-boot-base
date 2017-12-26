/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.expands.script.engine.java;

import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: JavaClassObject, v0.1 2017年12月25日 15:44 曹开魁(Colin) Exp $
 */
public class JavaClassObject extends SimpleJavaFileObject {

    protected final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    public JavaClassObject(String name, JavaFileObject.Kind kind) {
        super(URI.create("string:///" + name.replace('.', '/') + kind.extension), kind);
    }

    public byte[] getBytes() {
        return bos.toByteArray();
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        return bos;
    }
}
