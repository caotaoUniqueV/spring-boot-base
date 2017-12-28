/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015-2017
 */
package com.caotao.boot.logging.api;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 访问日志信息,此对象包含了被拦截的方法和类信息,如果要对此对象进行序列化,请自行转换为想要的格式.
 * 或者调用{@link this#toSimpleMap}获取可序列化的map格式日志信息
 *
 * @author 曹开魁(Colin)
 * @version $Id: AccessLoggerInfo, v0.1 2017年12月22日 9:40 曹开魁(Colin) Exp $
 */
public class AccessLoggerInfo {

    /**
     * 日志id
     */
    private String id;

    /**
     * 访问的操作
     */
    private String action;

    /**
     * 描述
     */
    private String describe;

    /**
     * 访问对应的java方法
     */
    private Method method;

    /**
     * 访问对应的java类
     */
    private Class target;

    /**
     * 请求的参数,参数为java方法的参数而不是http参数,key为参数名,value为参数值.
     */
    private Map<String, Object> parameters;

    /**
     * 请求者ip地址
     */
    private String ip;

    /**
     * 请求的url地址
     */
    private String url;

    /**
     * http 请求头集合
     */
    private Map<String, String> httpHeaders;

    /**
     * http 请求方法, GET,POST...
     */
    private String httpMethod;

    /**
     * 响应结果,方法的返回值
     */
    private Object response;

    /**
     * 请求时间戳
     *
     * @see System#currentTimeMillis()
     */
    private long requestTime;

    /**
     * 响应时间戳
     *
     * @see System#currentTimeMillis()
     */
    private long responseTime;

    /**
     * 异常信息,请求对应方法抛出的异常
     */
    private Throwable exception;

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>action</tt>.
     *
     * @return property value of action
     */
    public String getAction() {
        return action;
    }

    /**
     * Setter method for property <tt>action</tt>.
     *
     * @param action value to be assigned to property action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Getter method for property <tt>describe</tt>.
     *
     * @return property value of describe
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * Setter method for property <tt>describe</tt>.
     *
     * @param describe value to be assigned to property describe
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * Getter method for property <tt>method</tt>.
     *
     * @return property value of method
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Setter method for property <tt>method</tt>.
     *
     * @param method value to be assigned to property method
     */
    public void setMethod(Method method) {
        this.method = method;
    }

    /**
     * Getter method for property <tt>target</tt>.
     *
     * @return property value of target
     */
    public Class getTarget() {
        return target;
    }

    /**
     * Setter method for property <tt>target</tt>.
     *
     * @param target value to be assigned to property target
     */
    public void setTarget(Class target) {
        this.target = target;
    }

    /**
     * Getter method for property <tt>parameters</tt>.
     *
     * @return property value of parameters
     */
    public Map<String, Object> getParameters() {
        return parameters;
    }

    /**
     * Setter method for property <tt>parameters</tt>.
     *
     * @param parameters value to be assigned to property parameters
     */
    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    /**
     * Getter method for property <tt>ip</tt>.
     *
     * @return property value of ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Setter method for property <tt>ip</tt>.
     *
     * @param ip value to be assigned to property ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Getter method for property <tt>url</tt>.
     *
     * @return property value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for property <tt>url</tt>.
     *
     * @param url value to be assigned to property url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter method for property <tt>httpHeaders</tt>.
     *
     * @return property value of httpHeaders
     */
    public Map<String, String> getHttpHeaders() {
        return httpHeaders;
    }

    /**
     * Setter method for property <tt>httpHeaders</tt>.
     *
     * @param httpHeaders value to be assigned to property httpHeaders
     */
    public void setHttpHeaders(Map<String, String> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    /**
     * Getter method for property <tt>httpMethod</tt>.
     *
     * @return property value of httpMethod
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * Setter method for property <tt>httpMethod</tt>.
     *
     * @param httpMethod value to be assigned to property httpMethod
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    /**
     * Getter method for property <tt>response</tt>.
     *
     * @return property value of response
     */
    public Object getResponse() {
        return response;
    }

    /**
     * Setter method for property <tt>response</tt>.
     *
     * @param response value to be assigned to property response
     */
    public void setResponse(Object response) {
        this.response = response;
    }

    /**
     * Getter method for property <tt>requestTime</tt>.
     *
     * @return property value of requestTime
     */
    public long getRequestTime() {
        return requestTime;
    }

    /**
     * Setter method for property <tt>requestTime</tt>.
     *
     * @param requestTime value to be assigned to property requestTime
     */
    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * Getter method for property <tt>responseTime</tt>.
     *
     * @return property value of responseTime
     */
    public long getResponseTime() {
        return responseTime;
    }

    /**
     * Setter method for property <tt>responseTime</tt>.
     *
     * @param responseTime value to be assigned to property responseTime
     */
    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * Getter method for property <tt>exception</tt>.
     *
     * @return property value of exception
     */
    public Throwable getException() {
        return exception;
    }

    /**
     * Setter method for property <tt>exception</tt>.
     *
     * @param exception value to be assigned to property exception
     */
    public void setException(Throwable exception) {
        this.exception = exception;
    }

    public Map<String, Object> toSimpleMap(Function<Object, Serializable> noSerialExchange) {
        return toSimpleMap(noSerialExchange, new LinkedHashMap<>());
    }

    public Map<String, Object> toSimpleMap(Function<Object, Serializable> objectFilter, Map<String, Object> map) {
        map.put("action", action);
        map.put("describe", describe);
        if (method != null) {
            StringBuffer methodAppender = new StringBuffer(",");
            methodAppender.append(method.getName().concat("("));
            methodAppender.append(")");
            String[] parameterNames = parameters.keySet().toArray(new String[parameters.size()]);
            Class[] parameterTypes = method.getParameterTypes();

            for (int i = 0; i < parameterTypes.length; i++) {
                methodAppender.append(parameterTypes[i].getSimpleName().concat(" ").concat(parameterNames.length >= i ? parameterNames[i] : ("arg" + i)));
            }
            map.put("method", methodAppender.toString());
        }
        map.put("target", target != null ? target.getName() : "");
        Map<String, Object> newParameter = new LinkedHashMap<>(parameters);

        newParameter.entrySet().forEach(entry -> {
            if (entry.getValue() != null) {
                entry.setValue(objectFilter.apply(entry.getValue()));
            }
        });

        map.put("parameters", newParameter);
        map.put("httpHeaders", httpHeaders);
        map.put("httpMethod", httpMethod);
        map.put("ip", ip);
        map.put("url", url);
        map.put("response", objectFilter.apply(response));
        map.put("requestTime", requestTime);
        map.put("responseTime", responseTime);
        map.put("id", id);
        map.put("useTime", responseTime - requestTime);
        if (exception != null) {
            StringWriter writer = new StringWriter();
            exception.printStackTrace(new PrintWriter(writer));
            map.put("exception", writer.toString());
        }
        return map;
    }
}
