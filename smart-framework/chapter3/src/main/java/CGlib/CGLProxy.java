package CGlib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wh1te on 2017/11/28.
 */
public class CGLProxy implements MethodInterceptor {

    private static CGLProxy instance = new CGLProxy();

    private CGLProxy(){

    }

    public static CGLProxy getInstance(){
        return instance;
    }

    public <T>T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls,this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
       before();
        Object result = methodProxy.invokeSuper(o,objects);
        after();
        return result;
    }

    private void before(){
        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }

}
