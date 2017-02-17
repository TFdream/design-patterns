package com.bytebeats.pattern.proxy.ch2;

import com.bytebeats.pattern.proxy.service.HelloService;
import com.bytebeats.pattern.proxy.service.HelloServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-17 19:05
 */
public class JdkProxyDemo {

    public static void main(String[] args) {

        new JdkProxyDemo().testProxy();
    }

    public void testProxy(){

        HelloService helloService = getProxy(new HelloServiceImpl());

        helloService.say("ricky");

        System.out.println("************************");

        helloService.echo("hello, world");
    }

    private <T> T getProxy(final Object target) {

        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println(String.format("before method:%s execute", method.getName()));
                Object result = null;
                try{
                    result = method.invoke(target, args);
                    System.out.println(String.format("after method:%s execute", method.getName()));
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(String.format("return method:%s execute", method.getName()));
                return result;
            }
        });
    }
}
