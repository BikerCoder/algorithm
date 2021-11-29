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

    /**
     * 根据key获取value
     *
     * @param key
     * @return
     */
    public int get(int key) {
        // 根据kye从缓存中获取节点，节点为空则返回-1
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        // 不为空则将节点移动到头部
        moveToHead(node);
        // 返回value
        return node.value;
    }

    /**
     * 将kye-value存入cache
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // 先根据key去cache中获取节点
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 节点为空，则新建节点，将key-node存入cache
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            // 将节点添加到头部
            addToHead(newNode);
            // size++
            size++;
            // 判断是否超出容量，超出容量则需要移除末尾节点
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 如果节点不为空，则表示存在旧值，覆盖value
            node.value = value;
            // 将节点移动到头部
            moveToHead(node);
        }
    }

    /**
     * 移除末尾节点
     *
     * @return
     */
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);

        return res;
    }

    /**
     * 将节点移动到头部
     *
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 添加节点到头部
     *
     * @param node
     */
    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    /**
     * 移除节点
     *
     * @param node
     */
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
