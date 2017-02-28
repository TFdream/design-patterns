# strategy pattern (策略模式)

完成一项任务，往往可以有多种不同的方式，每一种方式称为一个策略，我们可以根据环境或者条件的不同选择不同的策略来完成该项任务。

在软件开发中也常常遇到类似的情况，实现某一个功能有多个途径，此时可以使用一种设计模式来使得系统可以灵活地选择解决途径，也能够方便地增加新的解决途径。

为了解决这些问题，可以定义一些独立的类来封装不同的算法，每一个类封装一个具体的算法，在这里，每一个封装算法的类我们都可以称之为策略(Strategy)，为了保证这些策略的一致性，一般会用一个抽象的策略类来做算法的定义，而具体每种算法则对应于一个具体策略类。

## 模式定义
> 定义一系列算法，将每一个算法封装起来，并让它们可以相互替换。策略模式让算法独立于使用它的客户而变化，也称为政策模式(Policy)。

## 模式结构
策略模式包含如下角色：

* Context: 环境类
* Strategy: 抽象策略类
* ConcreteStrategy: 具体策略类

## 代码示例
### 示例1

```
public interface Strategy {
    void algorithm();
}
```

```
public class ConcreteStrategy1 implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("具体策略1");
    }
}
```

```
public class ConcreteStrategy2 implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("具体策略2");
    }
}
```

```
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void algorithm(){
        strategy.algorithm();
    }
}
```

client:
```
public class Client {

    public static void main(String[] args) {

        Context context = new Context();
        System.out.println("-----执行策略1-----");
        context.setStrategy(new ConcreteStrategy1());
        context.algorithm();

        System.out.println("-----执行策略2-----");
        context.setStrategy(new ConcreteStrategy1());
        context.algorithm();
    }
}
```

### 示例2
排序算法
```
public interface Sort {

    void sort(int[] arr, int start, int end);
}
```

冒泡排序
```
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] arr, int start, int end) {
        System.out.println("冒泡排序实现");
        for(int i=start; i<end; i++){
            for(int j = start; j<arr.length-i-1; j++){
                //这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
```

快速排序
```
public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr, int start, int end) {
        System.out.println("快速排序实现");
        quickSort(arr, start, end-1);
    }

    private void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);
        }
    }
}
```

```
public class Context {
    private Sort strategy;

    public void setStrategy(Sort strategy){
        this.strategy = strategy;
    }

    public void sort(int[] arr, int start, int end) {
        strategy.sort(arr, start, end);
    }
}
```

client:
```
public class SortClient {

    public static void main(String[] args) {

        int[] arr = {10, 1, 8, 6, 5, 3, 2};

        Context context = new Context();
        System.out.println("-----执行冒泡排序-----");
        context.setStrategy(new BubbleSort());
        context.sort(arr, 0, arr.length);

        System.out.println("-----执行快速排序-----");
        context.setStrategy(new QuickSort());
        context.sort(arr, 0, arr.length);
    }
}
```

## 优点
策略模式的优点:

易于扩展，用户可以在不修改原有系统的基础上选择算法或行为，也可以灵活地增加新的算法或行为。
策略模式提供了可以替换继承关系的办法。
使用策略模式可以避免使用多重条件转移语句。

## 缺点
策略模式的缺点:

* 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
* 策略模式将造成产生很多策略类: 可以通过使用享元模式在一定程度上减少对象的数量。




