package com.bikercoder.study.algorithm.sort;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description： 计数排序
 * @date：12/28/20 9:55 PM
 **/
public class CountSort {

    public static int[] countSort(int[] array){
        // 得到数组中的最大值
        int max = 0;
        for (int i = 0; i < array.length; i ++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // 根据max新建计数的数组
        int[] countArray = new int[max + 1];
        for (int i = 0; i < array.length ; i ++) {
            int index = array[i];
            countArray[index] ++;
        }
        int index = 0;
        // 输出排序后的数组
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i ++) {
            for (int j = 0; j < countArray[i]; j ++) {
                sortedArray[index] = i;
                index ++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,1,2,1,5,7,1,3,9,5,10};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
