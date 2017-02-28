# proxy pattern (代理模式)
在某些情况下，一个客户不想或者不能直接引用一个对 象，此时可以通过一个称之为“代理”的第三者来实现 间接引用。
代理对象可以在客户端和目标对象之间起到 中介的作用，并且可以通过代理对象去掉客户不能看到的内容和服务或者添加客户需要的额外服务。

## 1.模式定义
> 给某一个对象提供一个代理，并由代理对象控制对原对象的引用。

## 2.代码示例

### 示例1
静态代理类
```
public class HelloServiceProxy implements HelloService {
    private HelloService target;

    public HelloServiceProxy(HelloService target) {
        this.target = target;
    }

    @Override
    public void say(String msg) {
        target.say(msg);
    }

    @Override
    public String echo(String msg) {
        return target.echo(msg);
    }
}

```

StaticProxyDemo.java
```
public class StaticProxyDemo {

    public static void main(String[] args) {

        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = new HelloServiceProxy(helloService);

        proxy.say("ricky");

        System.out.println("************************");

        proxy.echo("hello, world");
    }
}
```

### 示例2
使用Jdk动态代理技术生成代理(被代理类必须实现某个接口)
```
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
```

### 示例3
使用CGLib生成代理实例
```
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
```

### 示例4
使用Javassist生成代理实例
```
nop
```
