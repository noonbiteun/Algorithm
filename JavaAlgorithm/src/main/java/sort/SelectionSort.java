package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] arr) {
        int len = arr.length;
        int slcIndex;
        int tmp;
        System.out.println("原始顺序： " + Arrays.toString(arr));
        for (int i = 0; i < len - 1; i++) {
            //依次选择前n-1个数，以索引作为依据
            slcIndex = i;
            for (int j = i + 1; j < len; j++) {
                //与被选中的数之后的每个数进行比较
                if (arr[j] < arr[slcIndex]) {
                    //存在更小的数，替换索引
                    slcIndex = j;
                }
            }
            //交换数据
            if (slcIndex != i) {
                tmp = arr[i];
                arr[i] = arr[slcIndex];
                arr[slcIndex] = tmp;
            }
            System.out.println("第" + (i + 1) + "趟排序：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        //初始化数组
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * (100 + 1));
        }
        SelectionSort.sort(arr);
    }
}
