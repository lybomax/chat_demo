package com.bigshen.chatDemoService.sort;

import java.util.Arrays;

/**
 * @ClassName CountingSort
 * @Description: TODO  计数排序
 * @Author BYJ
 * @Date 2020/8/30
 * @Version V1.0
 **/
public class CountingSort {


    /**
     * 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
     */
    public static void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        // 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int score[] = {12, 89, 43, 34, 56};
        System.out.println("排序前的数组：" + Arrays.toString(score));
        countingSort(score, score.length);
        System.out.println("排列后的数组: " + Arrays.toString(score));
    }
}
