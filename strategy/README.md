# strategy pattern (策略模式)

## 模式定义
> 定义一系列算法，将它们一个个封装起来，并且使他们之间可以相互替换。本模式使得算法可以独立于使用它的客户而变化。

策略模式是对算法的封装，把一系列的算法分别封装到对应的类中，并且这些类实现相同的接口，相互之间可以替换。
在前面说过的行为类模式中，有一种模式也是关注对算法的封装——模版方法模式，对照类图可以看到，策略模式与模版方法模式的区别仅仅是多了一个单独的封装类Context，
它与模版方法模式的区别在于：在模版方法模式中，调用算法的主体在抽象的父类中，而在策略模式中，调用算法的主体则是封装到了封装类Context中，抽象策略Strategy一般是一个接口，目的只是为了定义规范，里面一般不包含逻辑。

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
public class ConcreteStrategyA implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("具体策略1");
    }
}
```

```
public class ConcreteStrategyB implements Strategy {

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
        context.setStrategy(new ConcreteStrategyA());
        context.algorithm();

        System.out.println("-----执行策略2-----");
        context.setStrategy(new ConcreteStrategyB());
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




