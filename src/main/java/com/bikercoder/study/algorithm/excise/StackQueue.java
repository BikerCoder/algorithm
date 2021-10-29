package com.bikercoder.study.algorithm.excise;

import java.util.Stack;

/**
 * @author caoguo
 * @Description： 用栈实现队列
 * @date：1/6/21 9:18 PM
 **/
public class StackQueue {

    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /**
     * 入队：新元素压入A中
     * @param element
     */
    public void enQueue(Integer element) {
        stackA.push(element);
    }

    /**
     * 出队
     * @return
     */
    public Integer deQueue() {
        if(stackB.isEmpty()) {
            if(stackA.isEmpty()) {
                return null;
            }
            transfer();
        }
        return stackB.pop();

    }

    /**
     * 将A中的数据依次出栈，并按出栈的顺序入栈到B中
     */
    private void transfer() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue(5);
        stackQueue.enQueue(6);
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue(7);
        stackQueue.enQueue(8);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }


}
