package com.fujl.arithmetic.lfu;

import java.util.*;

public class LfuCache<K, V> {

    private int capacity;
    private int minUsedCount;
    private Map<K, Node> map;
    private Map<Integer, List<Node>> usedCountMap;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        this.minUsedCount = 1;
        this.map = new HashMap<>();
        this.usedCountMap = new HashMap<>();
    }

    private V get(K key){
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        addUsedCount(node);
        return node.value;
    }

    public V put(K key, V value) {
        Node node = map.get(key);
        if (node != null) {
            V oldValue = node.value;
            node.value = value;
            addUsedCount(node);
            return oldValue;
        } else {
            if (map.size() == capacity) {
                List<Node> list = usedCountMap.get(minUsedCount);
                Node delNode = list.get(0);
                list.remove(delNode);
                map.remove(delNode.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            List<Node> list = usedCountMap.computeIfAbsent(1, k -> new LinkedList<>());
            list.add(newNode);
            minUsedCount = 1;
            return null;
        }
    }


    private void addUsedCount(Node node) {
        List<Node> oldList = usedCountMap.get(node.usedCount);
        oldList.remove(node);

        if (minUsedCount == node.usedCount && oldList.isEmpty()) {
            minUsedCount++;
        }
        node.usedCount++;
        List<Node> set = usedCountMap.get(node.usedCount);
        if (set == null) {
            set = new LinkedList<>();
            usedCountMap.put(node.usedCount, set);
        }
        set.add(node);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LfuCache{");
        List<Integer> usedCountList = new ArrayList<>(this.usedCountMap.keySet());
        usedCountList.sort(Comparator.comparingInt(i -> i));
        int count = 0;
        for (Integer usedCount : usedCountList) {
            List<Node> list = this.usedCountMap.get(usedCount);
            if (list == null) {
                continue;
            }
            for (Node node : list) {
                if (count > 0) {
                    sb.append(',').append(' ');
                }
                sb.append(node.key)
                        .append('=')
                        .append(node.value)
                        .append("(UsedCount:")
                        .append(node.usedCount)
                        .append(')');
                count++;
            }
        }
        return sb.append('}').toString();
    }


    class Node {
        K key;
        V value;
        int usedCount = 1;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LfuCache<String, String> cache = new LfuCache(3);
        cache.put("keyA", "valueA");
        System.out.println("put keyA");
        System.out.println(cache);
        System.out.println("=========================");

        cache.put("keyB", "valueB");
        System.out.println("put keyB");
        System.out.println(cache);
        System.out.println("=========================");

        cache.put("keyC", "valueC");
        System.out.println("put keyC");
        System.out.println(cache);
        System.out.println("=========================");

        cache.get("keyA");
        System.out.println("get keyA");
        System.out.println(cache);
        System.out.println("=========================");

        cache.put("keyD", "valueD");
        System.out.println("put keyD");
        System.out.println(cache);
    }
}
