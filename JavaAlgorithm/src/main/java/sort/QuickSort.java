package sort;

import java.util.Arrays;

/**
 * Created by noonbiteun
 * Date: 2017/7/31
 */
public class QuickSort {
    public static void sort(int[] arr, int left, int right) {
        int base = arr[(left + right) / 2];//基准数
        int lt = left;//左端索引
        int rt = right;//右端索引
        int tmp;//数据暂存，交换时使用
        while (lt < rt) {
            while (arr[lt] < base) {
                //左索引往后移，直到找到不小于base的数才停下来
                lt++;
            }
            while (arr[rt] > base) {
                //右索引往前移，直到找到比不大于base的数才停下来
                rt--;
            }
            if (lt <= rt) {
                //交换此时两个索引所指的数
                tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                //索引更新
                lt++;
                rt--;
            }
        }
        if (lt == rt) {
            lt++;
            rt--;
        }
        if (left < rt) {
            //递归，排左索引前面的数
            sort(arr, left, --lt);
        }
        if (right > lt) {
            //递归，排右索引后面的数
            sort(arr, ++rt, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[15];
        //初始化数组
        for (int i = 0; i < 15; i++) {
            arr[i] = (int) (Math.random() * (100 + 1));
        }
        System.out.println("排序前数据： "+ Arrays.toString(arr));
        QuickSort.sort(arr, 0, arr.length - 1);
        System.out.println("排序后数据： "+ Arrays.toString(arr));
    }
}
