package com.caotao.boot.common.utils;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 曹开魁(Colin)
 * @version $Id: AopUtils, v0.1 2017年12月24日 下午1:36 曹开魁(Colin) Exp $
 */
public final class AopUtils {

    /**
     * 私有构造函数
     */
    private AopUtils() {
    }


    /**
     * 根据注解方法获取注解类型
     *
     * @param targetClass
     * @param method
     * @param annotationClass
     * @param <T>
     * @return
     */
    public static <T extends Annotation> T findMethodAnnotation(Class targetClass, Method method, Class<T> annotationClass) {


        T t = AnnotationUtils.findAnnotation(method, annotationClass);

        // 为空校验
        if (null != t) {

            return t;
        }

        method = ClassUtils.getMostSpecificMethod(method, targetClass);

        t = AnnotationUtils.findAnnotation(method, annotationClass);

        return t;

    }

    /**
     * 根据注解类获取注解类型
     *
     * @param targetClass     注解类
     * @param annotationClass
     * @param <T>
     * @return
     */
    public static <T extends Annotation> T findAnnotation(Class targetClass, Class<T> annotationClass) {

        return AnnotationUtils.findAnnotation(targetClass, annotationClass);
    }


    /**
     * 根据注解方法获取注解类型
     *
     * @param targetClass     注解类
     * @param method          注解方法
     * @param annotationClass
     * @param <T>
     * @return
     */
    public static <T extends Annotation> T findAnnotation(Class targetClass, Method method, Class<T> annotationClass) {

        // 根据注解方法获取类型
        T t = findMethodAnnotation(targetClass, method, annotationClass);

        // 为空校验
        if (null != t) {

            return t;
        }

        // 根据注解类获取类型
        return findAnnotation(targetClass, annotationClass);
    }

    /**
     *
     * @param joinPoint
     * @param annotationClass
     * @param <T>
     * @return
     */
    public static <T extends Annotation> T findAnnotation(JoinPoint joinPoint, Class<T> annotationClass){

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        return findAnnotation(joinPoint.getTarget().getClass(),signature.getMethod(),annotationClass);
    }

    /**
     *
     * @param joinPoint
     * @return
     */
    public static String getMethodBody(JoinPoint joinPoint){

        StringBuilder methodName = new StringBuilder(joinPoint.getSignature().getName()).append("(");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        String [] nameArray = signature.getParameterNames();

        Class[] classArray = signature.getParameterTypes();

        for (int i=0,length = classArray.length;i<length;i++){

            if(i !=0){
                methodName.append(",");
            }
            methodName.append(classArray[i].getSimpleName()).append(" ").append(nameArray[i]);
        }

        return methodName.append(")").toString();
    }


    /**
     *
     * @param joinPoint
     * @return
     */
    public static Map<String,Object> getArgsMap(JoinPoint joinPoint){

        MethodSignature signature = (MethodSignature)joinPoint.getSignature();

        Map<String,Object> args = new LinkedHashMap<>();

        String[] nameArray = signature.getParameterNames();

        for (int i = 0,length =nameArray.length;i<length;i++){

            args.put(nameArray[i],joinPoint.getArgs()[i]);
        }

        return args;
    }


}
