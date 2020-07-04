package com.algorithm;

import com.algorithm.utils.GetRandomArray;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] input = GetRandomArray.getArray(20);
        heapSort(input);

        System.out.println(Arrays.toString(input));
    }

    public static void heapSort (int[] input){
        int temp;
        for (int i = input.length/2 -1; i >= 0; i--) {
            adjustHeap(input, i, input.length);
        }
        for (int j = input.length-1; j>0; j--){
            temp = input[j];
            input[j] = input[0];
            input[0] = temp;

            adjustHeap(input, 0, j);
        }

    }
    public static void adjustHeap(int[] arr, int i, int length){
        int temp =arr[i];
        for (int j = i*2+1; j < length ; j = j*2+1) {
            if (j+1<length){
                if (arr[j] < arr[j+1])
                    j++;
            }
            if (arr[j] > temp){
                arr[i] = arr[j];
                i = j;
                arr[i] = temp;
            }else
                break;
        }
    }

}


/*class Sort {
    static int current;
    static int temp;//用于临时存储交换中的变量

    public static int[] heapSort(int[] input) {
        input = makeHeapDownToUp(input);//建堆

        int[] output = new int[input.length-1];
        int point = input.length-1;
        for (int i = 0; point > 0; i++) {
            output[i] = input[1];
            input[1] = input[point];
            input[point] = 0;
            point--;
            if (point != 0)
                input = makeHeapUpToDown(input, point);
        }
        return output;
    }

    static int[] makeHeapUpToDown(@NotNull int[] input, int size){
        int i = 1;
        while(i <= (size>>1)){
            if (input[i << 1] > input[i] || input[(i << 1) + 1]  > input[i]){
                if(input[i << 1] > input[(i << 1) + 1]){//左子节点大于右子节点
                    temp = input[i];//保存父节点的值
                    input[i] = input[i << 1];//将左子节点的值赋给父节点
                    input[i << 1] = temp;//将父节点的值赋给左子节点
                }else {                                                                         //右子节点大于左子节点
                    temp = input[i];//保存父节点的值
                    input[i] = input[(i << 1) + 1];//将右子节点的值赋给父节点
                    input[(i << 1) + 1] = temp;//将父节点的值赋给右子节点
                }
            }
            i++;
        }
       *//* if ((i << 1) == size){//这里用于处理只有一个子节点的父节点
            temp = input[i];//保存父节点的值
            input[i] = input[size];//将左子节点的值赋给父节点
            input[size] = temp;//将父节点的值赋给左子节点
            current--;
        }*//*
        return input;
    }
    static int[] makeHeapDownToUp(@NotNull int[] input){
        current = (input.length - 1) >> 1;
        if (((current << 1) == input.length-1) && input[input.length-1] > input[current]){//这里用于处理只有一个子节点的父节点
            temp = input[current];//保存父节点的值
            input[current] = input[current << 1];//将左子节点的值赋给父节点
            input[current << 1] = temp;//将父节点的值赋给左子节点
            current--;
        }
        input = exchangeHeap(input);
        return input;
    }
    static int[] exchangeHeap(int[] input){
        while(current > 0){
            if (input[current << 1] > input[current] || input[(current << 1) + 1]  > input[current]) {//如果左右子节点中有比父节点大的
                if(input[current << 1] > input[(current << 1) + 1]){//左子节点大于右子节点
                temp = input[current];//保存父节点的值
                input[current] = input[current << 1];//将左子节点的值赋给父节点
                input[current << 1] = temp;//将父节点的值赋给左子节点
                }else {                                                                         //右子节点大于左子节点
                temp = input[current];//保存父节点的值
                input[current] = input[(current << 1) + 1];//将右子节点的值赋给父节点
                input[(current << 1) + 1] = temp;//将父节点的值赋给右子节点
                }
            }
            current--;
        }
        return input;
    }
}*/
