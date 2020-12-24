package com.bikercoder.study.algorithm.sort;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description： 《小灰的算法之旅》快速排序，双边遍历法和单边遍历法
 * @date：12/24/20 9:47 PM
 **/
public class QuickSort {


    /**
     * 快速排序 单边遍历法
     * @param array 需要排序的数组
     * @param startIndex 开始的坐标
     * @param endIndex 结束的坐标
     */
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        // 递归分治，直到只有一个元素，无法再分则结束
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(array, startIndex, endIndex);
        quickSort(array,startIndex,pivotIndex - 1);
        quickSort(array,pivotIndex + 1, endIndex);

    }

    /**
     * 分治（单边遍历）
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition(int[] array, int startIndex, int endIndex) {
        // 基准元素
        int pivot = array[startIndex];
        int mark = startIndex;

        for (int i = startIndex+1; i <= endIndex; i ++) {
            if(array[i] < pivot) {
                // 小于基准元素则mark往右移动一位，并且该元素与mark所在坐标的元素交换位置
                mark ++;
                int temp = array[mark];
                array[mark] = array[i];
                array[i] = temp;
            }
        }
        // 所有元素遍历结束后，mark所在坐标的元素和基准元素位置交换
        array[startIndex] = array[mark];
        array[mark] = pivot;

        return mark;
    }

    /**
     *  分治，双边遍历法
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition2(int[] array, int startIndex, int endIndex) {
        // 基准元素
        int pivot = array[startIndex];
        int right = endIndex;
        int left = startIndex;
        while (right != left) {
            while (array[right] >= pivot && left < right) {
                right --;
            }
            while (array[left] <= pivot && left < right) {
                left ++;
            }
            // 交换左右指针的数据
            int temp = array[right];
            array[right] = array[left];
            array[left] = temp;
        }
        // 最后左右指针重合，交换基准元素和左右指针指向的元素
        array[startIndex] = array[right];
        array[right] = pivot;

        return right;
    }

    /**
     * 快速排序，双边遍历法
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort2(int[] array, int startIndex, int endIndex) {
        // 递归分治，直到只有一个元素，无法再分则结束
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition2(array, startIndex, endIndex);
        quickSort(array,startIndex,pivotIndex - 1);
        quickSort(array,pivotIndex + 1, endIndex);

    }

    public static void main(String[] args) {
        int[] array = new int[]{2,5,1,4,8,9,6};
        quickSort2(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
