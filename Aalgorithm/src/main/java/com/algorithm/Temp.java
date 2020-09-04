package com.algorithm;

import com.algorithm.utils.GetRandomArray;

import java.util.Arrays;

public class Temp {
    public static void main(String[] args) {
        int[] input = GetRandomArray.getArray(10);
        int[] temp = new int[input.length];
        sort(input, 0, input.length-1, temp);
        System.out.println(Arrays.toString(input));
    }
    public static void sort(int[] arr,int low,int high, int[] temp){
        if (low >= high) return;
        int mid = (low+high)/2;
        sort(arr, low, mid, temp);
        sort(arr, mid+1, high, temp);
        merge(arr,low, mid, high, temp);
    }
    public static void merge(int[] arr,int low,int mid,int high, int[] temp){
        int j = low;//左侧数组索引
        int k = mid+1;//右侧数组索引
        int i = 0;//辅助数组索引

        while(j <= mid && k <= high){
            if (arr[j] < arr[k]){
                temp[i] = arr[j];
                j++;
                i++;
            }else {
                temp[i] = arr[k];
                i++;
                k++;
            }
        }
        while(j <= mid){
            temp[i] = arr[j];
            i++;
            j++;
        }
        while(k <= high){
            temp[i] = arr[k];
            i++;
            k++;
        }
        /* 下面的写法是更加简洁的实现
        * if (i >= 0) System.arraycopy(temp, 0, arr, low + 0, i);
        * */
        for(int t=0;t<i;t++){
            arr[low+t] = temp[t];
        }
    }
}

class test{
    public static void main(String[] args) {
        int[] arr = GetRandomArray.getArray(10);/*{11,44,23,67,88,65,34,48,9,12};*/
        int[] tmp = new int[arr.length];    //新建一个临时数组存放
        mergeSort(arr,0,arr.length-1,tmp);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void merge(int[] arr,int low,int mid,int high,int[] tmp){
        int i = 0;
        int j = low,k = mid+1;  //左边序列和右边序列起始索引
        while(j <= mid && k <= high){
            if(arr[j] < arr[k]){
                tmp[i++] = arr[j++];
            }else{
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while(j <= mid){
            tmp[i++] = arr[j++];
        }

        while(k <= high){
            tmp[i++] = arr[k++];
        }
        /*  下面的写法是更加简洁的实现
        *   if (i >= 0) System.arraycopy(tmp, 0, arr, low + 0, i);
        * */
        for(int t=0;t<i;t++){
            arr[low+t] = tmp[t];
        }
    }

    public static void mergeSort(int[] arr,int low,int high,int[] tmp){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(arr,low,mid,tmp); //对左边序列进行归并排序
            mergeSort(arr,mid+1,high,tmp);  //对右边序列进行归并排序
            merge(arr,low,mid,high,tmp);    //合并两个有序序列
        }
    }

}
