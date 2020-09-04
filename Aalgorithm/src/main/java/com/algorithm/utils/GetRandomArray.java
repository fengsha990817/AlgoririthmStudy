package com.algorithm.utils;


import java.util.Random;

public class GetRandomArray {
    public static int[] getArray(int num){
        Random random = new Random();
        int[] input = new int[num];
        for (int i = 0; i < num; i++) {
            input[i] = random.nextInt(999);
        }
        return input;
    }
}
