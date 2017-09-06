package sort;

import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void sort(int[] arr) {
        int len = arr.length;
        int tmp;
        System.out.println("原始顺序： "+ Arrays.toString(arr));
        //i表示第几趟排序
        for (int i = 1; i < len; i++) {
            //每次都从最后一个开始，知道第len-1趟排序
            for (int j = len - 1; j > i-1; j--) {
                //如果后面的比前面的小，就像泡泡一样冒上去
                if (arr[j] < arr[j - 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
            System.out.println("第"+i+"趟排序: "+ Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        //初始化数组
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * (100 + 1));
        }
        long t1 = new Date().getTime();
        BubbleSort.sort(arr);
        long t2 = new Date().getTime();
        System.out.println("耗时："+(t2-t1));
    }
}
