package com.mindflow.pattern.strategy.ch2;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 13:18
 */
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
