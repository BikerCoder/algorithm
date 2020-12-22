package com.bikercoder.study.algorithm.queue;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description： 《小灰的算法之旅》优先队列
 * 普通队列为先进先出，优先队列则不一样，分为最小优先队列、最大优先队列
 * 最小优先队列：不管入队的顺序是怎样，出队的元素总是队列中值最小的元素
 * 最大优先队列：则与最下优先队列相反。不管入队的顺序是怎样，出队的元素总是队列中值最大的元素。
 * 可以才有二叉堆来实现优先队列，最小优先队列的入队操作就对应二叉堆的插入元素，再进行上浮调整。
 * 出队就对应二叉堆的删除元素，即删除堆顶元素，再进行下沉调整
 * @date：12/21/20 11:09 PM
 **/
public class PriorityQueue {
    int size;
    int[] array;

    private void enQueue(int data) {
        if (array.length >= size) {
            resize();
        }
        array[size++] = data;
        upAdjustment(array);

    }

    private void resize() {
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    private int deQueue() throws Exception {
        if (size <= 0) {
            throw new Exception("队列已经为空");
        }
        int data = array[0];
        size--;
        downAdjustment(array, 0);
        return data;
    }

    /**
     * 上浮
     *
     * @param array
     */
    private void upAdjustment(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (array[parentIndex] > temp && childIndex > 0) {
            //无须真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;

    }

    /**
     * 下沉调整
     *
     * @param array
     */
    private static void downAdjustment(int[] array, int parentIndex) {
        int length = array.length;
        // 左子节点下标
        int childIndex = parentIndex * 2 + 1;
        int temp = array[parentIndex];
        while (childIndex < length) {
            // 如果左子节点大于右子节点
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex = childIndex + 1;
            }
            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;

        }
        array[parentIndex] = temp;

    }

}
