package com.tests;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * 最大交换：给定一个数字（小于2^32),在最多交换一次任意两个数字的情况下，返回可能的最大数字
 */

public class MaximumSwap {
    public static void main(String[] args) {
        MaximumSwap swap = new MaximumSwap();
        for (int j = 0; j < 10; j++) {
            System.out.println(swap.maximumSwap((int) (Math.random() * 100000)));
            System.out.println("---------------");
        }

    }
    public int maximumSwap(int num) {
        System.out.println(num);
        Comparator<Character> comparator = (o1, o2) -> o2-o1;
        if(num <= 9)
            return num;
        char[] input = String.valueOf(num).toCharArray();
        Character[] sorted = new Character[input.length];
        for (int i = 0; i < input.length; i++) {
            sorted[i] = input[i];
        }
        Arrays.sort(sorted, comparator);
        int inputFind = -1;
        char sortedFind = ' ';
        for (int i = 0; i <input.length; i++) {
            if (input[i] != sorted[i]){
                inputFind = i;
                sortedFind = sorted[i];
                break;
            }
        }
        if (inputFind != -1 && sortedFind != ' '){
            for (int i = input.length-1; i >= 0 ; i--) {
                if (input[i] == sortedFind){
                    char temp = input[inputFind];
                    input[inputFind] = input[i];
                    input[i] = temp;
                    break;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c:input){
            builder.append(c);
        }
        return Integer.valueOf(builder.toString());
    }
}
