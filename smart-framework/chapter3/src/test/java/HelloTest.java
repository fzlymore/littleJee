import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by wh1te on 2017/11/28.
 */
public class HelloTest {
    @Test
    public void testName() throws Exception {
           HelloImpl h1 = new HelloImpl();
        h1.say("Lily");
    }

    @Test
    public void test2() throws Exception {
          HelloProxy h2 = new HelloProxy();
        h2.say("111");
    }

    @Test
    public void test3() throws Exception {
        Hello hello = new HelloImpl();
       DynamicProxy dynamicProxy = new DynamicProxy(hello);
       Hello h4 = (Hello) Proxy.newProxyInstance(
               hello.getClass().getClassLoader(),
               hello.getClass().getInterfaces(),
               dynamicProxy
       );

        h4.say("jack");
    }

    @Test
    public void test4() throws Exception {
         DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
        Hello helloProxy = dynamicProxy.getProxy();
        helloProxy.say("juice");
    }
}
