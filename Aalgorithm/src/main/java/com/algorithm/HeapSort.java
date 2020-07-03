package com.algorithm;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] input = new int[10];
        for (int i = 1; i < 10; i++) {
            input[i] = random.nextInt(999);
        }
        int[] answer = input;
        Arrays.sort(answer);//答案

        int[] result = Sort.heapSort(input);//堆排序（大顶堆，由大至小）

        System.out.println(Arrays.equals(input, answer));
    }
}

class Sort {
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
            try {
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
            } catch (ArrayIndexOutOfBoundsException ignored) {

            }
        }
        return input;
    }
    static int[] makeHeapDownToUp(@NotNull int[] input){
        current = (input.length - 1) >> 1;
        if ((current << 1) == input.length){//这里用于处理只有一个子节点的父节点
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
}
