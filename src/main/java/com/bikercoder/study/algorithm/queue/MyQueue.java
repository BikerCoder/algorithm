package com.bikercoder.study.algorithm.queue;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description：《小灰的算法之旅》队列代码示例：采用数组实现队列
 * @date：12/12/20 6:34 PM
 **/
public class MyQueue {

    private int[] array; // 数组
    private int front; // 队头
    private int rear; // 队尾

    public MyQueue(int capacity){
        this.array = new int[capacity];
    }

    /**
     * 入队
     * @param element 入队元素
     * @throws Exception
     */
    public void enQueue(int element) throws Exception {
        if((rear + 1) % array.length == front){
            throw new Exception("队列已满");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     * @return
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if(rear == front){
            throw new Exception("队列已空");
        }
        int deElement = array[front];
        array[front] = 0;
        front = (front + 1) % array.length;
        return deElement;
    }

    public static void main(String[] args) throws Exception{
        MyQueue myQueue = new MyQueue(6);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.deQueue();
        myQueue.deQueue();
        System.out.println(Arrays.toString(myQueue.array));
    }

}
