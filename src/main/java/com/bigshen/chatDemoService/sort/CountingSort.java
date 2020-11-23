package com.bigshen.chatDemoService.sort;

import java.util.Arrays;

/**
 * @ClassName CountingSort
 * @Description: TODO  ��������
 * @Author BYJ
 * @Date 2020/8/30
 * @Version V1.0
 **/
public class CountingSort {


    /**
     * ��������a�����飬n�������С�����������д洢�Ķ��ǷǸ�������
     */
    public static void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // �������������ݵķ�Χ
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        // ����һ����������c���±��С[0,max]
        int[] c = new int[max + 1];
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // ����ÿ��Ԫ�صĸ���������c��
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // �����ۼ�
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        // ��ʱ����r���洢����֮��Ľ��
        int[] r = new int[n];
        // ��������Ĺؼ����裬�е������
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // �����������a����
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int score[] = {12, 89, 43, 34, 56};
        System.out.println("����ǰ�����飺" + Arrays.toString(score));
        countingSort(score, score.length);
        System.out.println("���к������: " + Arrays.toString(score));
    }
}
