package com.fujl.arithmetic.cache;

import java.util.HashMap;
import java.util.Map;

public class LruCache<K, V> {

    private Node head;
    private Node tail;
    private int capacity;
    private Map<K, Node> map;

    public LruCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public V put(K key, V value) {
        Node node = map.get(key);
        if (node != null) {
            V oldValue = node.value;
            node.value = value;
            moveToTail(node);
            return oldValue;
        } else {
            Node newNode = new Node(key, value);
            if (map.size() == capacity) {
                map.remove(removeHead(), key);
            }
            addToTail(newNode);
            map.put(key, newNode);
            return null;
        }
    }

    public V get(K key) {
        Node node = map.get(key);
        if (node != null) {
            moveToTail(node);
            return node.value;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LruCache{");
        Node curr = head;
        while (curr != null) {
            if (curr != head) {
                sb.append(',').append(' ');
            }
            sb.append(curr.key);
            sb.append('=');
            sb.append(curr.value);
            curr = curr.next;
        }
        return sb.append('}').toString();
    }

    private void addToTail(Node newNode) {
        if (newNode == null) {
            return;
        }
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        }
    }

    private void moveToTail(Node node) {
        if (tail == node) {
            return;
        }
        if (head == node) {
            head = node.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.pre = tail;
        node.next = null;
        tail.next = node;
        tail = node;
    }

    private Node removeHead() {
        if (head == null) {
            return null;
        }
        Node res = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = res.next;
            head.pre = null;
            res.next = null;
        }
        return res;
    }

    class Node {
        K key;
        V value;
        Node pre;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LruCache<String, String> cache = new LruCache(3);
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
