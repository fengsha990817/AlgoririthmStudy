package com.algorithm.utils;


import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class GetRandomArray {
    @NotNull
    public static int[] getArray(int num){
        Random random = new Random();
        int[] input = new int[num];
        for (int i = 0; i < num; i++) {
            input[i] = random.nextInt(999);
        }
        return input;
    }
}
