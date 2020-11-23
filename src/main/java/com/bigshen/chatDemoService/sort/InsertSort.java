package com.bigshen.chatDemoService.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:��������
 * @Author: BIGSHEN
 * @Date: 2019/12/5 19:36
 */
public class InsertSort {

    private static <T extends Comparable<? super T>> void insertSort(T[] a) {
        for (int i = 0; i < a.length; i++) {
            T tmp = a[i];
            int j;
            for (j = i; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }
    public static void insertionSort(int[] array) {//12,32,4,23,2,45
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
    }


    /**
     ��������a��ʾ���飬n��ʾ�����С
     */
    public static void insertionSort(Integer[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // ���Ҳ����λ��
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // �����ƶ�
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            // ��������
            a[j+1] = value;
        }
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[8];
        for (int i = 0; i < 8; i++) {
            System.out.println("�������" + (i+1) + "����");
            Scanner scanner=new Scanner(System.in);
            arr[i]= scanner.nextInt();
        }
        System.out.println("����ǰ"+ Arrays.toString(arr));
        //insertSort(arr);
        insertionSort(arr,8);
        System.out.println("�����"+ Arrays.toString(arr));
    }

}
