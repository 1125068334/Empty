package com.fujl.arithmetic.sort;

public class QuickSort {



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
