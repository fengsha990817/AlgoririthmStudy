package com.algorithm;

public class Sorts {
    /**
     * 希尔排序
     */
    static class ShellSort{
        public static void shellSortMove(int[] input){
            long first = System.currentTimeMillis();
            int count =0, swap = 0, gap;
            gap = input.length/3;
            if (gap < 1){
                gap = 1;
            }
            for (;gap>0; gap/=3){
                for (int i = gap; i < input.length ; i++) {
                    int j = i;
                    int insert = input[j];
                    if (input[j] < input[j-gap]){
                        while(j-gap >= 0 && insert < input[j-gap]){
                            input[j] = input[j - gap];
                            j-=gap;
                        }
                        input[j] = insert;
                        swap++;
                    }
                }
                count++;
            }
            long second = System.currentTimeMillis();
            System.out.println(second-first);
            System.out.println("count:"+count+"swap:"+swap);
        }
        public static void shellSortExchange(int[] input){
            long first = System.currentTimeMillis();
            int count =0, swap = 0;
            for (int gap = input.length/2; gap>0; gap/=2){
                for (int i = gap; i < input.length ; i++) {
                    for (int j = i-gap; j >= 0 ; j-=gap) {
                        if (input[j] > input[j+gap]){
                            exchange(input,j,j+gap);
                            swap++;
                        }
                    }
                }
                count++;
            }
            long second = System.currentTimeMillis();
            System.out.println(second-first);
            System.out.println("count:"+count+"swap:"+swap);
        }
    }

    /**
     * 堆排序（大顶堆）
     */
    static class HeapSort{
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

    /**
     * 插入排序
     */
    static class InsertionSort{
        public static void insertionSortSwap(int[] input){//标准的插入排序
            int n = input.length;
            int exchange = 0;
            for (int i = 1; i < n; i++) {
                for (int j = i; j >0 && input[j]<input[j-1]; j--) {
                    exchange(input, j, j-1);
                    exchange++;
                }
            }
            System.out.println("交换次数："+exchange);
        }
        public static void insertionSortMove(int[] input){//改进后的插入排序
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


    /**
     * 交换数组对象的公共方法
     * @param target
     * @param from
     * @param to
     */
    public static void exchange(int[] target, int from, int to){
        int temp = target[from];
        target[from] = target[to];
        target[to] = temp;
    }
}
