package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] arr) {
        int len = arr.length;
        int tmp;//要插入的数据
        int istIndex;//插入位置索引
        System.out.println("原始顺序： " + Arrays.toString(arr));
        for (int i = 1; i < len; i++) {
            if (arr[i] < arr[i - 1]) {
                tmp = arr[i];
                istIndex = i;
                while (istIndex > 0 && arr[istIndex-1] > tmp) {
                    //插入位置往前移，寻找合适位置
                    arr[istIndex] = arr[istIndex - 1];
                    istIndex--;
                }
                arr[istIndex] = tmp;
            }
            System.out.println("第" + i + "趟排序：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        //初始化数组
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * (100 + 1));
        }
        InsertionSort.sort(arr);
    }
}
