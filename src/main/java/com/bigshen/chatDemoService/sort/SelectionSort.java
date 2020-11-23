package com.bigshen.chatDemoService.sort;

import java.util.Arrays;

/**
 * @Description:ѡ������
 * @Author: BIGSHEN
 * @Date: 2019/12/5 20:30
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={1,3,2,45,67,55,88};
        System.out.println("����֮ǰ��\n"+ Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("����֮��\n"+Arrays.toString(arr));
    }

    /**
     * ѡ�����򷽷�
     * @param array ����
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[index])
                    index = j;
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
