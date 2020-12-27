package com.bikercoder.study.algorithm.tree;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description：   《小灰的算法之旅》二叉堆 最小堆
 * @date：12/20/20 9:37 PM
 **/
public class BinaryHeap {
    public static void main(String[] args) {

        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjustment(array);
        array = new int[]{12,3,4,7,9,5,6,10};
        downAdjustment(array,0);
        System.out.println(Arrays.toString(array));
        buildHeap(array);
    }

    /**
     *  最小堆新添加元素时，再上浮调整
     * @param array
     */
    private static void upAdjustment(int[] array){
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (array[parentIndex] > temp && childIndex > 0){
            //无须真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;

    }


    /**
     * 删除元素时，删除堆顶元素，用最后一个子节点元素暂时代替堆顶位置，再下沉调整
     * @param array
     */
    private static void downAdjustment(int[] array, int parentIndex){
        int length = array.length;
        // 左子节点下标
        int childIndex = parentIndex * 2 + 1;
        int temp = array[parentIndex];
        while (childIndex < length){
            // 如果左子节点大于右子节点
            if(childIndex + 1 < length && array[childIndex + 1] < array[childIndex]){
                childIndex = childIndex + 1;
            }
            if(temp <= array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;

        }
        array[parentIndex] = temp;

    }

    // 从最后一个非叶子节点开始，依次做“下沉”调整
    public static void buildHeap(int[] array) {
        for (int i = (array.length-2)/2; i>=0; i--) {
            downAdjustment(array, i);
        }
    }

}
