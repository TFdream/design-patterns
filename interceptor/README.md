# 拦截器模式 (Interceptor pattern)
## 1.模式定义


## 2.代码示例
### 示例1
```
public interface Interceptor {

    void intercept(Request request, InterceptorChain chain);
}
```

InterceptorChain
```
public interface InterceptorChain {

    void proceed(Request request);
}
```

InterceptorChainImpl
```
public class InterceptorChainImpl implements InterceptorChain {
    private int pos;
    private List<Interceptor> interceptors;

    public InterceptorChainImpl(List<Interceptor> interceptors) {
        this.interceptors = interceptors;
        this.pos = 0;
    }

    @Override
    public void proceed(Request request) {

        if(pos<interceptors.size()){
            Interceptor interceptor = interceptors.get(pos++);
            interceptor.intercept(request, this);
        }
    }
}
```

client:
```
public class InterceptorDemo {

    public static void main(String[] args) {

        List<Interceptor> interceptors = new ArrayList<>();

        for(int i=1; i<=5; i++){
            final int id = i;
            interceptors.add(new Interceptor() {
                @Override
                public void intercept(Request request, InterceptorChain chain) {

                    System.out.println("Interceptor_"+id+" intercept...");
                    chain.proceed(request);
                }
            });
        }

        Request request = new Request();
        InterceptorChain chain = new InterceptorChainImpl(interceptors);
        chain.proceed(request);
    }
}
```




