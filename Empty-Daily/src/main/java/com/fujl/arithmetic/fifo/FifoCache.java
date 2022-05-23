package com.fujl.arithmetic.fifo;



import java.util.*;

public class FifoCache<K,V> {

    private int capacity;
    private Map<K, Node> map;
    private LinkedList<K> kQueue = new LinkedList<>();


    public FifoCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    private V get(K key){
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        kQueue.remove(key);
        kQueue.addLast(key);
        return node.value;
    }

    public V put(K key, V value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            kQueue.remove(node);
            node.value = value;
            map.put(key,node);
            kQueue.addLast(key);
            return value;
        } else {
            if (kQueue.size() == capacity) {
                K first = kQueue.getFirst();
                map.remove(first);
                kQueue.removeFirst();
            }
            node = new Node(key, value);
            kQueue.addLast(key);
            map.put(key, node);
            return value;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FifoCache{");
        for (K key : kQueue) {
            Node node = map.get(key);
            sb.append(node.key)
                    .append('=')
                    .append(node.value);
        }
        return sb.append('}').toString();
    }


    class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        FifoCache<String, String> cache = new FifoCache(3);
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
