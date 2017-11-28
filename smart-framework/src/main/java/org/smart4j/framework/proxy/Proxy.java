package org.smart4j.framework.proxy;

/**
 * Created by wh1te on 2017/11/28.
 */
public interface Proxy {
    /**
     * 执行链式管理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
