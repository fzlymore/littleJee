package org.smart4j.framework.helper;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入
 * Created by wh1te on 2017/11/27.
 */
public final class IocHelper {
    static {
        //获取所有的bean类与bean实例之间的映射关系（简称beanMap）
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if(MapUtils.isNotEmpty(beanMap)){
         //遍历beanMap
            for (Map.Entry<Class<?>,Object> beanEntry:beanMap.entrySet()){
                //从beanMap里获得bean类与bean的实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance  = beanEntry.getValue();
                //获取Bean类里定义所有成员变量（简称bean field）
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtils.isNotEmpty(beanFields)){
                    //遍历beanFields
                    for (Field field:beanFields) {
                      //判断当前Bean field 是否带有inject注解
                        if(field.isAnnotationPresent(Inject.class)){
                            //在Bean Map 中获取 Bean field 的实例
                            Class<?> beanFieldClass = field.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance!=null){
                                ReflectionUtil.setField(beanInstance,field,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
