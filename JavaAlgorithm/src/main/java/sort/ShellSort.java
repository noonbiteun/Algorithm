package sort;

import java.util.Arrays;

public class ShellSort {
    public static void sort(int[] arr) {
        int len = arr.length;
        int gap;//步长
        int istIndex;//插入位置索引
        int tmp;
        System.out.println("原始顺序： "+ Arrays.toString(arr));
        //按照步长来分组
        for(gap = len / 2; gap >= 1; gap /= 2) {
            //类似插入排序的方法
            for (int i = gap; i < len; i++) {
                tmp = arr[i];//取出暂存
                istIndex = i;//插入的位置
                while ((istIndex > (gap-1) && tmp < arr[istIndex - gap])) {
                    //插入位置往前移，寻找合适位置
                    arr[istIndex] = arr[istIndex - gap];
                    istIndex -= gap;
                }
                arr[istIndex] = tmp;
            }
            System.out.println("步长为"+gap+"的排序: "+ Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        //初始化数组
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * (100 + 1));
        }
        ShellSort.sort(arr);
    }
}
