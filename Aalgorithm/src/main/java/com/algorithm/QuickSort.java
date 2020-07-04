package com.algorithm;

import com.algorithm.utils.GetRandomArray;
import org.jetbrains.annotations.NotNull;

public class QuickSort {
    public static void main(String[] args) {
        @NotNull int[] input = GetRandomArray.getArray(10);
        input = quickSort.doSort(input);
    }
}

class quickSort{
    public static int[] doSort(int[] input) {
        int split;
        while (true){
            split = (int)(Math.random()*(input.length))+1;
            System.out.println(split);
        }
        /*return null;*/
    }
}
