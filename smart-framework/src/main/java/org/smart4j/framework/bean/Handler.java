package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * Created by wh1te on 2017/11/27.
 * 封装Action信息
 */
public class Handler {
    private Method actionMethod;
    /**
     * controller类
     */
    private Class<?> controllerClass;

    public Handler(Class<?>controllerClass , Method actionMethod){
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass(){
        return controllerClass;
    }

    public Method getActionMethod(){
        return actionMethod;
    }
}
