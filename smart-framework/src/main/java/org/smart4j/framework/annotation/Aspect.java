package org.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by wh1te on 2017/11/28.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * aop注解
     */
    Class<?extends Annotation> value();
}
