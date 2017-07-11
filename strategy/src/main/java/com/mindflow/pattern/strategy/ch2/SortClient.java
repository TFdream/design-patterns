package com.mindflow.pattern.strategy.ch2;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 13:15
 */
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
