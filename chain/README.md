# 责任链模式 (Chain of Responsibility)
## 1.模式定义
> 责任链模式在面向对象程式设计里是一种软件设计模式，它包含了一些命令对象和一系列的处理对象。
> 每一个处理对象决定它能处理哪些命令对象，它也知道如何将它不能处理的命令对象传递给该链中的下一个处理对象。
> 该模式还描述了往该处理链的末尾添加新的处理对象的方法。


责任链模式涉及到的角色如下所示：

* 抽象处理者(Handler)角色：定义出一个处理请求的接口。如果需要，接口可以定义 出一个方法以设定和返回对下家的引用。这个角色通常由一个Java抽象类或者Java接口实现。

*具体处理者(ConcreteHandler)角色：具体处理者接到请求后，可以选择将请求处理掉，或者将请求传给下家。由于具体处理者持有对下家的引用，因此，如果需要，具体处理者可以访问下家。


## 2.代码示例

### 示例1
原生责任链模式
```
public interface Handler {

    void handlerRequest(Request request);

    /**指定下一个处理器*/
    void setSuccessor(Handler successor);

}
```

ConcreteHandler.java
```
public class ConcreteHandler implements Handler {
    private String type; //处理请求类型

    private Handler successor;

    public ConcreteHandler(String type) {
        this.type = type;
    }

    @Override
    public void handlerRequest(Request request) {

        if(type.equals(request.getType())){ //是自己的任务
            System.out.println("Handler_"+type+" handlerRequest exec......");
            return;
        } else{  //不是自己的任务, 传递给下一个
            if(this.successor!=null){
                System.out.println("Handler_"+type+" handlerRequest dispatch to successor");
                this.successor.handlerRequest(request);
            } else{
                System.out.println("Handler_"+type+" no next handler");
            }
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

}
```

client:
```
ConcreteHandler handler1 = new ConcreteHandler("1");
ConcreteHandler handler2 = new ConcreteHandler("2");
ConcreteHandler handler3 = new ConcreteHandler("3");

//形成调用链
handler1.setSuccessor(handler2);
handler2.setSuccessor(handler3);

Request request = new Request("3");
handler1.handlerRequest(request);
```

### 示例2
Servlet Filter
```
public interface Filter {

    void doFilter(ServletRequest request, ServletResponse response,
                  FilterChain chain) throws Exception;
}
```

FilterChain
```
public interface FilterChain {

    void doFilter(ServletRequest request, ServletResponse response) throws Exception;
}
```

FilterChainImpl
```
public class FilterChainImpl implements FilterChain {
    private int pos;    //当前位置
    private List<Filter> filters;
    private HttpHandler next;

    public FilterChainImpl(List<Filter> filters, HttpHandler next) {
        this.filters = filters;
        this.next = next;
        this.pos = 0;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws Exception {
        if (pos >= filters.size()) {
            this.next.handleRequest(request, response);
        } else {
            Filter filter =  filters.get(pos++);
            filter.doFilter(request, response, this);
        }
    }
}
```

client:
```
    List<Filter> filters = new ArrayList<>();
    for(int i=1; i<=5;i++){
        final int id = i;
        filters.add(new Filter() {
            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws Exception {
                System.out.println("Filter_"+id+" execute...");
                chain.doFilter(request, response);
            }
        });
    }

    ServletRequest request = new ServletRequest();
    ServletResponse response = new ServletResponse();
    HttpHandler httpHandler = new HttpHandler();    //http请求处理器
    FilterChain filterChain = new FilterChainImpl(filters, httpHandler);

    filterChain.doFilter(request, response);

```






