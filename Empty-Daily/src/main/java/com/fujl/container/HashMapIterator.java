package com.fujl.container;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HashMap遍历:
 *  1. 迭代器(Iterator)方式遍历
 *      1.1 entrySet
 *      1.2 keySet
 *  2. For Each方式遍历
 *      2.1 entrySet遍历
 *      2.2 keySet遍历
 *  3. Lambda表达式遍历
 *  4. StreamApi遍历
 *      4.1 StreamApi单线程遍历
 *
 */
public class HashMapIterator {

    public static void main(String[] args) {
        Map<Integer, Object> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"hello");
        map.put(3,"world");

    }

    private static void iteratorByEntrySet(Map<Integer, Object> map) {
        if (!CollectionUtils.isEmpty(map)) {
            for (Map.Entry<Integer, Object> next : map.entrySet()) {
                System.out.print(next.getKey());
                System.out.println(next.getValue());
            }
        }
    }

    private static void iteratorByKeySet(){

    }
}
