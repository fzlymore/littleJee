package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.proxy.AspectProxy;
import org.smart4j.framework.proxy.Proxy;
import org.smart4j.framework.proxy.ProxyManager;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Created by wh1te on 2017/11/29.
 */
public final class AopHelper {

    static {
        try {
            Map<Class<?>,Set<Class<?>>> proxyMap = createProxyMap();
            Map<Class<?>,List<Proxy>> targetMap = createTargetMap(proxyMap);
            for (Map.Entry<Class<?>,List<Proxy>> targetEntry : targetMap.entrySet()){
                Class<?> targetClass = targetEntry.getKey();
                List<Proxy> proxyList = targetEntry.getValue();
                Object proxy = ProxyManager.createProxy(targetClass,proxyList);
                BeanHelper.setBean(targetClass,proxy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Set<Class<?>> createTargetClassSet(Aspect aspect)throws Exception{
        Set<Class<?>> targetClassSet = new HashSet<>();
        Class<? extends Annotation> annotation =aspect.value();
        if(annotation!=null&&!annotation.equals(Aspect.class)){
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }
        return targetClassSet;
    }

    private static Map<Class<?>,Set<Class<?>>> createProxyMap() throws Exception{
        Map<Class<?>,Set<Class<?>>> proxyMap = new HashMap<>(8);
        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
        for (Class<?> proxyClass: proxyClassSet) {
            if(proxyClass.isAnnotationPresent(Aspect.class)){
                Aspect aspect = proxyClass.getAnnotation(Aspect.class);
                Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
                proxyMap.put(proxyClass,targetClassSet);
            }
        }
        return proxyMap;
    }

    private static Map<Class<?>,List<Proxy>>createTargetMap(Map<Class<?>,Set<Class<?>>> proxyMap) throws Exception{
        Map<Class<?>,List<Proxy>> targetMap = new HashMap<>();
        for (Map.Entry<Class<?>,Set<Class<?>>> proxyEntry:proxyMap.entrySet()){
            Class<?> proxyClass = proxyEntry.getKey();
            Set<Class<?>> targetClassSet = proxyEntry.getValue();
            for (Class<?> targetClass :targetClassSet){
                Proxy proxy  = (Proxy) proxyClass.newInstance();
                if(targetMap.containsKey(targetClass)){
                    targetMap.get(targetClass).add(proxy);
                }else {
                    List<Proxy> proxyList = new ArrayList<>();
                    proxyList.add(proxy);
                    targetMap.put(targetClass,proxyList);
                }
            }
        }
        return targetMap;
    }

}
