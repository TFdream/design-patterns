package io.bitmuse.designpatterns.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Ricky Fung
 */
public class CglibProxyFactory<T> {
    private final T target;

    public CglibProxyFactory(T target) {
        this.target = target;
    }

    public T getProxy() {
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
        return (T) en.create();
    }
}
