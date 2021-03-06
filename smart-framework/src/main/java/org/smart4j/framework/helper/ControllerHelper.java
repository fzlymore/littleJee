package org.smart4j.framework.helper;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/27.
 */
public final class ControllerHelper {
    /**
     * 用于存放请求与处理器的映射关系
     */
    private static final Map<Request,Handler> ACTION_MAP = new HashMap<>();

    static {
        //获取所有的controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if(CollectionUtils.isNotEmpty(controllerClassSet)){
            //遍历这些Controller类
            for (Class<?> controllerClass: controllerClassSet) {
               //获取controller类中的方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if(null!=methods&&methods.length!=0){
                    //遍历这些Contoller类中的方法
                    for (Method method: methods) {
                       //判断当前方法是不是有action注解
                        if(method.isAnnotationPresent(Action.class)){
                            //从action中获取URL映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //验证URL映射规则
                            if(mapping.matches("\\w+:/\\w*")){
                              String [] array = mapping.split(":");
                              if(ArrayUtils.isNotEmpty(array)&&array.length==2){
                                  //获取请求方法和路径
                                  String requestMethod = array[0];
                                  String requestPath = array[1];
                                  Request request = new Request(requestMethod,requestPath);
                                  Handler handler = new Handler(controllerClass,method);
                                  ACTION_MAP.put(request,handler);
                              }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取handler
     */
    public static Handler getHandler (String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }
}
