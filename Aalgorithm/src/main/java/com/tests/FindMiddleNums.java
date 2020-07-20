package com.tests;

import java.util.ArrayList;
import java.util.List;

public class FindMiddleNums {
    public static void main(String[] args) {
        FindMiddleNums unit = new FindMiddleNums();
        int[] in = {7,10,9,11,15,12,20,27,24,28,32,30,36,33,48,55};
        unit.findMiddle(in);

    }
    public void findMiddle(int[] input){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (i == 0){
                if (input[i] < input[i+1]){
                    list.add(input[i]);
                    continue;
                }
            }//特殊情况1：开头，只比较右侧
            if (i == input.length-1){
                if (input[i] > input[i-1]){
                    if (input[i] > list.get(list.size()-1)){
                        list.add(input[i]);
                    }else{
                        list.add(list.size()-1, input[i]);
                    }
                }
                break;
            }//特殊情况2：结尾，只比较前侧
            if (input[i] > input[i-1] && input[i] < input[i+1]){
                if (input[i] < list.get(list.size()-1)){
                    list.set(list.size()-1, input[i]);
                }else{
                    list.add(input[i]);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int out:list){
            builder.append(out).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        System.out.println(builder.toString());
    }
}
