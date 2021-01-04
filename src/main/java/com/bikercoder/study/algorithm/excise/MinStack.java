package com.bikercoder.study.algorithm.excise;

import java.util.Stack;

/**
 * @author caoguo
 * @Description： 最小栈: 实现入栈、出栈、获取当前栈的最小值，时间复杂度为O(1)
 * @date：1/4/21 9:38 PM
 **/
public class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /**
     * 入栈
     * @param element
     */
    public void push(Integer element){
        mainStack.push(element);
        // minStack用来放最小值，每次的入栈元素都和minStack的栈顶(也就是栈中的最小值)比较，如果入栈元素小于minStack的栈顶，则入栈minStack，此时的栈顶依旧是最小值
        if(minStack.size() == 0 || minStack.peek() >= element) {
            minStack.push(element);
        }
    }

    /**
     * 出栈
     * @return
     */
    public Integer pop(){
        Integer pop = null;
        if(mainStack.size() > 0) {
            pop = mainStack.pop();
            if(pop == minStack.peek()) {
                minStack.pop();
            }
        }
        return pop;
    }

    public Integer getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(13);
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(6);
        stack.push(2);
        stack.push(8);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }

}
