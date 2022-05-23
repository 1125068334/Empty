package com.fujl.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9, 9, 0, 10, 12};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort(int[] array){
        int len = array.length;
        if (len <= 0) {
            return;
        }
        int temp;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = array[i];
                int b = array[j];
                if (a <= b) {
                    temp = a;
                    array[i] = b;
                    array[j] = temp;
                }
            }
        }
    }
}
