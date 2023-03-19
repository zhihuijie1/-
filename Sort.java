package Novice_class;

import java.util.Arrays;

public class Sort {

    // 选择排序
    public static void SelectSort(int[] arr) {
        if(arr == null || arr.length <2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minValueIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                minValueIndex = arr[minValueIndex] > arr[j] ? j : minValueIndex;
            }
            swap(minValueIndex, i, arr);
        }
    }

    // 冒泡排序
    public static void bubbleSrot(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        int n = array.length;
        for (int end = n-1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if(array[i] > array[i+1]) {
                    swap(i,i+1,array);
                }
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        for (int end = 1; end < array.length; end++) {
            int curIndex = end;
            while(curIndex-1 >= 0 && array[curIndex-1] > array[curIndex]) {
                swap(curIndex, curIndex-1, array);
                curIndex--;
            }
        }
    }

    public static void insertSort2(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        for (int end = 1; end < array.length; end++) {
            for (int i = end-1;i >= 0 && array[i] > array[i+1] ; i--) {
                swap(i,i+1,array);
            }
        }
    }

    public static void swap(int minValueIdex , int i, int[] arr) {
        int temp = arr[minValueIdex];
        arr[minValueIdex] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        insertSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
