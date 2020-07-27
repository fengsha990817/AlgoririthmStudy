package com.algorithm;

import com.algorithm.utils.GetRandomArray;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] input = GetRandomArray.getArray(10);
        sortNew(input);
        System.out.println(Arrays.toString(input));
    }
    public static void sort(int[] input){//标准的插入排序
        int n = input.length;
        int exchange = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >0 && input[j]<input[j-1]; j--) {
                int temp = input[j];
                input[j] = input[j-1];
                input[j-1] =temp;
                exchange++;
            }
        }
        System.out.println("交换次数："+exchange);
    }
    public static void sortNew(int[] input){//改进后的插入排序
        int n = input.length;
        int exchange = 0;
        for (int i = 1; i < n; i++) {
            int exc = input[i];
            int insertIndex = i;
            while(insertIndex > 0 && exc < input[insertIndex-1]){
                input[insertIndex] = input[insertIndex-1];
                insertIndex--;
            }
            input[insertIndex] = exc;
            exchange++;
        }
        System.out.println("交换次数："+exchange);
    }

}
