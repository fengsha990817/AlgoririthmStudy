package com.algorithm;

import java.util.Arrays;

/**
 * KMP算法实现
 */

public class KMP {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] pattern = "ABCDABDF".toCharArray();
        char[] text = "BBC ABCDAB ABCDABCDABDE".toCharArray();
        solution.kmp_search(text, pattern);
    }
}
class Solution{
    public void getNext (char[] pattern, int[] prefix){
        prefix[0] = -1;
        int k = -1;
        int j = 0;
        while(j < pattern.length - 1){
            if (k == -1 || pattern[j] == pattern[k]){
                k++;j++;
                prefix[j] = k;
            }else{
                k = prefix[k];
            }
        }
    }
    public void kmp_search(char[] text, char[] pattern){
        int i = 0;
        int j = 0;
        int m = text.length;
        int n = pattern.length;
        int[] prefix = new int[n];
        boolean isFind = false;
        getNext(pattern,prefix);
        System.out.println(Arrays.toString(prefix));

        while(i <= m-1){//未匹配到主串的末尾
            if (j == n-1 && text[i] == pattern[j]){//当模式串匹配到末尾且当前匹配的字符相等，则说明匹配成功
                System.out.println("所需字符串起始于"+(i-j));
                isFind = true;
                for (int k = i-j; k <= i ; k++) {
                    System.out.print(text[k]);
                }
                System.out.println();
                j = prefix[j];//继续匹配后面未匹配的主串
            }
            if (j == -1 || text[i] == pattern[j]){//当前匹配的字符相等或者j == -1时
                i++;
                j++;
            }else{//当前匹配的字符不相等
                j = prefix[j];//移动字符串
            }
        }
        if (!isFind){
            System.out.println("未找到给定的字符串");
        }
    }

/*    public int kmpSearch (char[] text, char[] pattern){
        int i = 0;
        int j =0;
        int textLength = text.length;
        int patternLength = pattern.length;
        int[] prefix = new int[patternLength];
        prefix_table(pattern,prefix,patternLength);
//        move_prefix_table(prefix,patternLength);
        while (i <textLength && j < patternLength){
            if (j == -1 || text[i] == pattern[j]){
                i++;j++;
            }else{
                j = prefix[j];
            }
            if (j == patternLength){
                return i-j;
            }else{
                return -1;
            }
        }
        return -1;
    }*/
}