package com.caotao.boot.common.aop.context;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author 曹开魁(Colin)
 * @version $Id: MethodInterceptorHolder, v0.1 2017年12月24日 下午12:57 曹开魁(Colin) Exp $
 */
public class MethodInterceptorHolder {

    /**
     * 参数名称获取器,用于获取方法参数的名称
     */
    public static final ParameterNameD nameDiscoverer = new LocalVariableTableParameterNameDiscovereR();

    public static MethodInterceptorHolder current() {
        return ThreadLocalUtils.get(MethodInterceptorHolder.class.getName());
    }

    public static MethodInterceptorHolder clear() {
        return ThreadLocalUtils.getAndRemove(MethodInterceptorHolder.class.getName());
    }

    public static MethodInterceptorHolder setCurrent(MethodInterceptorHolder holder) {
        return ThreadLocalUtils.put(MethodInterceptorHolder.class.getName(), holder);
    }

    public static MethodInterceptorHolder create(MethodInvocation invocation) {
        String id = DigestUtils.md5DigestAsHex(String.valueOf(invocation.getMethod().hashCode()).getBytes());
        String[] argNames = nameDiscoverer.getParameterNames(invocation.getMethod());
        Object[] args = invocation.getArguments();
        Map<String, Object> argMap = new LinkedHashMap<>();
        for (int i = 0, len = args.length; i < len; i++) {
            argMap.put(argNames[i] == null ? "arg" + i : argNames[i], args[i]);
        }
        return new MethodInterceptorHolder(id,
                invocation.getMethod(),
                invocation.getThis(), argMap);
    }

    private String id;

    private Method method;

    private Object target;

    private Map<String, Object> args;

    public MethodInterceptorHolder set() {
        MethodInterceptorHolder.setCurrent(this);
        return this;
    }

    public MethodInterceptorHolder(String id, Method method, Object target, Map<String, Object> args) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(id);
        Objects.requireNonNull(method);
        Objects.requireNonNull(target);
        Objects.requireNonNull(args);
        this.id = id;
        this.method = method;
        this.target = target;
        this.args = args;
    }

    public String getId() {
        return id;
    }

    public Method getMethod() {
        return method;
    }

    public Object getTarget() {
        return target;
    }

    public Map<String, Object> getArgs() {
        return args;
    }

    public <T extends Annotation> T findMethodAnnotation(Class<T> annClass) {
        return AopUtils.findMethodAnnotation(annClass, method, annClass);
    }

    public <T extends Annotation> T findClassAnnotation(Class<T> annClass) {
        return AopUtils.findAnnotation(target.getClass(), annClass);
    }

    public <T extends Annotation> T findAnnotation(Class<T> annClass) {
        return AopUtils.findAnnotation(target.getClass(), method, annClass);
    }

    public MethodInterceptorContext createParamContext() {
        return createParamContext(null);
    }

    public MethodInterceptorContext createParamContext(Object invokeResult) {
        return new MethodInterceptorContext() {
            private static final long serialVersionUID = -4102787561601219273L;

            @Override
            public Object getTarget() {
                return target;
            }

            @Override
            public Method getMethod() {
                return method;
            }

            @Override
            public <T> Optional<T> getParameter(String name) {
                if (args == null) {
                    return Optional.empty();
                }
                return Optional.of((T) args.get(name));
            }

            @Override
            public <T extends Annotation> T getAnnotation(Class<T> annClass) {
                return findAnnotation(annClass);
            }

            @Override
            public Map<String, Object> getParams() {
                return getArgs();
            }

            @Override
            public Object getInvokeResult() {
                return invokeResult;
            }
        };
    }
}
