package sort;

import java.util.Arrays;

/**
 * Created by zf
 * Date: 2017/7/31
 */
public class HeapSort {
    //建堆
    private static void heapConstruct(int[] arr, int last) {
        int tmp;
        for (int parent = (last - 1) / 2; parent >= 0; parent = (last-1) / 2) {
            if (2*parent+1 < last) {
                //第last个节点为右子树
                if (arr[last - 1] < arr[last]) {
                    //大的数据往前移
                    tmp = arr[last];
                    arr[last] = arr[last - 1];
                    arr[last - 1] = tmp;
                } else {
                    last--;
                }
            }
            if (arr[parent] < arr[last]) {
                //大的数据移到父节点
                tmp = arr[last];
                arr[last] = arr[parent];
                arr[parent] = tmp;
            }
            last--;
        }
    }

    private static void sort(int[] arr) {
        int last = arr.length - 1;
        int tmp;
        System.out.println("原始顺序： " + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            heapConstruct(arr, last);
            //第一个和最后一个交换
            tmp = arr[0];
            arr[0] = arr[last];
            arr[last] = tmp;
            last--;
            System.out.println("第" + i + "趟排序：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[50];
        //初始化数组
        for (int i = 0; i < 50; i++) {
            arr[i] = (int) (Math.random() * (100 + 1));
        }

        HeapSort.sort(arr);
    }
}
