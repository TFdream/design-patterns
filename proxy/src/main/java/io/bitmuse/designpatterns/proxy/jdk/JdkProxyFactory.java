package io.bitmuse.designpatterns.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Ricky Fung
 */
public class JdkProxyFactory<T> implements InvocationHandler {
    private T target; // 真正的业务对象，也就是RealSubject对象
    //构造方法
    public JdkProxyFactory(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        // 在执行业务逻辑之前的预处理逻辑
        System.out.println("[before execute method]"+methodName);
        Object result = method.invoke(target, args);
        // 在执行业务逻辑之后的后置处理逻辑
        System.out.println("[after execute method]"+methodName);
        return result;
    }

    public T getProxy() {
        // 创建代理对象
        return (T) Proxy.newProxyInstance(Thread.currentThread()
                        .getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }
}
