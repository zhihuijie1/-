import java.util.Arrays;

public class HeapSort {
    /**
     * 堆排序的思路：
     * 第一步：将散列的数据建立大根堆
     * 第二步：将大根堆的头弹出放在队尾
     */

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        // 首先建大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // 再将大根堆的头弹出放在队尾
        TT(arr, arr.length);
    }

    // 向上调整
    public static void heapInsert(int[] arr, int index) {
        int father = (index - 1) / 2;
        while(arr[index] > arr[father]) {
            swap(arr, index, father);
            index = father;
            father = (index - 1) / 2;
        }
    }


    public static void swap1(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void TT(int[] arr, int usedSize) {
        while(usedSize > 1) {
            swap(arr, 0, usedSize-1);
            usedSize--;
            heapify(arr,0 ,usedSize);
        }
    }

    public static void heapify(int[] arr,int index, int usedSize) { // index:起始位置
        int left = index * 2 + 1;
        while(left < usedSize) {
            int large = left+1 < usedSize && arr[left+1] > arr[left] ? left+1 : left;
            if(arr[large] > arr[index]) {
                swap(arr, large, index);
            }else {
                break;
            }
            index = large;
            left = index * 2 + 1;
        }
    }

    // for Test

    public static void main(String[] args) {
        int testTime = 100000; // 测试次数
        int maxLength = 100; // 数组的最大长度
        int maxValue = 100; // 最大的值

        for (int i = 0; i < testTime; i++) {
            int length = (int)(Math.random() * maxLength + 1); // length:[0, 100]
            int[] arr1 = new int[length];
            for (int j = 0; j < length; j++) {
                int value = (int)(Math.random() * maxValue + 1); // value:[0,100]
                arr1[j] = value;
            }
            int[] arr2 = copyArray(arr1);
            Arrays.sort(arr2);
            heapSort(arr1);
            for (int j = 0; j < length; j++) {
                if(arr1[j] != arr2[j]) {
                    System.out.println("OOPS");
                    break;
                }
            }
        }
        System.out.println("FINSH");
    }

    public static int[] copyArray(int[] arr) {
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        return array;
    }
}
