package com.fujl.arithmetic.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 * best:T(n)=O(n)， worst: T(n)=O(n^2); average: T(n)=O(n^2)
 * 算法描述：
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * 重复步骤1~3，直到排序完成
 *
 *
 */
public class EmptySort {

    private final static int[] arr = {10, 8, 19, 30, 99, 78, 98, 0, 55, 9, 5, 2, 3, 4, 1};

    @Test
    public void test(){

        System.out.println(Arrays.toString(insertionSort(arr)));

    }

    /**
     * todo
     */
    public static int[] shellSort(int[] arr) {
        if (null == arr || arr.length < 1) {
            return arr;
        }
        int len = arr.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                }
            }
        }

        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        if (null == arr || arr.length < 1) {
            return arr;
        }
        int len = arr.length;
        int current;
        for (int i = 0; i < len - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        if (null == arr || arr.length < 1) {
            return arr;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


    public static int[] bubbleSort(int[] arr) {
        if (null == arr || arr.length < 1) {
            return arr;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
