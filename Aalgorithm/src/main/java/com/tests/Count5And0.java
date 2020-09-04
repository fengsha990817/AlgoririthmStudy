package com.tests;

import java.util.Random;

/**
 * 数位：
 *      给定一组输入，其中含有不定的5和0，总数小于1000大于1，要求给出能被90整除的最大的数。
 *      如果存在则输出该数，不存在则输出-1
 *      注意：0也是答案
 *
 *      输入示例：
 *      11
 *      5 5 5 5 5 5 0 9 9 9 9
 *
 *      输出示例：
 *      5555555550
 */
public class Count5And0 {
    public static void main(String[] args) {
        int[] input = get5and0();
        int n = input.length;
        StringBuilder builder = new StringBuilder();
        int five = 0;
        int zero = 0;
        for (int j : input) {
            switch (j) {
                case 5:
                    five++;
                    break;
                case 0:
                    zero++;
                    break;
                default:
                    break;
            }
        }
        if (five < 9){
            if (zero == 0){
                System.out.println(-1);
                return;
            }else {
                System.out.println(0);
            }
        }
        int fiveNumber = five/9;
        /* 下面的写法是更加简洁的实现
        * builder.append("5".repeat(Math.max(0, fiveNumber * 9)));
        * builder.append("0".repeat(Math.max(0, zero)));
        * */
        for (int i = 0; i < fiveNumber * 9; i++) {
            builder.append(5);
        }
        for (int i = 0; i < zero; i++) {
            builder.append(0);
        }
        System.out.println(builder.toString());
        System.out.println(five+" " +zero);
    }

    public static int[] get5and0(){
        Random random = new Random();
        int[] target;
        int five = random.nextInt(800) + 1;
        int zero = random.nextInt(200) + 1;
        target = new int[five+zero];
        for (int i = 0; i < five; i++) {
            target[i] = 5;
        }
        for (int i = five; i < five+zero; i++) {
            target[i] = 0;
        }
        return target;
    }
}
