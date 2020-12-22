package com.bikercoder.study.algorithm.sort;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description：《小灰的算法之旅》冒泡排序
 * @date：12/22/20 10:46 PM
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] data = new int[]{10,9,8,7,6,1,2,3,4,5,11,12,13,14};
        bubblSort3(data);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 普通的冒泡排序，需要进行length - 1轮比较
     * @param data
     */
    private static void bubblSort(int[] data) {
        int length = data.length;
        for (int i = 0; i < length - 1; i++){
            for (int j = 0; j < length - 1 - i; j++){
                if(data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    /**
     * 对比较的轮数做了优化，例如{10,9,8,7,6,1,2,3,4,5}
     * 再执行了无论比较后形成如下数据{1,2,3,4,5,6,7,8,9,10}已经是有序状态，再进行第六轮比较时就不会有数据的交换，则跳出循环
     * @param data
     */
    private static void bubblSort2(int[] data) {
        int length = data.length;

        for (int i = 0; i < length - 1; i++){
            boolean isChanged = false;
            for (int j = 0; j < length - 1 - i; j++){
                if(data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    // 该轮是否做了数据交换
                    isChanged = true;
                }
            }
            if(!isChanged){
                // 没有数据交换则已经是有序的数组，退出循环
                break;
            }
        }
    }

    /**
     * 在bubblSort2的基础上再进行优化，例如{10,9,8,7,6,1,2,3,4,5,11,12,13,14};
     * 再每一轮比较汇总数组末尾的11,12,13,14的已经是有序状态了，无需再进行比较；
     * 每轮比较后最后一次交换数据的位置，该位置则为已经排好序的边界
     * @param data
     */
    private static void bubblSort3(int[] data) {
        int length = data.length;

        // 记录已经排好序的边界
        int sortBorder = length - 1;
        // 记录每一轮排序中最后进行了数据交换的下标
        int lastExchangeIndex = 0;
        for (int i = 0; i < length - 1; i++){
            boolean isChanged = false;

            for (int j = 0; j < sortBorder; j++){
                if(data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    isChanged = true;
                    // 更新最后一次交换数据的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if(!isChanged){
                // 没有数据交换则已经是有序的数组，退出循环
                break;
            }
        }
    }
}
