package com.bikercoder.study.algorithm.sort;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description： 堆排序。例如最小堆，父节点都小于左右子节点，堆顶的元素是最小的元素。
 * 删除堆顶的元素(实际不删除，而是和最后的子节点交换位置)，用最后一个子节点暂时代替堆顶的位置，再做下沉调整。
 * 调整后，堆顶又是最小的元素，再继续做删除堆顶操作，再做下沉调整。这样得到的就是一个从大到小的有序数组
 * @date：12/27/20 4:36 PM
 **/
public class HeapSort {

    public static void heapSort(int[] array){
        int length = array.length;
        for (int i  = (length - 2)/2; i >= 0; i --){
            downAdjustment(array, i, length);
        }
        System.out.println("构建最小堆后的数组："+ Arrays.toString(array));
        // 循环下沉调整
        for (int i = length - 1; i > 0; i--) {
            // 交换堆顶元素和第i个元素，再进行下沉调整
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            downAdjustment(array, 0, i);
        }
        System.out.println("排序后的数组"+ Arrays.toString(array));
    }
    /**
     * 下沉调整
     * @param array
     */
    private static void downAdjustment(int[] array, int parentIndex, int length){
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

    public static void main(String[] args) {
        int[] array = new int[]{2,4,1,7,8,6,5,0};
        heapSort(array);
    }

}
