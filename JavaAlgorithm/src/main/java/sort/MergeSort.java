package sort;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by zf
 * Date: 2017/8/1
 */
public class MergeSort {
    private static void merge(int[] unsortArr, int frontIndex, int backIndex, int lastIndex, int[] sortArr) {
        int i = frontIndex;//前半段的起始索引
        int j = backIndex;//后半段的起始索引
        int k = 0;
        //合并两个小分组
        while (i < backIndex && j < lastIndex) {
            if (unsortArr[i] < unsortArr[j]) {
                sortArr[k++] = unsortArr[i++];
            } else {
                sortArr[k++] = unsortArr[j++];
            }
        }
        while (i < backIndex) {
            //前半段还有数据
            sortArr[k++] = unsortArr[i++];
        }
        while (j < lastIndex) {
            //后半段还有数据
            sortArr[k++] = unsortArr[j++];
        }
        for (int l = 0; l < k; l++) {
            //将排序好的数放回
            unsortArr[frontIndex + l] = sortArr[l];
        }
    }


    public static void sort(int[] arr, int first, int last, int[] sorted) {
        if (first < last - 1) {
            int back = (first + last) / 2;
            sort(arr, first, back, sorted);
            sort(arr, back, last, sorted);
            merge(arr, first, back, last, sorted);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        //初始化数组
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * (100 + 1));
        }
        long t1 = new Date().getTime();
        System.out.println("原始的顺序： "+ Arrays.toString(arr));
        MergeSort.sort(arr, 0, arr.length, new int[arr.length]);
        long t2 = new Date().getTime();
        System.out.println("排序后顺序： "+ Arrays.toString(arr));
        System.out.println("耗时："+(t2-t1)+" ms");
    }
}
