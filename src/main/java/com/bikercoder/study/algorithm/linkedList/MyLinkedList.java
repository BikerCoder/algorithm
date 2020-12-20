package com.bikercoder.study.algorithm.linkedList;


/**
 * @author caoguo
 * @Description： 《小灰的算法之旅》链表
 * @date：12/16/20 9:25 PM
 **/
public class MyLinkedList {

    private Node head;
    private int size;

    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) throws Exception{
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.head = new Node(1);
        linkedList.size++;
        Node head = linkedList.head;
        head.next = new Node(2);
        linkedList.size++;
        head.next.next = new Node(3);
        linkedList.size++;
        head.next.next.next = new Node(4);
        linkedList.size++;
        head.next.next.next.next = new Node(5);
        linkedList.size++;
        linkedList.insert(0,0);
        linkedList.insert(7,2);
        linkedList.insert(0,7);
        linkedList.remove(4);
        linkedList.printOut();
    }

    /**
     * 打印输出链表各个节点数据
     * @throws Exception
     */
    private void printOut() throws Exception{
        Node node = head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    /**
     * 删除节点
     * @param index 节点下标
     * @return
     * @throws Exception
     */
    private Node remove(int index) throws Exception{
        if (index >= size || index < 0) {
            throw  new Exception("超出链表下标");
        }
        Node romoveNode = get(index);
        if(index == 0) {
            // 移除头部
            head = romoveNode.next;
        } else {
            // 移除中间
            Node prev = get(index - 1);
            prev.next = romoveNode.next;
        }
        size --;
        return romoveNode;
    }

    /**
     * 插入节点
     * @param data 节点数据
     * @param index 节点下标
     * @throws Exception
     */
    private void insert(int data, int index) throws Exception {
        Node insertNode = new Node(data);
        if(size == 0) {
            // 空链表插入
            head = insertNode;
        } else if(index == 0) {
            // 头部插入
            insertNode.next = head;
            head = insertNode;
        } else {
            // 中间插入
            Node preNode = get(index - 1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }
        size ++;
    }

    /**
     * 获取下标位置的链表节点
     * @param index 下标
     * @return
     * @throws Exception
     */

    private Node get(int index) throws Exception {
        if (index >= size){
            throw new Exception("超出链表下标");
        }
        Node getNode = this.head;
        for(int i = 0; i < index; i++){
            getNode = getNode.next;
        }
        return getNode;
    }

}
