/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.expands.script.engine.java;

import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import java.io.File;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: CharSequenceJavaFileObject, v0.1 2017年12月25日 15:42 曹开魁(Colin) Exp $
 */
public class CharSequenceJavaFileObject extends SimpleJavaFileObject {

    private CharSequence content;


    public CharSequenceJavaFileObject(String javaFilePath, String className, CharSequence content) throws Exception {
        super(new File(javaFilePath + className.replace('.', '/') + JavaFileObject.Kind.SOURCE.extension).toURI(), JavaFileObject.Kind.SOURCE);
        this.content = content;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return content;
    }
}
