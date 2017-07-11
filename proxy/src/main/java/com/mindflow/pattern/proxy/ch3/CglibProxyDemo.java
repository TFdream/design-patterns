package com.mindflow.pattern.proxy.ch3;

import com.mindflow.pattern.proxy.service.HelloService;
import com.mindflow.pattern.proxy.service.HelloServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-17 19:14
 */
public class CglibProxyDemo {

    public static void main(String[] args) {

        new CglibProxyDemo().testProxy();
    }

    private void testProxy() {

        HelloService helloService = getProxy(new HelloServiceImpl());

        helloService.say("ricky");

        System.out.println("************************");

        helloService.echo("hello, world");
    }

    private <T> T getProxy(Object target) {
        Enhancer en = new Enhancer();
        //进行代理
        en.setSuperclass(target.getClass());
        en.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                System.out.println(String.format("before method:%s execute", method.getName()));
                Object result = null;
                try{
                    result = methodProxy.invokeSuper(o, args);
                    System.out.println(String.format("after method:%s execute", method.getName()));
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(String.format("return method:%s execute", method.getName()));
                return result;
            }
        });
        //生成代理实例
        return (T)en.create();
    }
}
