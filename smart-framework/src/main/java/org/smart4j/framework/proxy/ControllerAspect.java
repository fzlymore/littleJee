package org.smart4j.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by wh1te on 2017/11/28.
 */
public class ControllerAspect extends AspectProxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private Long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug("-------------debug------------------");
        LOGGER.debug(String.format("class:%s"),cls.getName());
        LOGGER.debug(String.format("method:%s"),method.getName());
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
       LOGGER.debug(String.format("time:&dms"),System.currentTimeMillis()-begin);
        LOGGER.debug("--------------debug------------------");
    }
}