package com.bikercoder.study.algorithm.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoguo
 * @Description： 146. LRU 缓存机制  https://leetcode-cn.com/problems/lru-cache/
 * @date：2021/11/28 10:10 下午
 **/
public class LRUCache {
    private int capacity;
    private int size;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            size++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);

        return res;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addHead(node);
    }

    private void addHead(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;

    DLinkedNode() {
    }

    DLinkedNode(int _key, int _value) {
        key = _key;
        value = _value;
    }
}
