/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.expands.script.engine.java;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * 用途描述
 *
 * @author 曹开魁(Colin)
 * @version $Id: DynamicClassLoader, v0.1 2017年12月25日 15:43 曹开魁(Colin) Exp $
 */
public class DynamicClassLoader extends URLClassLoader {

    public ClassLoader parent;

    public DynamicClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
        this.parent = parent;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }
}
