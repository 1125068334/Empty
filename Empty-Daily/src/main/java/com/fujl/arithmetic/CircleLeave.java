package com.fujl.arithmetic;

import java.util.*;

/**
 * 100个人围成一个圈编号1-100，从1开始依次报数，当数到数字当中包含7或者7的倍数时下去一个，最后剩下的是几号
 * 报号
 * 取余
 * 循环退出
 * 1. 使用map结构 k-编号 v-报号
 * 2. 初始编号 m
 * 3. 去除编号 n - 对应v
 * 4. 编号总数 t
 */
public class CircleLeave {

    public static void main(String[] args) {
        System.out.println(leave(5,1,2));
    }

    /**
     * @param t 初始编号总数
     * @param m 从哪个编号开始
     * @param n 去除的编号-对应value
     * @return 返回最后剩下的编号
     */
    public static Integer leave(int t, int m, int n) {
        boolean[] arr = new boolean[t];
        Arrays.fill(arr, true);
        int leftCount = t;
        int index = m - 1;
        int count = 0;
        while (leftCount > 1) {
            if (arr[index]) {
                count++;
                if (filter(count, n)) {
                    arr[index] = false;
                    leftCount--;
                }
            }
            index++;
            if (index == t) {
                index = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                return i + 1;
            }
        }
        return null;
    }

    private static boolean filter(int i,int j){
        // 判断i是j的倍数
        if (i % j == 0) {
            return true;
        }
        // 判断i中含有j
        while (i > j) {
            if (i % 10 == j) {
                return true;
            }
            i /= 10;
        }
        return false;
    }
}
